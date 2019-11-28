/**
 * 
 */
package test;

import java.sql.SQLException;
import java.util.Scanner;

import controller.Controller;

import model.Ecole;
import view.VueConsole;


/**
 * @author Victoire
 *
 */


public class MVC {

	public MVC() throws SQLException{
		//création du modèle
		//même problème du coup j'utilise Adresse pour pouvoir faire la suite
		
		Ecole mod = new Ecole();
		
		//création des controlleurs -> un pour chaque vue -> pour le moment il n'y a que la vue console
		
		Controller contrConsole = new Controller(mod);
		
		
		//création des vues
		VueConsole vc = new VueConsole(mod, contrConsole);
		
		//on donne la référence à la vue pour chaque controlleur
		contrConsole.addView(vc);
		
	}
	
	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		String pseudo = "", mdp = "";
			new MVC();
	}
}


