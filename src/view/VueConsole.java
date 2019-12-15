/**
 *
 */
package view;


import java.sql.SQLException;
import java.util.Observable;

import java.util.Observer;
import java.util.Scanner;

import controller.Controller;
import model.*;



/**
 * @author Victoire
 *
 */
public class VueConsole extends Vue implements Observer{
	protected Scanner sc;

	public VueConsole(Ecole model, Controller controller) {
		super(model, controller);
		update(null, null);
		sc = new Scanner(System.in);
		new Thread (new ReadInput()).start();
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		//System.out.println("Bonjour");
	}

	public class ReadInput implements Runnable{
		public void run() {
			while(true) {
				// completer tout �a
					String pseudo = "", mdp = "" , imp = "",var = "", var2= "", loc = "";
					do {
						System.out.print("Utilisateur : ");
						Scanner scan = new Scanner (System.in);
						pseudo = scan.nextLine();
						System.out.print("Mot de passe : ");
						Scanner scan2 = new Scanner(System.in);
						mdp = scan2.nextLine();
					}
					while(!(controller.login(pseudo, mdp)[0] == 1));
					System.out.println("Connexion r�ussie !");

					System.out.print("Dans quelle implantation �tes-vous? Veuillez � bien �crire le nom de l'implantation \n");
					controller.afficherTab(controller.recupererImpNom());
					Scanner scan3 = new Scanner(System.in);
					imp = scan3.nextLine();
					Implantation implantation = model.getImplantation(imp);
					System.out.println(implantation.getNom() + " - " + implantation.getAdresse());
					System.out.println("Nombre de locaux : " + implantation.nombreLocauxTotal());
					System.out.println("Nombre de locaux informatique : " + implantation.nombreLocauxInformatiques());
					
					System.out.println("Que voulez-vous faire ? \n A : Choisir un local à afficher \n B : Ajouter un Local \n C : Menu utilisateur");
					Scanner scan4 = new Scanner(System.in);
					var = scan4.nextLine();
					
					switch(var) {
					case "A":
						System.out.print("Quelle local souhaitez vous afficher ?\n");
						controller.afficherTab(controller.recupLocal(imp));
						Scanner scan5 = new Scanner(System.in);
						loc = scan5.nextLine();
						Local local = implantation.getLocal(loc);
						System.out.println("Materiels :");
						System.out.println("Chaises :");
						System.out.println("Neuf : "+ local.getNbChaises().getNeuf() +" | Bon : "+ local.getNbChaises().getBon() +" | Use : "+ local.getNbChaises().getUse() +" | Critique : "+ local.getNbChaises().getCritique());
						System.out.println("Tables :");
						System.out.println("Neuf : "+ local.getNbTables().getNeuf() +" | Bon : "+ local.getNbTables().getBon() +" | Use : "+ local.getNbTables().getUse() +" | Critique : "+ local.getNbTables().getCritique());
						System.out.println("Materiels special :");
						controller.afficherTab(controller.recupMatSpecNom(local.getMaterielsSpeciaux()));
						System.out.println("Intervention :");
						controller.afficherTab(controller.recupInterventionNom(local.getInterventions()));
						System.out.println("\n A : Actualiser le materiel \n B : Modifier un materiel special \n C : Modifier une intervention \n D : Ajouter une intervention \n E : Ajouter un Materiel special");
						Scanner scan6 = new Scanner(System.in);
						var2 = scan6.nextLine();
						switch(var2) {
						case "A":
							int[] chaises = new int[4];
							int[] tables = new int [4];
							System.out.println("Veuillez introduire le nouveau nombre de chaise en fonction de leur état");
							System.out.print("Neuf :");
							Scanner scan7 = new Scanner(System.in);
							chaises[0] = Integer.parseInt(scan7.nextLine()); 
							System.out.print("Bon :");
							Scanner scan8 = new Scanner(System.in);
							chaises[1] = Integer.parseInt(scan8.nextLine());
							System.out.print("Use :");
							Scanner scan9 = new Scanner(System.in);
							chaises[2] = Integer.parseInt(scan9.nextLine());
							System.out.print("Critique :");
							Scanner scan10 = new Scanner(System.in);
							chaises[3] = Integer.parseInt(scan10.nextLine());
							System.out.println("Veuillez introduire le nouveau nombre de table en fonction de leur état");
							System.out.print("Neuf :");
							Scanner scan11 = new Scanner(System.in);
							tables[0] = Integer.parseInt(scan11.nextLine()); 
							System.out.print("Bon :");
							Scanner scan12 = new Scanner(System.in);
							tables[1] = Integer.parseInt(scan12.nextLine());
							System.out.print("Use :");
							Scanner scan13 = new Scanner(System.in);
							tables[2] = Integer.parseInt(scan13.nextLine());
							System.out.print("Critique :");
							Scanner scan14 = new Scanner(System.in);
							tables[3] = Integer.parseInt(scan14.nextLine());	
							try {
								local.majMateriels(chaises, tables);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						case "B":
							String mats="", newEtat="";
							controller.afficherTab(controller.recupMatSpecNom(local.getMaterielsSpeciaux()));
							System.out.print("Veuillez indiquer le materiel special a modifier");
							Scanner scan15 = new Scanner(System.in);
							mats = scan15.nextLine();
							MaterielSpecial matspe = local.getMaterielSpecial(mats);
							System.out.print("Veuillez indiquer son nouvel etat");
							Scanner scan16 = new Scanner(System.in);
							newEtat = scan16.nextLine();
							try {
								matspe.majMaterielSpecial(newEtat);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						case "C":
							String inter="", newNom="", newCom=""; 
							controller.afficherTab(controller.recupInterventionNom(local.getInterventions()));
							System.out.print("Veuillez indiquer l'intervention a modifier");
							Scanner scan17 = new Scanner(System.in);
							inter = scan17.nextLine();
							Intervention intervention = local.getIntervention(inter);
							System.out.print("Veuillez indiquer son nouveau nom");
							Scanner scan18 = new Scanner(System.in);
							newNom = scan18.nextLine();
							System.out.print("Veuillez indiquer son nouveau commentaire");
							Scanner scan19 = new Scanner(System.in);
							newCom = scan19.nextLine();
							try {
								intervention.majIntervention(newNom, newCom);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						case "D":
							String nomI="", com="";
							System.out.println("Nouvelle intervention :");
							System.out.print("Veuillez indiquer son nom :");
							Scanner scan20 = new Scanner(System.in);
							nomI = scan20.nextLine();
							System.out.print("Veuillez indiquer un commentaire");
							Scanner scan21 = new Scanner(System.in);
							com = scan21.nextLine();
							try {
								local.genererIntervention(nomI, com);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						case "E":
							String nomMS ="", etatMS="";
							System.out.println("Nouveau materiel special :");
							System.out.print("Veuillez indiquer son nom :");
							Scanner scan22 = new Scanner(System.in);
							nomMS = scan22.nextLine();
							System.out.print("Veuillez indiquer son etat");
							Scanner scan23 = new Scanner(System.in);
							etatMS = scan23.nextLine();
							try {
								local.genererMaterielSpecial(nomMS, etatMS);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						}
						break;
					case "B":
						
						break;
					
					case "C":
						
						break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + var);	
					}
					
					
			}}}
					
					
					
					
/*
					System.out.print("Que voulez-vous faire? A pour calculer un nombre total de locaux, B pour afficher l'ensemble des locaux, C pour interragir avec le mat�riel ");
					Scanner scan4 = new Scanner(System.in);
					var = scan4.nextLine();

					switch(var) {
					case "A":
						//System.out.println("Le nombre total de locaux s'�l�ve à " + controller.model.implantations.locals.size());
						break;
					case "B":
						//controller.afficherClasses();
						break;
					case "C" :
						System.out.print("Que voulez-vous faire? A pour changer l'�tat du mat�riel, B pour afficher le total du mat�riel ");
						Scanner scan5 = new Scanner(System.in);
						var2 = scan5.nextLine();
						switch(var2) {
						case "A":
							System.out.println("� impl�menter");
							break;
						case "B":
							System.out.println(controller.model.implantations.size()); // A CHANGER
							break;
						default:
							throw new IllegalArgumentException("Unexpected value: " + var2);
						}
						break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + var);
					}
			}
		}
	}
*/

	public void affiche(String string) {
		System.out.println(string);
	}




}
