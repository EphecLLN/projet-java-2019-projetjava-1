/**
 * 
 */
package test;

import java.sql.SQLException;




import controller.Controller;

import model.Ecole;
import view.GUI;
import view.VueConsole;


/**
 * @author Victoire
 *
 */


public class MVC {

	public MVC() throws SQLException{
		
		//création du modèle
		
		
		Ecole mod = new Ecole();
		
		
		//création des controlleurs -> un pour chaque vue 
		
		Controller contrConsole = new Controller(mod);
		Controller contrGUI = new Controller(mod);
		
		
		//création des vues
	
		VueConsole vc = new VueConsole(mod, contrConsole);
		GUI g = new GUI(mod, contrGUI);
		
		//on donne la référence à la vue pour chaque controlleur
		contrConsole.addView(vc);
		contrGUI.addView(g);
		
	}
	
	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException{
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					new MVC();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
	}
}


