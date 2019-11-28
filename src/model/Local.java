/**
 * 
 */
package model;

import java.sql.SQLException;
import java.util.Observable;

/**
 * @author lb
 *
 */
public class Local extends Observable {
	
	private int id;
	private Materiels nbChaises;
	private Materiels nbTables;
	private MaterielSpecial [] materielsSpecials;
	private Intervention [] interventions;
	
	
	
	/**
	 * @return the nbChaises
	 */
	public Materiels getNbChaises() {
		return nbChaises;
	}


	/**
	 * @return the nbTables
	 */
	public Materiels getNbTables() {
		return nbTables;
	}

	/**
	 * @return the materielsSpecials
	 */
	public MaterielSpecial[] getMaterielsSpecials() {
		return materielsSpecials;
	}


	/**
	 * @return the interventions
	 */
	public Intervention[] getInterventions() {
		return interventions;
	}



	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}



	/**
	 * @param id
	 * @param nbChaises
	 * @param nbTables
	 * @param materielsSpecials
	 * @param interventions
	 */
	public Local(int id, Materiels nbChaises, Materiels nbTables, MaterielSpecial[] materielsSpecials,
			Intervention[] interventions) {
		this.id = id;
		this.nbChaises = nbChaises;
		this.nbTables = nbTables;
		this.materielsSpecials = materielsSpecials;
		this.interventions = interventions;
	}
	
	public void ajouterMaterielSpecial(int id, String nom, String etat, int local) throws SQLException {
		Connexion ams = new Connexion("insert into materielspecial values ('"+ id +"','"+ nom +"','"+ etat +"')");
		setChanged();
        notifyObservers();
	}
	
	public void ajouterIntervention(int id, String nom, String commentaire) throws SQLException {
		Connexion ai = new Connexion("insert into intervention values ('"+ id +"','"+ nom +"','"+ commentaire +"')");
		setChanged();
        notifyObservers();
	}
}
