/**
 *
 */
package model;

import java.sql.SQLException;

/**
 * Classe permettant de faire et d'actualiser un inventaire de materiels
 * @author igorv
 *
 */

public class Materiels{

///////////////////////////////////////*ATTRIBUTS*/////////////////////////////////////////////////////////////////////////////////////////////

	private int id;
	private String nom;
	private int neuf;
	private int bon;
	private int use;
	private int critique;

///////////////////////////////////////*GETTERS ET SETTERS*////////////////////////////////////////////////////////////////////////////////////

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
	 * @return the neuf
	 */
	public int getNeuf() {
		return neuf;
	}

	/**
	 * @param neuf the neuf to set
	 */
	public void setNeuf(int neuf) {
		this.neuf = neuf;
	}

	/**
	 * @return the bon
	 */
	public int getBon() {
		return bon;
	}

	/**
	 * @param bon the bon to set
	 */
	public void setBon(int bon) {
		this.bon = bon;
	}

	/**
	 * @return the use
	 */
	public int getUse() {
		return use;
	}

	/**
	 * @param use the use to set
	 */
	public void setUse(int use) {
		this.use = use;
	}

	/**
	 * @return the critique
	 */
	public int getCritique() {
		return critique;
	}

	/**
	 * @param critique the critique to set
	 */
	public void setCritique(int critique) {
		this.critique = critique;
	}

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

///////////////////////////////////////*CONSTRUCTEUR*////////////////////////////////////////////////////////////////////////////////////

	/**
	 *
	 * @param neuf
	 * @param bon
	 * @param use
	 * @param critique
	 * @param id
	 *
	 */
	public Materiels( int id, String nom, int neuf, int bon, int use, int critique) {
		this.id = id;
		this.nom = nom;
		this.neuf = neuf;
		this.bon = bon;
		this.use = use;
		this.critique = critique;

	}

//////////////////////////////////////////*METHODES*//////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Methode
	 *
	 * Methode permetant d'actualiser l'inventaire
	 * @param neuf
	 * @param bon
	 * @param use
	 * @param critique
	 *
	 */
	public void actualiser(int id, int neuf, int bon, int use, int critique) {
		this.id = id;
		this.neuf = neuf;
		this.bon = bon;
		this.use = use;
		this.critique = critique;

	}

	/**
	 * Methode permettant de faire le compte du nombre de matériels (chaises ou tables)
	 * @param neuf
	 * @param bon
	 * @param use
	 * @param critique
	 * @return la quantité d'un matériel
	 *
	 */
	public int total() {
		return neuf + bon + use + critique;
	}

	
}
