/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.Observable;

/**
 * @author Victoire
 *
 */
public class Ecole extends Observable {
	
	ArrayList<Adresse> adresse = new ArrayList<Adresse>();
	ArrayList<Implantation> implantation = new ArrayList<Implantation>();
	ArrayList<Intervention> intervention = new ArrayList<Intervention>();
	ArrayList<Local> local = new ArrayList<Local>();
	ArrayList<LocalInformatique> localInformatique = new ArrayList<LocalInformatique>();
	ArrayList<Materiels> materiel = new ArrayList<Materiels>();
	ArrayList<MaterielSpecial> materielSpecial = new ArrayList<MaterielSpecial>();
	ArrayList<Pc> pc = new ArrayList<Pc>();
	ArrayList<Utilisateur> utilisateur = new ArrayList<Utilisateur>();
	
	public Ecole() {
		

		Connexion conAdresses = new Connexion("select * from adresse");
		conAdresses.resultat.next();
		while(! conAdresses.resultat.isAfterLast()){
			adresses.add(new Adresse(conAdresses.resultat.getInt("id"), conAdresses.resultat.getInt("numero"), conAdresses.resultat.getString("rue"), conAdresses.resultat.getString("ville"), conAdresses.resultat.getInt("codePostal")));             
			System.out.println(adresses.toString());
			conAdresses.resultat.next();
		}
	}
	
	
	
}
	
