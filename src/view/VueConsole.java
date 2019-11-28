/**
 * 
 */
package view;

import java.lang.ModuleLayer.Controller;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import model.Adresse;
import model.Test;


/**
 * @author Victoire
 *
 */
public class VueConsole extends Vue implements Observer{
	protected Scanner sc;

	public VueConsole(Test model, Controller controller) {
		super(model, controller);
		update(null, null);
		sc = new Scanner(System.in);
		new Thread (new ReadInput()).start();
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
		System.out.println(model);
		
	}
	
	private class ReadInput implements Runnable{
		public void run() {
			while(true) {
				try { // compl�ter tout �a
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

	@Override
	public void enableWarning() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disableWarning() {
		// TODO Auto-generated method stub
		
	}
	
	 
}
