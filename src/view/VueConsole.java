/**
 *
 */
package view;


import java.awt.desktop.SystemEventListener;
import java.sql.SQLException;
import java.util.Observable;

import java.util.Observer;
import java.util.Scanner;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Trim;

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
				// completer tout �a
					String pseudo = "", mdp = "" , imp = "",var = "", var2= "", loc = "", var3="";
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
					while(true) {
					System.out.print("Dans quelle implantation �tes-vous? Veuillez � bien �crire le nom de l'implantation \n Pour arreter le programme tapez 'fin' \n");
					controller.afficherTab(controller.recupererImpNom());
					Scanner scan3 = new Scanner(System.in);
					imp = scan3.nextLine();
					if(imp.equals("fin")) {
						System.exit(0);
					}
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
						if(local.getClass().getSimpleName().equals("LocalInformatique")) {
							LocalInformatique localinfo = (LocalInformatique) local;
							System.out.println("Liste des PC :");
							controller.afficherTab(controller.recupPC(localinfo.getPcs()));
						}
						System.out.println("\n A : Actualiser le materiel \n B : Modifier un materiel special \n C : Modifier une intervention \n D : Ajouter une intervention \n E : Ajouter un Materiel special");
						if(local.getClass().getSimpleName().equals("LocalInformatique")) {
							System.out.println(" F : Afficher les détails d'un PC \n G : Ajouter un PC");
						}
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
						case "F":
							String pcChoix="";
							LocalInformatique localinfo = (LocalInformatique) local;
							controller.afficherTab(controller.recupPC(localinfo.getPcs()));
							System.out.print("Quelle Pc voullez vous afficher ?");
							Scanner scan40 = new Scanner(System.in);
							pcChoix = scan40.nextLine();
							Pc pc = localinfo.getPc(pcChoix);
							System.out.println("Détail PC " + pc.getNom() +" :");
							System.out.println("Type : " + pc.getType());
							System.out.println("Tour : " + pc.getTour());
							System.out.println("Ecran : " + pc.getEcran());
							System.out.println("Clavier : " + pc.getClavier());
							System.out.println("Souris : " + pc.getSouris());
							System.out.println("Commentaires : " + pc.getCommentaires());
							break;
						case "G":
							String NomPc="", TypePc="", TourPc="", EcranPc="", ClavierPc="", SourisPc="", CommentairesPc="";
							LocalInformatique localinfo2 = (LocalInformatique) local;
							System.out.print("Nom du PC (PCXXX ex : PC001) :");
							Scanner scan41 = new Scanner(System.in);
							NomPc = scan41.nextLine();
							System.out.print("Type :");
							Scanner scan42 = new Scanner(System.in);
							TypePc = scan42.nextLine();
							System.out.print("Tour :");
							Scanner scan43 = new Scanner(System.in);
							TourPc = scan43.nextLine();
							System.out.print("Ecran :");
							Scanner scan44 = new Scanner(System.in);
							EcranPc = scan44.nextLine();
							System.out.print("Clavier :");
							Scanner scan45 = new Scanner(System.in);
							ClavierPc = scan45.nextLine();
							System.out.print("Souris :");
							Scanner scan46 = new Scanner(System.in);
							SourisPc = scan46.nextLine();
							System.out.print("Commentaires :");
							Scanner scan47 = new Scanner(System.in);
							CommentairesPc = scan47.nextLine();
							try {
								localinfo2.genererPc(NomPc, TypePc, TourPc, EcranPc, ClavierPc, SourisPc, CommentairesPc);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							break;
						}
						break;
					case "B":
						String nomNL="";
						int [] chaisesNL = new int[4];
						int [] tablesNL = new int[4];
						boolean localInfo;
						System.out.println("Ajout d'un local :");
						System.out.print("Veuillez introduir son nom (LXX, par exemple : L01)");
						Scanner scan24 = new Scanner(System.in);
						nomNL = scan24.nextLine();
						System.out.print("Veuillez indiquer si c'est un local informatique ('true' si c'est un local informatique, 'false' si c'est un local normal)");
						Scanner scan25 = new Scanner(System.in);
						localInfo = Boolean.parseBoolean(scan25.nextLine());
						System.out.println("Veuillez introduire le nouveau nombre de chaise en fonction de leur état");
						System.out.print("Neuf :");
						Scanner scan26 = new Scanner(System.in);
						chaisesNL[0] = Integer.parseInt(scan26.nextLine()); 
						System.out.print("Bon :");
						Scanner scan27 = new Scanner(System.in);
						chaisesNL[1] = Integer.parseInt(scan27.nextLine());
						System.out.print("Use :");
						Scanner scan28 = new Scanner(System.in);
						chaisesNL[2] = Integer.parseInt(scan28.nextLine());
						System.out.print("Critique :");
						Scanner scan29 = new Scanner(System.in);
						chaisesNL[3] = Integer.parseInt(scan29.nextLine());
						System.out.println("Veuillez introduire le nouveau nombre de table en fonction de leur état");
						System.out.print("Neuf :");
						Scanner scan30 = new Scanner(System.in);
						tablesNL[0] = Integer.parseInt(scan30.nextLine()); 
						System.out.print("Bon :");
						Scanner scan31 = new Scanner(System.in);
						tablesNL[1] = Integer.parseInt(scan31.nextLine());
						System.out.print("Use :");
						Scanner scan32 = new Scanner(System.in);
						tablesNL[2] = Integer.parseInt(scan32.nextLine());
						System.out.print("Critique :");
						Scanner scan33 = new Scanner(System.in);
						tablesNL[3] = Integer.parseInt(scan33.nextLine());
						try {
							controller.genererLocal(nomNL, localInfo, chaisesNL, tablesNL, implantation);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					
					case "C":
						System.out.println("A : Pour afficher les utilisateurs\nB : Pour ajouter un utilisateur");
						Scanner scan34 = new Scanner(System.in);
						var3 = scan34.nextLine();
						switch(var3) {
						case "A":
							System.out.println("Liste des utilisateur :");
							for(Utilisateur utilisateur : implantation.getUtilisateurs()) {
								System.out.println(utilisateur.getNom() + " " + utilisateur.getPrenom());
							}
							break;
						case "B":
							String nomU="", prenomU="", pseudoU="", mdpU="";
							int gradeU = 0;
							System.out.print("Veuillez indiquer son nom :");
							Scanner scan35 = new Scanner(System.in);
							nomU = scan35.nextLine();
							System.out.print("Veuillez indiquer son prenom :");
							Scanner scan36 = new Scanner(System.in);
							prenomU = scan36.nextLine();
							System.out.print("Veuillez indiquer son grade : Super administrateur : 0, Administrateur d'implantation : 1, Informaticien : 2, Utilisateur : 3");
							Scanner scan37 = new Scanner(System.in);
							gradeU = Integer.parseInt(scan37.nextLine());
							System.out.print("Veuillez indiquer son Pseudo :");
							Scanner scan38 = new Scanner(System.in);
							pseudoU = scan38.nextLine();
							System.out.print("Veuillez indiquer son mot de passe :");
							Scanner scan39 = new Scanner(System.in);
							mdpU = scan39.nextLine();
							try {
								implantation.genererUtilisateur(nomU, prenomU, gradeU, pseudoU, mdpU);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						}
						break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + var);	
					}
					
					
			}}}

	public void affiche(String string) {
		System.out.println(string);
	}




}
