/**
 *
 */
package model;

import java.sql.SQLException;

/**
 * Classe des interventions 
 * @author lb
 *
 */
public class Intervention{

///////////////////////////////////////*ATTRIBUTS*/////////////////////////////////////////////////////////////////////////////////////////////


	private int id;
	private String nom;
	private String commentaires;

///////////////////////////////////////*GETTERS ET SETTERS*////////////////////////////////////////////////////////////////////////////////////


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
///////////////////////////////////////*CONSTRUCTEUR*////////////////////////////////////////////////////////////////////////////////////

	/**
	 * @param id
	 * @param nom
	 * @param commentaires
	 * @param localId
	 */
	public Intervention(int id, String nom, String commentaires) {
		this.id = id;
		this.nom = nom;
		this.commentaires = commentaires;
	}

///////////////////////////////////////*METHODES*/////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Fait la mise a jour d'une intervention en remplacant ses donnees par celles passees en parametres
	 * @param nom
	 * @param commentaires
	 * @throws SQLException
	 */
	public void majIntervention(String nom, String commentaires) throws SQLException {
		this.nom = nom;
		this.commentaires = commentaires;
		Connexion.requete("update intervention set nom = '" + nom + "', commentaires = '" + commentaires + "' where id = " + this.getId());

	}
}
