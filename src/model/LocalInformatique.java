/**
 * 
 */
package model;

/**
 * @author lb
 *
 */
public class LocalInformatique extends Local {
	
	private Pc[] nbPcs;
	/**
	 * 
	 */
	public LocalInformatique(int id, Materiels nbChaises, Materiels nbTables, MaterielSpecial[] materielsSpecials,
			Intervention[] interventions) {
		// TODO Auto-generated constructor stub
		super(id, nbChaises, nbTables, materielsSpecials, interventions);
	}

}
