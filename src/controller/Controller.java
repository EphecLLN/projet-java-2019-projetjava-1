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
	
	
	public Controller(Ecole modelLocal) {
		this.model = modelLocal;
	}
	
	
	//ajouter les méthodes
	
	public void addView(Vue vue) {
		this.vue = vue;
	}
}
