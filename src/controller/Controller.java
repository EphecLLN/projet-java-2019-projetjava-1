/**
 *
 */
package controller;




import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Iterator;

import model.*;

import view.Vue;
import view.VueConsole;

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
	public String[] recupererImpNom() {
		// récupération des noms des implantations
		String[] imps = new String[20];
		int i = 0;
		for(Implantation uneImp : model.implantations)	{
			imps[i] = uneImp.getNom();
			i++;
		}
		return imps;

	}



	public int[] recupererImpId() {
		// récupération des noms des implantations
		int [] idd = new int[20];
		int i = 0;
		for(Implantation uneImp : model.implantations)	{
			idd[i] = uneImp.getId();
			i++;
		}
		return idd;

	}

	public void genererLocal(String txtNom, boolean localInfo, int[] chaises, int[] tables, Implantation implantation) throws SQLException {
		int estInfo = 0;
		if(localInfo) {
			estInfo = 1;
		}

		implantation.genererLocalEtMateriels(txtNom, estInfo, chaises, tables);

	}


	public String[] recupLocal(String nom) {

		String[] locaux = new String[10];
		int i = 0;
		Implantation uneImp = model.getImplantation(nom);
		for(Local loc : uneImp.getLocaux()) {
			locaux[i] = loc.toString();
			i++;
		}
		return locaux;

	}

	public String[] recupMatSpecNom(ArrayList<MaterielSpecial> matSpes) {
		String[] mats = new String[20];
		int i = 0;
		for(MaterielSpecial unMatSpe : matSpes) {
			mats[i] = unMatSpe.getNom() + "   -   " + unMatSpe.getEtat();
			i++;
		}
		return mats;
	}

	public void afficherTab(String[] tab) {
		for(String str : tab) {
			if(str != null) {
				vue.affiche(str);
			}
		}
	}

	public String[] recupInterventionNom(ArrayList<Intervention> inter) {
		String[] interventions = new String[100];
		int i = 0;
		for(Intervention uneInt : inter) {
			interventions[i] = uneInt.getNom();
			i++;
		}
		return interventions;
	}

	public String[] recupPC(ArrayList<Pc> pc) {
		System.out.println(pc.get(0).getNom() + " " + pc.get(1).getNom() + " " + pc.get(2).getNom() + " " + pc.get(3).getNom() + " ");
		String[] pcs = new String[100];
		int i = 0;
		for(Pc unPc : pc) {
			pcs[i] = unPc.getNom();
			i++;
		}
		System.out.println(pcs[0] + " "  + pcs[1] + " " + pcs[2] + " " + pcs[3]);
		return pcs;
	}



	public void addView(Vue vue) {
		this.vue = vue;
	}

	public Controller(Ecole model) {
		this.model = model;
	}

}
