/**
 *
 */
package view;


import java.util.Observable;

import java.util.Observer;
import java.util.Scanner;

import controller.Controller;
import model.Ecole;



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
				// completer tout ï¿½a
					String pseudo = "", mdp = "" , imp = "",var = "", var2= "";
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

					System.out.print("Dans quelle implantation êtes-vous? Veuillez à bien écrire l'ID \n");
					for(int i=0; i< controller.recupererImpId().length;i++) {
						System.out.println(controller.recupererImpId()[i] + " " + controller.recupererImpNom()[i]);
					}
					Scanner scan3 = new Scanner(System.in);
					imp = scan3.nextLine();

					System.out.print("Que voulez-vous faire? A pour calculer un nombre total de locaux, B pour afficher l'ensemble des locaux, C pour interragir avec le matï¿½riel ");
					Scanner scan4 = new Scanner(System.in);
					var = scan4.nextLine();

					switch(var) {
					case "A":
						//System.out.println("Le nombre total de locaux s'ï¿½lï¿½ve Ã  " + controller.model.implantations.locals.size());
						break;
					case "B":
						controller.afficherClasses();
						break;
					case "C" :
						System.out.print("Que voulez-vous faire? A pour changer l'ï¿½tat du matï¿½riel, B pour afficher le total du matï¿½riel ");
						Scanner scan5 = new Scanner(System.in);
						var2 = scan5.nextLine();
						switch(var2) {
						case "A":
							System.out.println("ï¿½ implï¿½menter");
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


	public void affiche(String string) {
		System.out.println(string);
	}




}
