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
public class Ecole extends Observable {
	
	public ArrayList<Adresse> adresses = new ArrayList<Adresse>();
	public ArrayList<Implantation> implantation = new ArrayList<Implantation>();
	public ArrayList<Intervention> intervention = new ArrayList<Intervention>();
	public ArrayList<Local> local = new ArrayList<Local>();
	public ArrayList<LocalInformatique> localInformatique = new ArrayList<LocalInformatique>();
	public ArrayList<Materiels> materiel = new ArrayList<Materiels>();
	public ArrayList<MaterielSpecial> materielSpecial = new ArrayList<MaterielSpecial>();
	public ArrayList<Pc> pc = new ArrayList<Pc>();
	public ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
	
	public Ecole() throws SQLException {
		utilisateurs.add(new Utilisateur(1, "a", "a", 0, "a", "abc", 2));
/*
		Connexion conAdresses = new Connexion("select * from adresse");
		conAdresses.resultat.next();
		while(! conAdresses.resultat.isAfterLast()){
			adresses.add(new Adresse(conAdresses.resultat.getInt("id"), conAdresses.resultat.getInt("numero"), conAdresses.resultat.getString("rue"), conAdresses.resultat.getString("ville"), conAdresses.resultat.getInt("codePostal")));             
			System.out.println(adresses.toString());
			conAdresses.resultat.next();
		}*/
	}
	
	
	
}
	
