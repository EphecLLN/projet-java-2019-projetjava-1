/**
 *
 */
package model;




/**
 * @author lb
 *
 */
public class Pc {

///////////////////////////////////////*ATTRIBUTS*/////////////////////////////////////////////////////////////////////////////////////////////

	private int id;
	private String nom;
	private String type;
	private String tour;
	private String ecran;
	private String clavier;
	private String souris;
	private String commentaires;

///////////////////////////////////////*GETTERS ET SETTERS*////////////////////////////////////////////////////////////////////////////////////

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
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
	 * @return the tour
	 */
	public String getTour() {
		return tour;
	}

	/**
	 * @param tour the tour to set
	 */
	public void setTour(String tour) {
		this.tour = tour;
	}

	/**
	 * @return the ecran
	 */
	public String getEcran() {
		return ecran;
	}

	/**
	 * @param ecran the ecran to set
	 */
	public void setEcran(String ecran) {
		this.ecran = ecran;
	}

	/**
	 * @return the clavier
	 */
	public String getClavier() {
		return clavier;
	}

	/**
	 * @param clavier the clavier to set
	 */
	public void setClavier(String clavier) {
		this.clavier = clavier;
	}

	/**
	 * @return the souris
	 */
	public String getSouris() {
		return souris;
	}

	/**
	 * @param souris the souris to set
	 */
	public void setSouris(String souris) {
		this.souris = souris;
	}

	/**
	 * @return the commentaires
	 */
	public String getCommentaires() {
		return commentaires;
	}

	/**
	 * @param commentaires the commentaires to set
	 */
	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

///////////////////////////////////////*CONSTRUCTEUR*////////////////////////////////////////////////////////////////////////////////////

	/**
	 * @param local
	 * @param type
	 * @param tour
	 * @param ecran
	 * @param clavier
	 * @param souris
	 * @param commentaires
	 */
	public Pc(int id, String nom, String type, String tour, String ecran, String clavier, String souris, String commentaires) {
		this.id = id;
		this.nom = nom;
		this.type = type;
		this.tour = tour;
		this.ecran = ecran;
		this.clavier = clavier;
		this.souris = souris;
		this.commentaires = commentaires;
	}




}
