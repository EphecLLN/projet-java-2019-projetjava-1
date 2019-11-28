/**
 * 
 */
package controller;



import model.Test;
import view.Vue;

/**
 * @author Victoire
 *
 */
public class Controller {
	Test model; // même problème que dans la vue
	Vue vue;
	
	public Controller(Test model) {
		this.model = model;
	}
	
	//ajouter les méthodes
	
	public void addView(Vue vue) {
		this.vue = vue;
	}
}
