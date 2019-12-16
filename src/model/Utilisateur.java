/**
 *
 */
package model;

import java.sql.SQLException;

/**
 * @author Victoire
 *
 */
public class Utilisateur {

///////////////////////////////////////*ATTRIBUTS*/////////////////////////////////////////////////////////////////////////////////////////////

	private int id, grade;
	private String nom, prenom, pseudo, motDePasse;

///////////////////////////////////////*GETTERS & SETTERS*////////////////////////////////////////////////////////////////////////////////////

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
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the grade
	 */
	public int getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(int grade) {
		this.grade = grade;
	}

	/**
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * @param pseudo the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/**
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}

	/**
	 * @param motDePasse the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

///////////////////////////////////////*CONSTRUCTEURS*////////////////////////////////////////////////////////////////////////////////////

	public Utilisateur(int id, String nom, String prenom, int grade, String pseudo, String motDePasse) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.pseudo = pseudo;
		this.motDePasse = motDePasse;
	}

///////////////////////////////////////*METHODES*/////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Supprime l'objet qui l'appelle en bdd
	 * @throws SQLException
	 */
	public void supprimer() throws SQLException {
		Connexion.supprimer(this, this.id);
	}

///////////////////////////////////////*METHODE TOSTRING*////////////////////////////////////////////////////////////////////////////////////

	public String toString() {
		return nom + " " + prenom + " " + grade + " " + pseudo + " " + motDePasse;
	}
}
