/**
 * 
 */
package view;


import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import controller.Controller;
import model.Adresse;
import model.Local;


/**
 * @author Victoire
 *
 */
public class VueConsole extends Vue implements Observer{
	protected Scanner sc;

	public VueConsole(Local modelLocal, Controller controllerLocal, Adresse modelAdresse, Controller controllerAdresse) {
		super(modelLocal, controllerLocal, modelAdresse, controllerAdresse);
		update(null, null);
		sc = new Scanner(System.in);
		new Thread (new ReadInput()).start();
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
		//System.out.println();
		
	}
	
	private class ReadInput implements Runnable{
		public void run() {
			while(true) {
				try { // compléter tout ça
					String c = sc.next();
					
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
