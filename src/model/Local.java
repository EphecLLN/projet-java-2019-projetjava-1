/**
 * 
 */
package model;

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
	
	public void ajouterMaterielSpecial(String nom, String etat) {
		setChanged();
        notifyObservers();
	}
	
	public void ajouterIntervention(String nom, String commentaire) {
		setChanged();
        notifyObservers();
	}
	
	
}
