/**
 * 
 */
package model;

/**
 * @author lb
 *
 */
public class LocalInformatique {
	
	
///////////////////////////////////////*ATTRIBUTS*/////////////////////////////////////////////////////////////////////////////////////////////

	
	private Pc[] nbPcs;
	
///////////////////////////////////////*GETTERS ET SETTERS*////////////////////////////////////////////////////////////////////////////////////

	/**
	 * @return the nbPcs
	 */
	public Pc[] getNbPcs() {
		return nbPcs;
	}

	/**
	 * @param nbPcs the nbPcs to set
	 */
	public void setNbPcs(Pc[] nbPcs) {
		this.nbPcs = nbPcs;
	}

	
///////////////////////////////////////*CONSTRUCTEURS*////////////////////////////////////////////////////////////////////////////////////


	public LocalInformatique(int id, String nom, Materiels nbChaises, MaterielSpecial materielSpecial, Intervention intervention, Pc[] nbPcs) {
		// TODO Auto-generated constructor stub
		//super(id, nom, nbChaises, materielSpecial, intervention);
		this.nbPcs = nbPcs;
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




///////////////////////////////////////*METHODES*/////////////////////////////////////////////////////////////////////////////////////////
	
}
