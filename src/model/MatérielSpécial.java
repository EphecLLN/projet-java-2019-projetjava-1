/**
 * 
 */
package model;

/**
 * Classe permettant la représentation de matériel spécial
 * @author igorv
 *
 */
public class MatérielSpécial {
	
	//Variables d'instance
		private int id;
		private String nom;
		private String etat;
		private int local;
	
	/**
	 * Constructeur
	 * @param id
	 * @param nom
	 * @param etat
	 * @param local
	 */
	private MatérielSpécial(int id, String nom, String etat, int local) {
		super();
		this.id = id;
		this.nom = nom;
		this.etat = etat;
		this.local = local;
	}

	/**
	 * Getters & Setters
	 */
	
	/**
	 * @return the id
	 */
	private int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	private void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	private String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	private void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the etat
	 */
	private String getEtat() {
		return etat;
	}

	/**
	 * @param etat the etat to set
	 */
	private void setEtat(String etat) {
		this.etat = etat;
	}

	/**
	 * @return the local
	 */
	private int getLocal() {
		return local;
	}

	/**
	 * @param local the local to set
	 */
	private void setLocal(int local) {
		this.local = local;
	}
	
	// Méthode
	
	public void changerEtat(String etat) {
		this.etat = etat;
	}
	
	//Main
	
	public static void main(String[] args) {
		
		MatérielSpécial ms1 = new MatérielSpécial(1,"projo","bien",38);
		ms1.etat.changerEtat("Moyen");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}

