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

	public void ajouterMaterielSpecial(int id, String nom, String etat, int local) throws SQLException {
		Connexion ams = new Connexion("insert into materielspecial values ('"+ id +"','"+ nom +"','"+ etat +"')");
		
	}
	public void ajouterIntervention(int id, String nom, String commentaire) throws SQLException {
		Connexion ai = new Connexion("insert into intervention values ('"+ id +"','"+ nom +"','"+ commentaire +"')");
	}
	
	public void genererMateriels(int[] chaises, int[] tables, int localid) throws SQLException {
		int id = Utils.autoId("materiels");
		Connexion gm = new Connexion("insert into materiels values (" + id + ", 'chaises', " + chaises[0] + ", " + chaises[1] + ", " + chaises[2] + ", " + chaises[3] + ", " + localid + ") , (" + (id + 1) + ", 'tables', " + tables[0] + ", " + tables[1] + ", " + tables[2] + ", " + tables[3] + ", " + localid + ")");
		gm.fermerConnexion();
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
