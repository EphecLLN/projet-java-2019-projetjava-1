/**
 *
 */
package model;

import java.sql.SQLException;

/**
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
///////////////////////////////////////*CONSTRUCTEURS*////////////////////////////////////////////////////////////////////////////////////

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
	 * Modifie l'intervention en base de donées et remplace les valeurs des
	 * attributs de l'objet par les valeurs
	 * entrées en paramètres
	 *
	 * @param nom Le nom de l'intervention
	 * @param commentaires Les détails de l'intervention
	 * @throws SQLException 
	 *
	 * @throws Exception Renvoie une exception si l'opération n'a pas pu aboutir
	 */
	public void modifierIntervention(String newNom, String newCommentaires, String nom, String commentaires) throws SQLException{
		Connexion min = new Connexion("update intervention set " + nom + "=" + newNom + ", "+ commentaires + "=" + newCommentaires + "where id =" + this.id );
		
	}

	/**
	 * Supprime l'objet qui l'appelle en bdd
	 * @throws SQLException
	 */
	public void supprimer() throws SQLException {
		Connexion.supprimer(this, this.id);
	}

}
