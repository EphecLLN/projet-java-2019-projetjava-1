/**
 * 
 */
package controller;



import model.Adresse;
import model.Implantation;
import model.Intervention;
import model.Local;
import model.LocalInformatique;
import model.MaterielSpecial;
import model.Materiels;
import model.Pc;
import model.Utilisateur;
import view.Vue;

/**
 * @author Victoire
 *
 */
public class Controller {
	
	Local modelLocal;
	Adresse modelAdresse;
	Implantation modelImplantation;
	Intervention modelIntervention;
	LocalInformatique modelLocalInformatique;
	Materiels modelMateriel;
	MaterielSpecial modelMaterielSpecial;
	Pc modelPc;
	Utilisateur modelUtilisateur;
	
	Vue vue;
	
	
	public Controller(Local modelLocal) {
		this.modelLocal = modelLocal;
	}
	
	public Controller(Adresse modelAdresse) {
		this.modelAdresse = modelAdresse;
	}
	
	public Controller(Implantation modelImplantation) {
		this.modelImplantation = modelImplantation;
	}
	
	public Controller(Intervention modelIntervention) {
		this.modelIntervention = modelIntervention;
	}
	
	public Controller(LocalInformatique modelLocalInformatique) {
		this.modelLocalInformatique = modelLocalInformatique;
	}
	
	public Controller(Materiels modelMateriel) {
		this.modelMateriel = modelMateriel;
	}
	
	public Controller(MaterielSpecial modelMaterielSpecial) {
		this.modelMaterielSpecial = modelMaterielSpecial;
	}
	
	public Controller(Pc modelPc) {
		this.modelPc = modelPc;
	}
	
	public Controller(Utilisateur modelUtilisateur) {
		this.modelUtilisateur = modelUtilisateur;
	}
	
	//ajouter les méthodes
	
	public void addView(Vue vue) {
		this.vue = vue;
	}
}
