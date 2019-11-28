/**
 * 
 */
package controller;




import model.Ecole;
import view.Vue;

/**
 * @author Victoire
 *
 */
public class Controller {

	Ecole model;
	Vue vue;
	
	
	public Controller(Ecole model) {
		this.model = model;
	}
	
	public boolean login(String user, String mdp) {
		
		// A revoir
		
		/*boolean res = false;
		for(int i = 0; i < model.utilisateurs.size(); i++) {
			if(model.utilisateurs.get(i).getPseudo() == user) {
				if(model.utilisateurs.get(i).getMotDePasse() == mdp) {
					res = true;
				}
			}
		}*/
		return true;
	}
	//ajouter les m�thodes
	
	public void addView(Vue vue) {
		this.vue = vue;
	}
	
	public void afficherClasses() {
		for(int i = 0; i < model.locals.size(); i++) {
			vue.affiche(model.locals.get(i).toString());
		}
	}
}
