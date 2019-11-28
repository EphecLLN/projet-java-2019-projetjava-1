/**
 * 
 */
package test;

import controller.Controller;
import model.Adresse;
import model.Local;
import view.VueConsole;

/**
 * @author Victoire
 *
 */


public class MVC {

	public MVC(){
		//création du modèle
		//même problème du coup j'utilise Adresse pour pouvoir faire la suite
		
		Local mod = new Local(0, null, null, null, null);
		Adresse mod2 = new Adresse(0, 0, 0, null, null);
		
		//création des controlleurs -> un pour chaque vue -> pour le moment il n'y a que la vue console
		
		Controller contrConsoleLocal = new Controller(mod);
		Controller contrConsoleAdresse = new Controller(mod2);
		
		//création des vues
		VueConsole vc = new VueConsole(mod, contrConsoleLocal, mod2, contrConsoleAdresse);
		
		//on donne la référence à la vue pour chaque controlleur
		contrConsoleLocal.addView(vc);
		contrConsoleAdresse.addView(vc);
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new MVC();
	}

}
