/**
 * 
 */
package model;

import java.sql.SQLException;
import java.util.Observable;

/**
 * @author Victoire
 *
 */
public class Implantation extends Observable{
	
	
	private int id;
	private String nom;
	private int adresseid;
	Local[] locaux; //� compl�ter une fois la classe local li�e
	
	int[] test = {1, 4, 6, 7};//tableaux de int pour tester les m�thodes
	int[] test2 = {1, 5, 3, 7};//tableaux de int pour tester les m�thodes
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the adresse
	 */
	public int getAdresse() {
		return adresseid;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(int adresse) {
		this.adresseid = adresse;
	}
	
	public Implantation(int id, String nom, int adresseid) {
		this.id = id;
		this.nom = nom;
		this.adresseid = adresseid;
		
	}
	
	public Implantation() {
	
	}
	
	
	public void genererAdresse(int adresse) {
		this.adresseid = adresse;
		setChanged();
        notifyObservers();
	}
	
	public void ajouterLocaux() {
		setChanged();
        notifyObservers();
	}
	
	public int nombreLocauxTotal() throws SQLException {
		Connexion nlt = new Connexion("select count(*) from local where implatationId = "+ this.id);
		nlt.resultat.next();
		setChanged();
        notifyObservers();
		return nlt.resultat.getInt("1");
	}
	
	public int nombreLocauxInformatiques() {
		
		//compter uniquement le nombre de locaux informatiques
		setChanged();
        notifyObservers();
		return 0;
	}


}
