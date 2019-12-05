/**
 *
 */
package model;

import java.sql.SQLException;
import java.util.ArrayList;


/**
 * @author Victoire
 *
 */
public class Implantation {


///////////////////////////////////////*ATTRIBUTS*/////////////////////////////////////////////////////////////////////////////////////////////



	private int id;
	private String nom;
	private Adresse adresse;
	
	public ArrayList<Local> locaux = new ArrayList<Local>();
	


	Utilisateur[] util;
	
	



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
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	/**
	 * @return the locaux
	 */
	public ArrayList<Local> getLocaux() {
		return locaux;
	}

	/**
	 * @param locaux the locaux to set
	 */
	public void setLocaux(ArrayList<Local> locaux) {
		this.locaux = locaux;
	}

///////////////////////////////////////*CONSTRUCTEURS*////////////////////////////////////////////////////////////////////////////////////

	public Implantation(int id, String nom, Adresse adresse) {
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;

	}

///////////////////////////////////////*METHODES*/////////////////////////////////////////////////////////////////////////////////////////

	public void genererAdresse(int id, int numero, int codePostal, String rue, String ville) throws SQLException {
		Connexion ga = new Connexion("insert into adresse values ('"+ id +"','"+ numero +"','"+ codePostal +"','"+rue +"','"+ ville +"',)");
			
	}

	public void ajouterLocaux(int id, String nom, int implantationId, int localInformatique) throws SQLException {
		Connexion al = new Connexion("insert into local values ('"+ id +"','"+ nom +"','"+ implantationId +"','"+ localInformatique +"')");
	}

	public int nombreLocauxTotal() throws SQLException {
		Connexion nlt = new Connexion("select count(*) from local where implatationId = "+ this.id);
		nlt.resultat.next();

		return nlt.resultat.getInt("1");
	}

	public int nombreLocauxInformatiques() throws SQLException {

		//compter uniquement le nombre de locaux informatiques
		Connexion nli = new Connexion("select count(*) from local where localInfomartique = 1");
		nli.resultat.next();
		
		return nli.resultat.getInt("1");
	}


}
