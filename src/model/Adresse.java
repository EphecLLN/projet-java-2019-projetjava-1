/**
 *
 */
package model;



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
	 * Modifie les valeurs des attributs d'une adresse par ceux pass�s en param�tre
	 * Les modifications sont aussi effectu�es dans la base de donn�es
	 *
	 *
	 * @param numero Le num�ro du b�timent
	 * @param codePostal Le code postal de la ville
	 * @param rue Le nom de la rue
	 * @param ville Le nom de la ville
	 *
	 * @throws Exception Renvoit une exception si l'op�ration n'a pas pu �tre effectu�e
	 *
	*/

	public void modifierAdresse(int numero, int codePostal, String rue, String ville) {
		//il manque toute la partie avec la base de donn�es qui sera rajout�e par la suite
		try {
		this.numero = numero;
		this.codePostal = codePostal;
		this.rue = rue;
		this.ville = ville;
		}
		catch(Exception e) {
			System.out.println("La modification n'a pas �t� effectu�e");
		}


	}

////////////////////////////////////////////////*METHODE TOSTRING*/////////////////////////////////////////////////////////////////////////////////////

	public String toString() {
		 return this.numero + " " + this.ville + " " + this.codePostal + " " + this.ville;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


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

	public void genererAdresse(int id, int numero, int codePostal, String rue, String ville) throws SQLException {
		Connexion ga = new Connexion("insert into adresse values ('"+ id +"','"+ numero +"','"+ codePostal +"','"+rue +"','"+ ville +"',)");
		setChanged();
        notifyObservers();
	}

}
