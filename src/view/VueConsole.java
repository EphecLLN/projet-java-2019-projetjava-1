/**
 *
 */
package view;

import java.sql.SQLException;
import java.util.Observable;
import java.util.Scanner;
import controller.Controller;
import model.*;

/**
 * @author Victoire
 *
 */
@SuppressWarnings({"deprecation", "resource"})
public class VueConsole extends Vue{
	protected Scanner sc;

	public VueConsole(Ecole model, Controller controller) {
		super(model, controller);
		update(null, null);
		sc = new Scanner(System.in);
		new Thread (new ReadInput()).start();
	}

	@Override
	public void update(Observable o, Object arg) {
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
			System.out.println("Connexion réussie !");
			while(true) {
				System.out.print("Dans quelle implantation êtes-vous? Veillez à bien écrire le nom de l'implantation \n Pour arrêter le programme tapez 'fin' \n");
				controller.afficherTab(controller.recupererImpNom());
				Scanner scan3 = new Scanner(System.in);
				imp = scan3.nextLine();
				if(imp.equals("fin")) {
					System.exit(0);
				}
				Implantation implantation = model.getImplantation(imp);
				System.out.println(implantation.getNom() + " - " + implantation.getAdresse());
				System.out.println("Nombre de locaux : " + implantation.nombreLocauxTotal());
				System.out.println("Nombre de locaux informatiques : " + implantation.nombreLocauxInformatiques());

				System.out.println("Que voulez-vous faire ? \n A : Choisir un local à afficher \n B : Ajouter un Local \n C : Menu utilisateur \n D : Ajouter une implantation");
				Scanner scan4 = new Scanner(System.in);
				var = scan4.nextLine();
				switch(var) {
				case "A":
					System.out.print("Quelle local souhaitez vous afficher ?\n");
					controller.afficherTab(controller.recupLocal(imp));
					Scanner scan5 = new Scanner(System.in);
					loc = scan5.nextLine();
					Local local = implantation.getLocal(loc);
					System.out.println("Matériels :");
					System.out.println("Chaises :");
					System.out.println("Neuf : "+ local.getNbChaises().getNeuf() +" | Bon : "+ local.getNbChaises().getBon() +" | Usé : "+ local.getNbChaises().getUse() +" | Critique : "+ local.getNbChaises().getCritique());
					System.out.println("Tables :");
					System.out.println("Neuf : "+ local.getNbTables().getNeuf() +" | Bon : "+ local.getNbTables().getBon() +" | Usé : "+ local.getNbTables().getUse() +" | Critique : "+ local.getNbTables().getCritique());
					System.out.println("Matériels spéciaux :");
					controller.afficherTab(controller.recupMatSpecNom(local.getMaterielsSpeciaux()));
					System.out.println("Interventions :");
					controller.afficherTab(controller.recupInterventionNom(local.getInterventions()));
					if(local.getClass().getSimpleName().equals("LocalInformatique")) {
						LocalInformatique localinfo = (LocalInformatique) local;
						System.out.println("Liste des PCs :");
						controller.afficherTab(controller.recupPC(localinfo.getPcs()));
					}
					System.out.println("\n A : Actualiser le matériel \n B : Modifier un matériel spécial \n C : Modifier une intervention \n D : Ajouter une intervention \n E : Ajouter un Matériel spécial");
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
						System.out.println("Veuillez introduire le nouveau nombre de table(s) en fonction de leur état");
						System.out.print("Neuf :");
						Scanner scan11 = new Scanner(System.in);
						tables[0] = Integer.parseInt(scan11.nextLine()); 
						System.out.print("Bon :");
						Scanner scan12 = new Scanner(System.in);
						tables[1] = Integer.parseInt(scan12.nextLine());
						System.out.print("Usé :");
						Scanner scan13 = new Scanner(System.in);
						tables[2] = Integer.parseInt(scan13.nextLine());
						System.out.print("Critique :");
						Scanner scan14 = new Scanner(System.in);
						tables[3] = Integer.parseInt(scan14.nextLine());	
						try {
							local.majMateriels(chaises, tables);
						} catch (SQLException e) {
						}
						break;
					case "B":
						String mats="", newEtat="";
						controller.afficherTab(controller.recupMatSpecNom(local.getMaterielsSpeciaux()));
						System.out.print("Veuillez indiquer le matériel spécial à modifier : ");
						Scanner scan15 = new Scanner(System.in);
						mats = scan15.nextLine();
						MaterielSpecial matspe = local.getMaterielSpecial(mats);
						System.out.print("Veuillez indiquer son nouvel état : ");
						Scanner scan16 = new Scanner(System.in);
						newEtat = scan16.nextLine();
						try {
							matspe.majMaterielSpecial(newEtat);
						} catch (SQLException e) {
						}
						break;
					case "C":
						String inter="", newNom="", newCom=""; 
						controller.afficherTab(controller.recupInterventionNom(local.getInterventions()));
						System.out.print("Veuillez indiquer l'intervention à modifier : ");
						Scanner scan17 = new Scanner(System.in);
						inter = scan17.nextLine();
						Intervention intervention = local.getIntervention(inter);
						System.out.print("Veuillez indiquer son nouveau nom : ");
						Scanner scan18 = new Scanner(System.in);
						newNom = scan18.nextLine();
						System.out.print("Veuillez indiquer son nouveau commentaire : ");
						Scanner scan19 = new Scanner(System.in);
						newCom = scan19.nextLine();
						try {
							intervention.majIntervention(newNom, newCom);
						} catch (SQLException e) {
						}
						break;
					case "D":
						String nomI="", com="";
						System.out.println("Nouvelle intervention :");
						System.out.print("Veuillez indiquer son nom : ");
						Scanner scan20 = new Scanner(System.in);
						nomI = scan20.nextLine();
						System.out.print("Veuillez indiquer un commentaire : ");
						Scanner scan21 = new Scanner(System.in);
						com = scan21.nextLine();
						try {
							local.genererIntervention(nomI, com);
						} catch (SQLException e) {
						}
						break;
					case "E":
						String nomMS ="", etatMS="";
						System.out.println("Nouveau matériel spécial :");
						System.out.print("Veuillez indiquer son nom : ");
						Scanner scan22 = new Scanner(System.in);
						nomMS = scan22.nextLine();
						System.out.print("Veuillez indiquer son état : ");
						Scanner scan23 = new Scanner(System.in);
						etatMS = scan23.nextLine();
						try {
							local.genererMaterielSpecial(nomMS, etatMS);
						} catch (SQLException e) {
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
						String nomPc="", typePc="", tourPc="", ecranPc="", clavierPc="", sourisPc="", commentairesPc="";
						LocalInformatique localinfo2 = (LocalInformatique) local;
						System.out.print("Nom du PC (PCXXX ex : PC001) :");
						Scanner scan41 = new Scanner(System.in);
						nomPc = scan41.nextLine();
						System.out.print("Type :");
						Scanner scan42 = new Scanner(System.in);
						typePc = scan42.nextLine();
						System.out.print("Tour :");
						Scanner scan43 = new Scanner(System.in);
						tourPc = scan43.nextLine();
						System.out.print("Ecran :");
						Scanner scan44 = new Scanner(System.in);
						ecranPc = scan44.nextLine();
						System.out.print("Clavier :");
						Scanner scan45 = new Scanner(System.in);
						clavierPc = scan45.nextLine();
						System.out.print("Souris :");
						Scanner scan46 = new Scanner(System.in);
						sourisPc = scan46.nextLine();
						System.out.print("Commentaires :");
						Scanner scan47 = new Scanner(System.in);
						commentairesPc = scan47.nextLine();
						try {
							localinfo2.genererPc(nomPc, typePc, tourPc, ecranPc, clavierPc, sourisPc, commentairesPc);
						} catch (SQLException e1) {
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
					System.out.println("Veuillez introduire le nouveau nombre de chaise(s) en fonction de leur état");
					System.out.print("Neuf :");
					Scanner scan26 = new Scanner(System.in);
					chaisesNL[0] = Integer.parseInt(scan26.nextLine()); 
					System.out.print("Bon :");
					Scanner scan27 = new Scanner(System.in);
					chaisesNL[1] = Integer.parseInt(scan27.nextLine());
					System.out.print("Usé :");
					Scanner scan28 = new Scanner(System.in);
					chaisesNL[2] = Integer.parseInt(scan28.nextLine());
					System.out.print("Critique :");
					Scanner scan29 = new Scanner(System.in);
					chaisesNL[3] = Integer.parseInt(scan29.nextLine());
					System.out.println("Veuillez introduire le nouveau nombre de table(s) en fonction de leur état");
					System.out.print("Neuf :");
					Scanner scan30 = new Scanner(System.in);
					tablesNL[0] = Integer.parseInt(scan30.nextLine()); 
					System.out.print("Bon :");
					Scanner scan31 = new Scanner(System.in);
					tablesNL[1] = Integer.parseInt(scan31.nextLine());
					System.out.print("Usé :");
					Scanner scan32 = new Scanner(System.in);
					tablesNL[2] = Integer.parseInt(scan32.nextLine());
					System.out.print("Critique :");
					Scanner scan33 = new Scanner(System.in);
					tablesNL[3] = Integer.parseInt(scan33.nextLine());
					try {
						controller.genererLocal(nomNL, localInfo, chaisesNL, tablesNL, implantation);
					} catch (SQLException e) {
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
						System.out.print("Veuillez indiquer son prénom :");
						Scanner scan36 = new Scanner(System.in);
						prenomU = scan36.nextLine();
						System.out.print("Veuillez indiquer son grade : Super administrateur : 0, Administrateur d'implantation : 1, Informaticien : 2, Utilisateur : 3");
						Scanner scan37 = new Scanner(System.in);
						gradeU = Integer.parseInt(scan37.nextLine());
						System.out.print("Veuillez indiquer son pseudo :");
						Scanner scan38 = new Scanner(System.in);
						pseudoU = scan38.nextLine();
						System.out.print("Veuillez indiquer son mot de passe :");
						Scanner scan39 = new Scanner(System.in);
						mdpU = scan39.nextLine();
						try {
							implantation.genererUtilisateur(nomU, prenomU, gradeU, pseudoU, mdpU);
						} catch (SQLException e) {
						}
						break;
					}
					break;
				case "D":
					String nomI="", rueI="", villeI="";
					int numeroI = 0, codePostalI = 0;
					System.out.println("Generer une implantation :");
					System.out.print("Nom : ");
					Scanner scan48 = new Scanner(System.in);
					nomI = scan48.nextLine();
					System.out.println("Adresse :");
					System.out.print("Numero : ");
					Scanner scan49 = new Scanner(System.in);
					numeroI = Integer.parseInt(scan49.nextLine());
					System.out.print("Rue : ");
					Scanner scan50 = new Scanner(System.in);
					rueI = scan50.nextLine();
					System.out.print("Code Postal : ");
					Scanner scan51 = new Scanner(System.in);
					codePostalI = Integer.parseInt(scan51.nextLine());
					System.out.print("Ville : ");
					Scanner scan52 = new Scanner(System.in);
					villeI = scan52.nextLine();
					try {
						model.genererImplantationEtAdresse(nomI, numeroI, rueI, codePostalI, villeI);
					} catch (SQLException e) {
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
