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
	public MatérielSpécial(int id, String nom, String etat, int local) {
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
	public String getEtat() {
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
	
	/**
	 * Méthode permettant de changé l'état de la fonction, mais comme je ne connais pas encore les instructions pour accéder à un DB
	 * @param etat
	 */
	public void changerEtat(String etat) {
		this.etat = etat;
	}
	
	/**
	 * Si nécessaire, des testes d'execption prendont place ici
	 */
}

