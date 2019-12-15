/**
 * 
 */
package view;


import java.util.Observer;

import controller.Controller;
import model.Ecole;
import model.Local;



/**
 * @author Victoire
 *
 */
@SuppressWarnings("deprecation")
public abstract class Vue implements Observer{

	
	
	
	protected Ecole model;
	protected Local modelLocal;
	protected Controller controller;
	
	public Vue(Ecole model, Controller controller) {
		
		
	this.model = model;
	this.controller = controller;
		
	model.addObserver(this);
	}
	
	public abstract void affiche(String string);
		
	
}
