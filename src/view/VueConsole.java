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
				// completer tout �a
					String pseudo = "", mdp = "" , imp = "",var = "", var2= "";
					do {
						System.out.print("Utilisateur : ");
						Scanner scan = new Scanner (System.in);
						pseudo = scan.nextLine();
						System.out.print("Mot de passe : ");
						Scanner scan2 = new Scanner(System.in);
						mdp = scan2.nextLine();
					}
					while(!controller.login(pseudo, mdp));
					System.out.println("Connexion r�ussie !");

					System.out.print("Dans quelle implantation �tes-vous? ");
					Scanner scan3 = new Scanner(System.in);
					imp = scan3.nextLine();

					System.out.print("Que voulez-vous faire? A pour calculer un nombre total de locaux, B pour afficher l'ensemble des locaux, C pour interragir avec le mat�riel ");
					Scanner scan4 = new Scanner(System.in);
					var = scan4.nextLine();



					switch(var) {
					case "A":
						//System.out.println("Le nombre total de locaux s'�l�ve à " + controller.model.locals.size());
						break;
					case "B":
						controller.afficherClasses();
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


	public void affiche(String string) {
		System.out.println(string);
	}




}
