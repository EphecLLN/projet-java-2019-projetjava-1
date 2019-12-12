/**
 *
 */
package controller;




import java.sql.SQLException;


import com.sun.org.apache.xalan.internal.xsltc.compiler.Parser;

import model.*;
import view.Vue;

/**
 * @author Victoire
 *
 */
public class Controller {
	
/////////////////////////////////*ATTRIBUTS*//////////////////////////////////////////////////////////////////////////////////////////////

	public Ecole model;
	Vue vue;

/////////////////////////////////*CONSTRUCTEURS*//////////////////////////////////////////////////////////////////////////////////////////
	

/////////////////////////////////*METHODES*//////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * méthode qui permet de se logger et de récuperer les données en les testant en bdd
	 * @param user
	 * @param mdp
	 * 
	 */
	public int[] login(String user, String mdp) {

		int[] tab = {0, 0, 0};

		for(Implantation uneImp : model.implantations) {
			for(Utilisateur unUti : uneImp.getUtilisateurs()) {
				if(unUti.getPseudo().equals(user)) {
					if(unUti.getMotDePasse().equals(mdp)){
						tab[0] = 1;
						tab[1] = unUti.getGrade();
						tab[2] = uneImp.getId();
					}
				}
			}
		}
		return tab;
	}
	
	
	/**
	 * Méthode qui récupère les noms des implantations
	 * 
	 * 
	 */
	public String[] recupererImp() {
		// récupération des noms des implantations
		String[] imps = new String[20]; 
		int i = 0;
		for(Implantation uneImp : model.implantations)	{	
			imps[i] = uneImp.getNom();
			i++;
		}
		return imps;

	}
	
	public String[] recupLocal(String nom) {
		
		String[] locaux = new String[100];
		int i = 0;
		for(Implantation uneImp : model.implantations) {
			if(uneImp.getNom() == nom) {
				for(Local loc : uneImp.getLocaux()) {
					locaux[i] = loc.toString();
					i++;
				}
				break;
			}
		}
		return locaux;
		
	}
	
	/*
	public int nbLocal() {
		//TODO LOUIS
	}
	*/
	

	public void addView(Vue vue) {
		this.vue = vue;
	}
	
	public Controller(Ecole model) {
		this.model = model;
	}


	public void afficherClasses() {
		//for(int i = 0; i < model.locals.size(); i++) {
			//vue.affiche(model.locals.get(i).toString());
		//}
	}
}
