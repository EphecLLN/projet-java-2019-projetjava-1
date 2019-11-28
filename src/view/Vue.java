/**
 * 
 */
package view;


import java.util.Observer;

import controller.Controller;
import model.Ecole;



/**
 * @author Victoire
 *
 */
public abstract class Vue implements Observer{

	
	
	
	protected Ecole model;
	protected Controller controller;
	
	@SuppressWarnings("deprecation")
	public Vue(Ecole model, Controller controller) {
		
		
	this.model = model;
	this.controller = controller;
		
		model.addObserver(this);
	}
	
	public abstract void affiche(String string);
		
	
}
