/**
 *
 */
package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author lb
 *
 */
@SuppressWarnings({ "unchecked"})
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

///////////////////////////////////////*CONSTRUCTEURS*////////////////////////////////////////////////////////////////////////////////////

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

	public void genererMateriels(int[] chaises, int[] tables) throws SQLException {

			Connexion.generer("insert into materiels values ('', 'chaises', " + chaises[0] + ", " + chaises[1] + ", " + chaises[2] + ", " + chaises[3] + ", " + this.id + ")", "materiels");
			Connexion.generer("insert into materiels values ('', 'tables', " + tables[0] + ", " + tables[1] + ", " + tables[2] + ", " + tables[3] + ", " + this.id + ")", "materiels");
	}
	
	
	public void majMateriels(int[] chaises, int[] tables) throws SQLException {

		Connexion.requete("update materiels set neuf = " + chaises[0] + " where localid = " + this.id + " and nom = 'chaises'");
		Connexion.requete("update materiels set bon = " + chaises[1] + " where localid = " + this.id + " and nom = 'chaises'");
		Connexion.requete("update materiels set materiels.use = " + chaises[2] + " where localid = " + this.id + " and nom = 'chaises'");
		Connexion.requete("update materiels set critique = " + chaises[3] + " where localid = " + this.id + " and nom = 'chaises'");
				
		Connexion.requete("update materiels set neuf = " + tables[0] + " where localid = " + this.id + " and nom = 'tables'");
		Connexion.requete("update materiels set bon = " + tables[1] + " where localid = " + this.id + " and nom = 'tables'");
		Connexion.requete("update materiels set materiels.use = " + tables[2] + " where localid = " + this.id + " and nom = 'tables'");
		Connexion.requete("update materiels set critique = " + tables[3] + " where localid = " + this.id + " and nom = 'tables'");
				

	}
	
	/**
	 * Change la valeur des attributs de type Materiels du local avec la valeur adhoc
	 * @throws SQLException
	 */
	public void setMateriels() throws SQLException {
		try {
		Materiels chaises = (Materiels) Connexion.requete("select * from materiels where nom = 'chaises' and localid = " + this.getId(), "Materiels").get(0);
		Materiels tables = (Materiels) Connexion.requete("select * from materiels where nom = 'tables' and localid = " + this.getId(), "Materiels").get(0);
		this.setNbChaises(chaises);
		this.setNbTables(tables);
		}catch (Exception e) {
			JFrame frame = new JFrame("Erreur");
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    JOptionPane.showMessageDialog(frame, "Inconsistence en base de données : Des entrées de matériels sont manquantes.", "Erreur", JOptionPane.INFORMATION_MESSAGE);
		    System.exit(0);
		}
	}
	
	public MaterielSpecial getMaterielSpecial(String nom) {
		MaterielSpecial materielSpecial = null;
		Iterator<MaterielSpecial> iterateur = this.getMaterielsSpeciaux().iterator();
		boolean trouve = false;
		while(iterateur.hasNext() && !trouve) {
			materielSpecial = iterateur.next();
			if(materielSpecial.getNom().equals(nom)) {
				trouve = true;
			}
		}
		return materielSpecial;
	}

	public Intervention getIntervention(String nom) {
		Intervention intervention = null;
		Iterator<Intervention> iterateur = this.getInterventions().iterator();
		boolean trouve = false;
		while(iterateur.hasNext() && !trouve) {
			intervention = iterateur.next();
			if(intervention.getNom().equals(nom)) {
				trouve = true;
			}
		}
		return intervention;
	}
	
	
	/**
	 * Permet de générer un nouveau matériel spécial.
	 * Il est enregistré en bdd et ajouté au modèle.
	 * @param nom
	 * @param etat
	 * @throws SQLException
	 */
	public void genererMaterielSpecial(String nom, String etat) throws SQLException {

		int id = Connexion.generer("insert into materielspecial values ('','" + nom + "','" + etat + "', " + this.id + ")", "materielSpecial");
		MaterielSpecial matSpe = (MaterielSpecial) Connexion.requete("select * from materielSpecial where id = " + id, "MaterielSpecial").get(0);
		this.getMaterielsSpeciaux().add(matSpe);
	}

	/**
	 * Permet de générer une nouvelle intervention.
	 * Elle est enregistrée en bdd et ajoutée au modèle
	 * @param nom
	 * @param commentaires
	 * @throws SQLException
	 */
	public void genererIntervention(String nom, String commentaires) throws SQLException {

		int id = Connexion.generer("insert into intervention values ('','"+ nom +"','"+ commentaires +"', " + this.id + ")", "intervention");
		Intervention inte = (Intervention) Connexion.requete("select * from intervention where id = " + id, "Intervention").get(0);
		this.getInterventions().add(inte);
	}
	


	/**
	 * Supprime l'objet qui l'appelle en bdd
	 * @throws SQLException
	 */
	public void supprimer() throws SQLException {

		this.nbChaises.supprimer();
		this.nbTables.supprimer();
		for (Intervention intervention : interventions) {
			intervention.supprimer();
		}
		for (MaterielSpecial materielSpecial : materielsSpeciaux) {
			materielSpecial.supprimer();
		}
		Connexion.supprimer(this, this.id);
	}

///////////////////////////////////////*METHODE TOSTRING*////////////////////////////////////////////////////////////////////////////////////


	public String toString() {

		return nom + " "  + "nombre d'interventions " + this.interventions.size();
	}





}
