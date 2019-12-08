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
	private ArrayList<Local> locaux = new ArrayList<Local>();
	private ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
	
	
	



///////////////////////////////////////*GETTERS ET SETTERS*////////////////////////////////////////////////////////////////////////////////////

	/**
	 * @return the utilisateurs
	 */
	public ArrayList<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	/**
	 * @param utilisateurs the utilisateurs to set
	 */
	public void setUtilisateurs(ArrayList<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
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
	
	public Implantation() {
		
	}

///////////////////////////////////////*METHODES*/////////////////////////////////////////////////////////////////////////////////////////

	
	public void genererAdresse(int numero, String rue, int codePostal, String ville) throws SQLException {
		
		int id = Utils.autoId("adresse");
		Connexion ga = new Connexion("insert into adresse values (" + id + ", '" + numero + "', '" + rue + "', '" + ville + "', " + codePostal +" )");
		ga.fermerConnexion();
	}

	public void genererLocal(String nom, int implantationId, int localInformatique) throws SQLException {
		int id  = Utils.autoId("local");
		Connexion gl = new Connexion("insert into local values ('"+ id +"','"+ nom +"','"+ implantationId +"','"+ localInformatique +"')");
		gl.fermerConnexion();
	}
	
	public void genererUtilisateur(String nom, String prenom, int grade, String pseudo, String motDePasse, int implantationId) throws SQLException {
		int id = Utils.autoId("utilisateur");
		Connexion gu = new Connexion("insert into utilisateur values (" + id + ", '" + nom + "', '" + prenom + "', " + grade + ", '" + pseudo + "', '" + motDePasse + "', " + implantationId + ")");
		gu.fermerConnexion();
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
