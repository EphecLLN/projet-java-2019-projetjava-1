/**
 * 
 */
package view;

import java.lang.ModuleLayer.Controller;
import java.util.Observer;

import model.Adresse;
import model.Implantation;
import model.Test;



/**
 * @author Victoire
 *
 */
public abstract class Vue implements Observer{

	protected Test model; // Faut-il mettre les autres? si oui, comment?
	
	protected Controller controller;
	
	@SuppressWarnings("deprecation")
	public Vue(Test model, Controller controller) {
		this.model = model;
		this.controller = controller;
		model.addObserver(this);
	}
	
	public abstract void affiche(String string);
		
	public abstract void enableWarning();
	public abstract void disableWarning();
}
