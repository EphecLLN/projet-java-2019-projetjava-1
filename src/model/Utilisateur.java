/**
 * 
 */
package model;

/**
 * @author Victoire
 *
 */
public class Utilisateur {

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
	 * méthode qui permet de changer le grade d'un utilisateur par celui passé en paramètre
	 * @param newGrade
	 */
	public void changerGrade(String newGrade) {
		this.grade = newGrade;
	}
	/**
	 * méthode qui permet d'ajouter un utilisateur à la BDD
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
	}
	
	/**
	 * méthode qui permet de supprimer un utilisateur en fonction de l'id passé en paramètre
	 * @param id
	 */
	public void supprimerUtilisateur(int id) {
		//TODO implementation collection
	}
	
	/**
	 * méthode qui permet d'authentifier un utilisateur
	 * return vrai ou faux
	 */
	public boolean authentifier(String pseudo, String mdp) {
		//Implementation collection
		return false;
	}
	
	/**
	 * méthode qui permet de changer le pseudo d'un utilisateur par celui passé en paramètre
	 * @param pseudo
	 */
	public void changerPseudo(String pseudo) {
		this.pseudo = pseudo;
		//TODO Implementation collection
	}
	
	/**
	 * méthode qui permet de changer le mot de passe d'un utilisateur par celui passé en paramètre
	 * @param mdp
	 */
	public void changerMDP(String mdp) {
		this.motDePasse = mdp;
		//TODO implementation collection
	}
	
	/**
	 * méthode qui permet de synchroniser le programme avec la base de donnée
	 */
	public void synchroniserBDD() {
		//TODO à partir des tableaux instancier les objets
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
