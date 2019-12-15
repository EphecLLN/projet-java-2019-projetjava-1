/**
 *
 */
package view;


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
					for(int i=0; i< controller.recupererImpId().length;i++) {
						System.out.println(controller.recupererImpId()[i] + " " + controller.recupererImpNom()[i]);
					}
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
						for(int i =0; i < controller.recupLocal(imp).length; i++) {
							System.out.println(controller.recupLocal(imp)[i]);
						}
						Scanner scan5 = new Scanner(System.in);
						loc = scan5.nextLine();
						Local local = implantation.getLocal(loc);
						System.out.println("Materiels :");
						System.out.println("Chaises :");
						System.out.println("Neuf : "+ local.getNbChaises().getNeuf() +" | Bon :"+ local.getNbChaises().getBon() +" | Use :"+ local.getNbChaises().getUse() +" | Critique :"+ local.getNbChaises().getCritique());
						System.out.println("Tables :");
						System.out.println("Neuf : "+ local.getNbTables().getNeuf() +" | Bon :"+ local.getNbTables().getBon() +" | Use :"+ local.getNbTables().getUse() +" | Critique :"+ local.getNbTables().getCritique());
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
