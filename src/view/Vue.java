/**
 * 
 */
package view;


import java.util.Observer;

import controller.Controller;
import model.Adresse;
import model.Ecole;
import model.Implantation;



/**
 * @author Victoire
 *
 */
public abstract class Vue implements Observer{

	protected Ecole model; // Faut-il mettre les autres? si oui, comment?
	
	protected Controller controller;
	
	@SuppressWarnings("deprecation")
	public Vue(Ecole model, Controller controller) {
		this.model = model;
		this.controller = controller;
		model.addObserver(this);
	}
	
	public abstract void affiche(String string);
		
	public abstract void enableWarning();
	public abstract void disableWarning();
}
