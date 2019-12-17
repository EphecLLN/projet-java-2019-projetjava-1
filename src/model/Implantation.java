/**
 *
 */
package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;


/**
 * Classe des implantations de l'école
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

	///////////////////////////////////////*CONSTRUCTEUR*////////////////////////////////////////////////////////////////////////////////////

	public Implantation(int id, String nom, Adresse adresse) {
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;

	}

	///////////////////////////////////////*METHODES*/////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Permet de générer un local et son matériel(chaises et tables) associé.
	 * Les données sont enregistrées sur la bdd et sont ajoutées au modèle.
	 * @param nom
	 * @param localInformatique
	 * @param chaises
	 * @param tables
	 * @throws SQLException
	 */
	public void genererLocalEtMateriels(String nom, int localInformatique, int[] chaises, int[] tables) throws SQLException {

		int localId = Connexion.generer("insert into local values ('', '"+ nom +"','"+ this.id +"','"+ localInformatique +"')", "local");
		Local loc;
		if(localInformatique == 0) {
			loc = (Local) Connexion.requete("select * from local where id = " + localId, "Local").get(0);
		}
		else {
			loc = (LocalInformatique) Connexion.requete("select * from local where id = " + localId, "Local").get(0);
		}
		loc.genererMateriels(chaises, tables);
		loc.setMateriels();
		this.getLocaux().add(loc);

	}



	/**
	 * Permet de générer un nouvel utilisateur. Il est enregistré en bdd et ajouté
	 * au modèle.
	 * @param nom
	 * @param prenom
	 * @param grade
	 * @param pseudo
	 * @param motDePasse
	 * @throws SQLException
	 */
	public void genererUtilisateur(String nom, String prenom, int grade, String pseudo, String motDePasse) throws SQLException {
		int utilisateurId = Connexion.generer("insert into utilisateur values ('', '" + nom + "', '" + prenom + "', " + grade + ", '" + pseudo + "', '" + motDePasse + "', " + this.id + ")", "utilisateur");
		Utilisateur utilisateur = (Utilisateur) Connexion.requete("Select * from utilisateur where id = " + utilisateurId, "Utilisateur").get(0);
		this.utilisateurs.add(utilisateur);
	}

	/**
	 * Permet d'instancier tous les utilisateurs de chaque implantation
	 * @throws SQLException
	 */
	public void synchroUtilisateurs() throws SQLException {
		if(!this.getUtilisateurs().isEmpty()) {
			this.getUtilisateurs().clear();
		}
		@SuppressWarnings("unchecked")
		ArrayList<Utilisateur> utis = Connexion.requete("select * from utilisateur where implantationId = " + this.getId(), "Utilisateur");
		for(Utilisateur uti : utis) {
			this.getUtilisateurs().add(uti);
		}
	}

	/**
	 * Permet d'instancier Tous les locaux et le matériel associé pour chaque implantation
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public void synchroLocalEtMateriel() throws SQLException {
		if(!this.getLocaux().isEmpty()) {
			this.getLocaux().clear();
		} 
		ArrayList<Local> locs = Connexion.requete("select * from local where implantationId = " + this.getId(), "Local");
		for(Local loc : locs) {
			loc.setMateriels();
			this.getLocaux().add(loc);
			loc.synchroMaterielsSpeciaux();
			loc.syncrhoInterventions();
			loc.synchroPcs();
		}

	}

	/**
	 * Renvoie le nombre de l'ensemble des locaux d'une implantation
	 * @return int
	 */
	public int nombreLocauxTotal(){
		return this.getLocaux().size();
	}

	/**
	 * Renvoie le nombre de locaux informatiques d'une implantation
	 * @return int
	 */
	public int nombreLocauxInformatiques(){
		int i = 0;
		for (Local local : locaux) {
			if(local.getClass().getSimpleName().equals("LocalInformatique")) {
				i++;
			}
		}
		return i;
	}

	/**
	 * Renvoie les noms des locaux
	 * @param nom
	 * @return Local
	 */
	public Local getLocal(String nom) {
		Local local = null;
		Iterator<Local> iterateur = this.getLocaux().iterator();
		boolean trouve = false;
		while(iterateur.hasNext() && !trouve) {
			local = iterateur.next();
			if(local.getNom().equals(nom)) {
				trouve = true;
			}
		}
		return local;
	}
}
