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

///////////////////////////////////////*CONSTRUCTEUR*//////////////////////////////////////////////////////////////////////////////////////////

	public Adresse(int id, int numero, String rue, String ville, int codePostal){
	this.id = id;
	this.numero = numero;
	this.codePostal = codePostal;
	this.rue = rue;
	this.ville = ville;
	}
	


////////////////////////////////////////////////*METHODE*/////////////////////////////////////////////////////////////////////////////////////

	public String toString() {

		 return this.numero + " " + this.rue + " " + this.codePostal + " " + this.ville;
	}




}
