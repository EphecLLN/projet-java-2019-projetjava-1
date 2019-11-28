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
	
	private class ReadInput implements Runnable{
		public void run() {
			while(true) {
				// compléter tout ça
					String pseudo = "", mdp = "";
					System.out.println(model.utilisateurs.toString());
					do {
						System.out.print("Utilisateur : ");
						Scanner scan = new Scanner (System.in);
						pseudo = scan.nextLine();
						System.out.print("Mot de passe : ");
						Scanner scan2 = new Scanner(System.in);
						mdp = scan2.nextLine();
					}
					while(!controller.login(pseudo, mdp));
					System.out.println("Connexion réussie !");
			}
		}
	}

	
	public void affiche(String string) {
		
		System.out.println(string);
	}

	
	
	 
}
