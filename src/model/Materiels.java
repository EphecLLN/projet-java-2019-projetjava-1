/**
 * 
 */
package model;

import java.util.Observable;

/**
 * Classe permettant de faire et d'actualiser un inventaire de mat�riels
 * @author igorv
 *
 */
@SuppressWarnings("deprecation")
public class Materiels extends Observable{
	
	private int id;
	private String nom;
	private int neuf;
	private int bon;
	private int use;
	private int critique;
	private int localId;
	
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
	 * @return the localId
	 */
	public int getLocalId() {
		return localId;
	}

	/**
	 * @param localId the localId to set
	 */
	public void setLocalId(int localId) {
		this.localId = localId;
	}
	
	/**
	 * @param id
	 * @param neuf
	 * @param bon
	 * @param use
	 * @param critique
	 * @param localId
	 */
	public Materiels(int id, String nom, int neuf, int bon, int use, int critique, int localId) {
		this.id = id;
		this.nom = nom;
		this.neuf = neuf;
		this.bon = bon;
		this.use = use;
		this.critique = critique;
		this.localId = localId;
	}
	
	//////////////////////////////////////////*M�thodes*////////////////////////////////////////////////////////////////////////

	/**
	 * M�thode
	 * 
	 * M�thode permetant d'actualiser l'inventaire
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
		setChanged();
        notifyObservers();
	}
	
	/**
	 * M�thode permetant de faire le compte d'un mat�riel
	 * @param neuf
	 * @param bon
	 * @param use
	 * @param critique
	 * @return la quantit�e d'un mat�riel
	 * 
	 */
	
	public int total(int neuf, int bon, int use, int critique) {
		setChanged();
        notifyObservers();
		return neuf + bon + use + critique;
	}
	
	
}
