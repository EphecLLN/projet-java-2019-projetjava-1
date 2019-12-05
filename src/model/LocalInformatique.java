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
	
	public void ajouterPc(int id, int local, String type, String tour, String ecran, String clavier, String souris, String commentaire) throws SQLException {
		Connexion ap = new Connexion("insert into pc values ('"+ id +"','"+ local +"','"+ type +"','"+ tour +"','"+ ecran +"','"+ clavier +",'"+ souris +"','"+ commentaire +"'')");
		setChanged();
        notifyObservers();
	}
	
	public void supprimerPc(int id) throws SQLException {
		Connexion sp = new Connexion("delete from pc where id = "+ id);
		setChanged();
        notifyObservers();
	}

}
