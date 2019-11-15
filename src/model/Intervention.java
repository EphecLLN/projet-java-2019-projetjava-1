/**
 * 
 */
package model;

/**
 * @author lb
 *
 */
public class Intervention {
	
	private int id;
	private String nom;
	private String commentaires;
	
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
	 * @param id identifiant unique
	 * @param nom Le nom de l'intervention
	 * @param commentaires Les détails de l'intervention
	 */
	public Intervention(int id, String nom, String commentaires) {
		this.id = id;
		this.nom = nom;
		this.commentaires = commentaires;
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
	public void modifierIntervention(String nom, String commentaires){
		// Dans cette méthode il manque toute la partie interaction avec la BDD 
		// (je ne connais pas encore les outils nécessaires pour réaliser cette 
		// implémentation)
		try {  
			this.nom = nom;
			this.commentaires = commentaires;
		}
		catch(Exception e) {
			System.out.println("La modification n'a pas pu aboutir. Veuillez "
					+ "réessayer.");
		}
	}

}
