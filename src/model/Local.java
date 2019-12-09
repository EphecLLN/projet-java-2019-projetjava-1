/**
 *
 */
package model;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author lb
 *
 */
@SuppressWarnings("unchecked")
public class Local{

///////////////////////////////////////*ATTRIBUTS*/////////////////////////////////////////////////////////////////////////////////////////////


	private int id;
	private String nom;
	private Materiels nbChaises, nbTables;
	private ArrayList<MaterielSpecial> materielsSpeciaux = new ArrayList<MaterielSpecial>();
	private ArrayList<Intervention> interventions = new ArrayList<Intervention>();

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
	 * @return the nbChaises
	 */
	public Materiels getNbChaises() {
		return nbChaises;
	}
	/**
	 * @param nbChaises the nbChaises to set
	 */
	public void setNbChaises(Materiels nbChaises) {
		this.nbChaises = nbChaises;
	}



///////////////////////////////////////*CONSTRUCTEURS*////////////////////////////////////////////////////////////////////////////////////


	/**
	 * @return the nbTables
	 */
	public Materiels getNbTables() {
		return nbTables;
	}
	/**
	 * @param nbTables the nbTables to set
	 */
	public void setNbTables(Materiels nbTables) {
		this.nbTables = nbTables;
	}
	/**
	 * @return the materielsSpeciaux
	 */
	public ArrayList<MaterielSpecial> getMaterielsSpeciaux() {
		return materielsSpeciaux;
	}
	/**
	 * @param materielsSpeciaux the materielsSpeciaux to set
	 */
	public void setMaterielsSpeciaux(ArrayList<MaterielSpecial> materielsSpeciaux) {
		this.materielsSpeciaux = materielsSpeciaux;
	}
	/**
	 * @return the interventions
	 */
	public ArrayList<Intervention> getInterventions() {
		return interventions;
	}
	/**
	 * @param interventions the interventions to set
	 */
	public void setInterventions(ArrayList<Intervention> interventions) {
		this.interventions = interventions;
	}
	/**
	 * @param id
	 * @param nom
	 * @param intervention2
	 * @param implantationId
	 * @param localInformatique
	 */
	public Local(int id, String nom, Materiels nbChaises, Materiels nbTables) {
		this.id = id;
		this.nom = nom;
		this.nbChaises = nbChaises;
		this.nbTables = nbTables;
	}


///////////////////////////////////////*METHODES*////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Permet d'instancier tous les pcs de chaque local informatique de chaque implantation
	 * @throws SQLException
	 */
	public void synchroPcs() throws SQLException {
		if(this.getClass().getSimpleName().equals("LocalInformatique")) {
			LocalInformatique thisInf = (LocalInformatique) this;
			if(!thisInf.getPcs().isEmpty()) {
				thisInf.getPcs().clear();
			}
			ArrayList<Pc> pcs = Connexion.requete("select * from pc where localid = " + this.getId(), "Pc");
			for(Pc pc : pcs) {
				thisInf.getPcs().add(pc);
			}
		}
	}
	/**
	 * Permet d'instancier toutes les interventions de chaque local de chaque implantation
	 * @throws SQLException
	 */
	public void syncrhoInterventions() throws SQLException {
		if(!this.getInterventions().isEmpty()) {
			this.getInterventions().clear();
		}
		ArrayList<Intervention> intes = Connexion.requete("select * from Intervention where localId = " + this.getId(), "Intervention");
		for(Intervention inte : intes) {
			this.getInterventions().add(inte);
		}

	}
	/**
	 * Permet d'instancier tous le matériel spécial de chaque local de chaque implantation
	 * @throws SQLException
	 */
	public void synchroMaterielsSpeciaux() throws SQLException {
		if(!this.getMaterielsSpeciaux().isEmpty()) {
			this.getMaterielsSpeciaux().clear();
		}
		ArrayList<MaterielSpecial> matSpes = Connexion.requete("select * from materielSpecial where localId = " + this.getId(), "MaterielSpecial");
		for(MaterielSpecial matSpe : matSpes) {
			this.getMaterielsSpeciaux().add(matSpe);
		}
	}
	
	/**
	 * Change la valeur des attributs de type Materiels du local avec la valeur adhoc
	 * @throws SQLException
	 */
	public void setMateriels() throws SQLException {
		Materiels chaises = (Materiels) Connexion.requete("select * from materiels where nom = 'chaises' and localid = " + this.getId(), "Materiels").get(0);
		Materiels tables = (Materiels) Connexion.requete("select * from materiels where nom = 'tables' and localid = " + this.getId(), "Materiels").get(0);
		this.setNbChaises(chaises);	
		this.setNbTables(tables);
	}
	
	public void ajouterMaterielSpecial(int id, String nom, String etat, int local) throws SQLException {
		Connexion ams = new Connexion("insert into materielspecial values ('"+ id +"','"+ nom +"','"+ etat +"')");
		
	}
	public void ajouterIntervention(int id, String nom, String commentaire) throws SQLException {
		Connexion ai = new Connexion("insert into intervention values ('"+ id +"','"+ nom +"','"+ commentaire +"')");
	}

///////////////////////////////////////*METHODE TOSTRING*////////////////////////////////////////////////////////////////////////////////////

	/*
	public String toString() {

		String str = "Local : classique";
		if(localInformatique == 1) {
			str = "Local : informatique";
		}

		return nom + " implantation : " + implantationId + " " + str;
	}
	*/



	
}
