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
		
		//System.out.println(model.);
		
	}
	
	private class ReadInput implements Runnable{
		public void run() {
			while(true) {
				try { // compléter tout ça
					String c = sc.next();
					if(c.length() != 1) {
						affiche("Format d'input incorrect");
					}
					
					
				}
				catch(Exception e){
					
				}
			}
		}
	}

	
	public void affiche(String string) {
		
		System.out.println(string);
	}

	
	
	 
}
