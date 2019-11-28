/**
 * 
 */
package test;

import java.lang.ModuleLayer.Controller;

import model.Adresse;
import model.Implantation;
import model.Test;
import view.VueConsole;

/**
 * @author Victoire
 *
 */
public class MVC {

	public MVC(){
		//cr�ation du mod�le
		//m�me probl�me du coup j'utilise Adresse pour pouvoir faire la suite
		Test mod = new Test();
		
		//cr�ation des controlleurs -> un pour chaque vue -> pour le moment il n'y a que la vue console
		Controller contrConsole = new Controller(mod);
		
		//cr�ation des vues
		VueConsole vc = new VueConsole(mod, contrConsole);
		
		//on donne la r�f�rence � la vue pour chaque controlleur
		contrConsole.addView(vc);
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}