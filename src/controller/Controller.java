/**
 *
 */
package controller;




import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

//import com.sun.org.apache.xalan.internal.xsltc.compiler.Parser;

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
	 * m�thode qui permet de se logger et de r�cuperer les donn�es en les testant en bdd
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
	 * M�thode qui r�cup�re les noms des implantations
	 *
	 *
	 */
	public String[] recupererImpNom() {
		// r�cup�ration des noms des implantations
		String[] imps = new String[20];
		int i = 0;
		for(Implantation uneImp : model.implantations)	{
			imps[i] = uneImp.getNom();
			i++;
		}
		return imps;

	}

	public int[] recupererImpId() {
		// r�cup�ration des noms des implantations
		int [] idd = new int[2];
		int i = 0;
		for(Implantation uneImp : model.implantations)	{
			idd[i] = uneImp.getId();
			i++;
		}
		return idd;

	}
	
	//public ArrayList<Local> recupererLocNom(String nomImplantation) {
		
	//}
	

	public String[] recupLocal(String nom) {

		String[] locaux = new String[100];
		int i = 0;
		Implantation uneImp = model.getImplantation(nom);
		for(Local loc : uneImp.getLocaux()) {
			locaux[i] = loc.toString();
			i++;
		}
		return locaux;

	}

	public void addView(Vue vue) {
		this.vue = vue;
	}
	
	public Controller(Ecole model) {
		this.model = model;
	}

	//M�thode permettant de r�cup�rer le nombre total de locaux
	public void totalLocaux() {
		//return model.Implantation.nombreLocauxTotal();
	}

	public ArrayList<Local> afficherImplantation(String nomImplantation) {
		Implantation limplantation = null;
		for(Implantation imp : model.implantations) {
			if (imp.getNom().equals(nomImplantation)) {
				limplantation = imp;
				break;
			}
		}
		return limplantation.getLocaux();
	}
}
