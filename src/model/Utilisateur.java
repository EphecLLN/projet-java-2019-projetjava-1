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

	String[] util;


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
	 * methode qui permet de changer le grade d'un utilisateur par celui passe en parametre
	 * @param newGrade
	 * @throws SQLException 
	 */
	public void changerGrade(int grade, int newGrade) throws SQLException {
		Connexion cg = new Connexion("update utilisateurs set " + grade + "=" + newGrade + "where id =" + this.id);
		
	}
	
	/**
	 * methode qui permet d'ajouter un utilisateur e la BDD
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param grade
	 * @param pseudo
	 * @param motDePasse
	 * @param implantation
	 * @throws SQLException 
	 */
	public void ajouterUtilisateur(int id, String nom, String prenom, int grade, String pseudo, String motDePasse, int implantation ) throws SQLException {

		Connexion au = new Connexion("insert into utilisateurs values ('"+ id +"','"+ nom +"','"+ prenom +"','"+ grade +"','"+ pseudo +"','"+ motDePasse +",'"+ implantation+")");
		
	}

	/**
	 * methode qui permet de supprimer un utilisateur en fonction de l'id passe en parametre
	 * @param id
	 * @throws SQLException 
	 */
	public void supprimerUtilisateur(int id) throws SQLException {
		Connexion su = new Connexion("delete from utilisateurs where id = "+ id);
		
	}

	/**
	 * methode qui permet de changer le pseudo d'un utilisateur par celui passe en parametre
	 * @param pseudo
	 * @throws SQLException 
	 */
	public void changerPseudo(String pseudo, String newPseudo) throws SQLException {
		Connexion cp = new Connexion("update utilisateurs set " + pseudo + "=" + newPseudo + "where id =" + this.id);
		
		//TODO Implementation collection
	}

	/**
	 * methode qui permet de changer le mot de passe d'un utilisateur par celui passe en parametre
	 * @param mdp
	 * @throws SQLException 
	 */
	public void changerMDP(String mdp, String newMdp) throws SQLException {
		Connexion cm = new Connexion("update utilisateurs set " + mdp + "=" + newMdp + "where id =" + this.id);
		
		//TODO implementation collection
	}




///////////////////////////////////////*METHODE TOSTRING*////////////////////////////////////////////////////////////////////////////////////

	public String toString() {
		return nom + " " + prenom + " " + grade + " " + pseudo + " " + motDePasse;
	}
	

}
