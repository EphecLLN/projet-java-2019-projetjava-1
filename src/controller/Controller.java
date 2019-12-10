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

	public Ecole model;
	Vue vue;


	public Controller(Ecole model) {
		this.model = model;
	}


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
	//ajouter les m�thodes

	public void addView(Vue vue) {
		this.vue = vue;
	}

	public void afficherClasses() {
		//for(int i = 0; i < model.locals.size(); i++) {
			//vue.affiche(model.locals.get(i).toString());
		//}
	}
}
