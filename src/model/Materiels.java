/**
 * 
 */
package model;

import java.util.Observable;

/**
 * Classe permettant de faire et d'actualiser un inventaire de matériels
 * @author igorv
 *
 */
public class Materiels extends Observable{
	private int neuf;
	private int bon;
	private int use;
	private int critique;
	
	
	/**
	 * Constructeur
	 * @param neuf
	 * @param bon
	 * @param use
	 * @param critique
	 */
	public Materiels(int neuf, int bon, int use, int critique) {
		this.neuf = neuf;
		this.bon = bon;
		this.use = use;
		this.critique = critique;
	}
	
	/**
	 * Getters & Setters
	 */

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
	 * Méthode
	 * 
	 * Méthode permetant d'actualiser l'inventaire
	 * @param neuf
	 * @param bon
	 * @param use
	 * @param critique
	 * 
	 */
	
	
	public void actualiser(int neuf, int bon, int use, int critique) {
		this.neuf = neuf;
		this.bon = bon;
		this.use = use;
		this.critique = critique;
		setChanged();
        notifyObservers();
	}
	
	/**
	 * Méthode permetant de faire le compte d'un matériel
	 * @param neuf
	 * @param bon
	 * @param use
	 * @param critique
	 * @return la quantitée d'un matériel
	 * 
	 */
	
	public int total(int neuf, int bon, int use, int critique) {
		setChanged();
        notifyObservers();
		return neuf + bon + use + critique;
	}
	
	
}
