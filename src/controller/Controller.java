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
	Ecole model; // m�me probl�me que dans la vue
	Vue vue;
	
	public Controller(Ecole model) {
		this.model = model;
	}
	
	//ajouter les m�thodes
	
	public void addView(Vue vue) {
		this.vue = vue;
	}
}
