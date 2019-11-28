/**
 * 
 */
package model;

import java.util.Observable;

/**
 * @author Victoire
 *
 */
public class Utilisateur extends Observable {

	private int id;
	private String nom, prenom,grade, pseudo, motDePasse, implantation;
	
	String[] util;
	
	public Utilisateur(int id, String nom, String prenom, String grade, String pseudo, String motDePasse, String implantation ) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.pseudo = pseudo;
		this.motDePasse = motDePasse;
		this.implantation = implantation;
	}
	
	public String toString() {
		return nom + " " + prenom + " " + grade + " " + pseudo + " " + motDePasse + " " + implantation;
	}
	
	/**
	 * m�thode qui permet de changer le grade d'un utilisateur par celui pass� en param�tre
	 * @param newGrade
	 */
	public void changerGrade(String newGrade) {
		this.grade = newGrade;
		setChanged();
        notifyObservers();
	}
	/**
	 * m�thode qui permet d'ajouter un utilisateur � la BDD
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param grade
	 * @param pseudo
	 * @param motDePasse
	 * @param implantation
	 */
	public void ajouterUtilisateur(int id, String nom, String prenom, String grade, String pseudo,String motDePasse,String implantation ) {
		
		//TODO Implementation collection
		setChanged();
        notifyObservers();
	}
	
	/**
	 * m�thode qui permet de supprimer un utilisateur en fonction de l'id pass� en param�tre
	 * @param id
	 */
	public void supprimerUtilisateur(int id) {
		//TODO implementation collection
		setChanged();
        notifyObservers();
	}
	
	/**
	 * m�thode qui permet d'authentifier un utilisateur
	 * return vrai ou faux
	 */
	public boolean authentifier(String pseudo, String mdp) {
		setChanged();
        notifyObservers();
		//Implementation collection
		return false;
	}
	
	/**
	 * m�thode qui permet de changer le pseudo d'un utilisateur par celui pass� en param�tre
	 * @param pseudo
	 */
	public void changerPseudo(String pseudo) {
		setChanged();
        notifyObservers();
		this.pseudo = pseudo;
		//TODO Implementation collection
	}
	
	/**
	 * m�thode qui permet de changer le mot de passe d'un utilisateur par celui pass� en param�tre
	 * @param mdp
	 */
	public void changerMDP(String mdp) {
		this.motDePasse = mdp;
		setChanged();
        notifyObservers();
		//TODO implementation collection
	}
	
	/**
	 * m�thode qui permet de synchroniser le programme avec la base de donn�e
	 */
	public void synchroniserBDD() {
		//TODO � partir des tableaux instancier les objets
		setChanged();
        notifyObservers();
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
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
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

	/**
	 * @return the implantation
	 */
	public String getImplantation() {
		return implantation;
	}

	/**
	 * @param implantation the implantation to set
	 */
	public void setImplantation(String implantation) {
		this.implantation = implantation;
	}
	

}
