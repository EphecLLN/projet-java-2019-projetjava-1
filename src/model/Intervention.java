/**
 * 
 */
package model;

import java.util.Observable;

/**
 * @author lb
 *
 */
public class Intervention extends Observable{
	
	private int id;
	private String nom;
	private String commentaires;
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
	 * @param nom
	 * @param commentaires
	 * @param localId
	 */
	public Intervention(int id, String nom, String commentaires, int localId) {
		this.id = id;
		this.nom = nom;
		this.commentaires = commentaires;
		this.localId = localId;
	}


	/**
	 * Modifie l'intervention en base de donées et remplace les valeurs des
	 * attributs de l'objet par les valeurs 
	 * entrées en paramètres 
	 * 
	 * @param nom Le nom de l'intervention
	 * @param commentaires Les détails de l'intervention
	 * 
	 * @throws Exception Renvoie une exception si l'opération n'a pas pu aboutir
	 */
	public void modifierIntervention(String newNom, String newCommentaires, String nom, String commentaires){
		Connexion min = new Connexion("update intervention set " + nom + "=" + newNom + ", "+ commentaires + "=" + newCommentaires + "where id =" + this.id );
		setChanged();
        notifyObservers();
	}
	


}
