/**
 *
 */
package model;

import java.sql.SQLException;

/**
 * @author Victoire
 *
 */
public class Adresse {

///////////////////////////////////////*ATTRIBUTS*/////////////////////////////////////////////////////////////////////////////////////////////

	private int id, numero, codePostal;
	private String rue, ville;

///////////////////////////////////////*GETTERS ET SETTERS*////////////////////////////////////////////////////////////////////////////////////

	/**
	* @return the numero
	*/
	public int getNumero() {
	return numero;
	}

	/**
	* @param numero the numero to set
	*/
	public void setNumero(int numero) {
	this.numero = numero;
	}

	/**
	* @return the codePostal
	*/
	public int getCodePostal() {
	return codePostal;
	}

	/**
	* @param codePostal the codePostal to set
	*/
	public void setCodePostal(int codePostal) {
	this.codePostal = codePostal;
	}

	/**
	* @return the rue
	*/
	public String getRue() {
	return rue;
	}

	/**
	* @param rue the rue to set
	*/
	public void setRue(String rue) {
	this.rue = rue;
	}

	/**
	* @return the ville
	*/
	public String getVille() {
	return ville;
	}

	/**
	* @param ville the ville to set
	*/
	public void setVille(String ville) {
	this.ville = ville;
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

///////////////////////////////////////*CONSTRUCTEURS*//////////////////////////////////////////////////////////////////////////////////////////

	public Adresse(int id, int numero, String rue, String ville, int codePostal){
	this.id = id;
	this.numero = numero;
	this.codePostal = codePostal;
	this.rue = rue;
	this.ville = ville;
	}

///////////////////////////////////////*METHODES*//////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Modifie les valeurs des attributs d'une adresse par ceux passes en parametre
	 * Les modifications sont aussi effectuees dans la base de donnees
	 *
	 *
	 * @param numero Le numero du betiment
	 * @param codePostal Le code postal de la ville
	 * @param rue Le nom de la rue
	 * @param ville Le nom de la ville
	 * @throws SQLException 
	 *
	 * @throws Exception Renvoit une exception si l'operation n'a pas pu etre effectuee
	 *
	*/
	public void modifierAdresse(int numero, int codePostal, String rue, String ville, int newNumero, int newCodePostal, String newRue, String newVille) throws SQLException {
		//il manque toute la partie avec la base de donnees qui sera rajoutee par la suite
		Connexion cg = new Connexion("update utilisateurs set " + numero + "=" + newNumero + ", " + codePostal + "=" + newCodePostal + ", " + rue + "=" + newRue + ", " + ville + "=" + newVille  + " where id =" + this.id);

	}
		
	/**
	 * Supprime l'objet qui l'appelle en bdd
	 * @throws SQLException
	 */
	public void supprimer() throws SQLException {
		Connexion.supprimer(this, this.id);
	}

////////////////////////////////////////////////*METHODE TOSTRING*/////////////////////////////////////////////////////////////////////////////////////

	public String toString() {
		 return this.numero + " " + this.ville + " " + this.codePostal + " " + this.ville;
	}




}
