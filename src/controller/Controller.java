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
	Ecole model; // même problème que dans la vue
	Vue vue;
	
	public Controller(Ecole model) {
		this.model = model;
	}
	
	//ajouter les méthodes
	
	public void addView(Vue vue) {
		this.vue = vue;
	}
}
