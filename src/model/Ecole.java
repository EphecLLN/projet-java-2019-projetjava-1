/**
 * 
 */
package model;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Observable;

/**
 * @author Victoire
 *
 */
@SuppressWarnings("deprecation")
public class Ecole extends Observable {
	
	
	
	
	
	public ArrayList<Implantation> implantations = new ArrayList<Implantation>();
	
	public ArrayList<Adresse> adresses = new ArrayList<Adresse>();
	
	
	
	
	public Ecole() throws SQLException {
		
	Connexion connAdresse = new Connexion("select * from adresse");
	connAdresse.resultat.next();
	while(! connAdresse.resultat.isAfterLast()) {
		adresses.add(new Adresse(connAdresse.resultat.getInt("id"),connAdresse.resultat.getInt("numero"),connAdresse.resultat.getString("rue"), connAdresse.resultat.getString("ville"),connAdresse.resultat.getInt("codePostal")));
		connAdresse.resultat.next();
	}
	
	
		
	Connexion connImplantation = new Connexion("select * from implantation");
	connImplantation.resultat.next();
	while(! connImplantation.resultat.isAfterLast()){
		implantations.add(new Implantation(connImplantation.resultat.getInt("id"), connImplantation.resultat.getString("nom"), adresses.get(0)));             
		connImplantation.resultat.next();
		
	}
	
	
	/*
	public ArrayList<Adresse> adresses = new ArrayList<Adresse>();
	public ArrayList<Implantation> implantations = new ArrayList<Implantation>();
	public ArrayList<Intervention> interventions = new ArrayList<Intervention>();
	public ArrayList<Local> locals = new ArrayList<Local>();
	public ArrayList<LocalInformatique> localInformatiques = new ArrayList<LocalInformatique>();
	public ArrayList<Materiels> materiels = new ArrayList<Materiels>();
	public ArrayList<MaterielSpecial> materielSpecials = new ArrayList<MaterielSpecial>();
	public ArrayList<Pc> pcs = new ArrayList<Pc>();
	public ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
	
	
		
		
		
		Connexion conAdresses = new Connexion("select * from adresse");
		conAdresses.resultat.next();
		while(! conAdresses.resultat.isAfterLast()){
			adresses.add(new Adresse(conAdresses.resultat.getInt("id"), conAdresses.resultat.getInt("numero"), conAdresses.resultat.getString("rue"), conAdresses.resultat.getString("ville"), conAdresses.resultat.getInt("codePostal")));             
			conAdresses.resultat.next();
		}
		
		Connexion connImplantation = new Connexion("select * from implantation");
		connImplantation.resultat.next();
		while(! connImplantation.resultat.isAfterLast()){
			implantations.add(new Implantation(connImplantation.resultat.getInt("id"), connImplantation.resultat.getString("nom"), connImplantation.resultat.getInt("adresseId")));             
			connImplantation.resultat.next();
		}
		
		Connexion connLocal = new Connexion("select * from local");
		connLocal.resultat.next();
		while(! connLocal.resultat.isAfterLast()){
			locals.add(new Local(connLocal.resultat.getInt("id"), connLocal.resultat.getString("nom"), connLocal.resultat.getInt("implantationId"), connLocal.resultat.getInt("localInformatique")));             
			connLocal.resultat.next();
		}
		
		Connexion connIntervention = new Connexion("select * from intervention");
		connIntervention.resultat.next();
		while(! connIntervention.resultat.isAfterLast()){
			interventions.add(new Intervention(connIntervention.resultat.getInt("id"), connIntervention.resultat.getString("nom"), connIntervention.resultat.getString("commentaires"), connIntervention.resultat.getInt("localId")));             
			connIntervention.resultat.next();
		}
		
		Connexion connMateriels = new Connexion("select * from materiels");
		connMateriels.resultat.next();
		while(! connMateriels.resultat.isAfterLast()){
			materiels.add(new Materiels(connMateriels.resultat.getInt("id"), connMateriels.resultat.getString("nom"), connMateriels.resultat.getInt("neuf"), connMateriels.resultat.getInt("bon"), connMateriels.resultat.getInt("use"), connMateriels.resultat.getInt("critique"), connMateriels.resultat.getInt("localId")));             
			connMateriels.resultat.next();
		}
		
		Connexion connMaterielSpecial = new Connexion("select * from materielSpecial");
		connMaterielSpecial.resultat.next();
		while(! connMaterielSpecial.resultat.isAfterLast()){
			materielSpecials.add(new MaterielSpecial(connMaterielSpecial.resultat.getInt("id"), connMaterielSpecial.resultat.getString("nom"), connMaterielSpecial.resultat.getString("etat"), connMaterielSpecial.resultat.getInt("localId")));             
			connMaterielSpecial.resultat.next();
		}
		
	}
	*/

	
}}
	
