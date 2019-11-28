/**
 * 
 */
package view;


import java.util.Observer;

import controller.Controller;
import model.Adresse;
import model.Local;




/**
 * @author Victoire
 *
 */
public abstract class Vue implements Observer{

	
	
	
	protected Local modelLocal;
	protected Controller controllerLocal;
	
	protected Adresse modelAdresse;
	protected Controller controllerAdresse;
	
	protected Implantation modelImplantation;
	protected Controller controllerImplantation;
	
	protected Intervention modelIntervention;
	protected Controller controllerIntervention;
	
	protected
	
	@SuppressWarnings("deprecation")
	public Vue(Local modelLocal, Controller controllerLocal, Adresse modelAdresse, Controller controllerAdresse) {
		
		
		this.modelLocal = modelLocal;
		this.controllerLocal = controllerLocal;
		
		this.modelAdresse = modelAdresse;
		this.controllerAdresse = controllerAdresse;
		
		
		modelLocal.addObserver(this);
		modelAdresse.addObserver(this);
	}
	
	public abstract void affiche(String string);
		
	
}
