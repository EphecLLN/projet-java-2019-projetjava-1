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
public class LocalInformatique extends Local{
	
	
///////////////////////////////////////*ATTRIBUTS*/////////////////////////////////////////////////////////////////////////////////////////////

	
	private ArrayList<Pc> pcs = new ArrayList<Pc>();
	
///////////////////////////////////////*GETTERS ET SETTERS*////////////////////////////////////////////////////////////////////////////////////

	/**
	 * @return the pcs
	 */
	public ArrayList<Pc> getPcs() {
		return pcs;
	}

	/**
	 * @param pcs the pcs to set
	 */
	public void setPcs(ArrayList<Pc> pcs) {
		this.pcs = pcs;
	}

	
///////////////////////////////////////*CONSTRUCTEURS*////////////////////////////////////////////////////////////////////////////////////


	public LocalInformatique(int id, String nom, Materiels nbChaises, Materiels nbTables) {
		// TODO Auto-generated constructor stub
		super(id, nom, nbChaises, nbTables);
	}

///////////////////////////////////////*METHODES*/////////////////////////////////////////////////////////////////////////////////////////
	public void ajouterPc(int id, int local, String type, String tour, String ecran, String clavier, String souris, String commentaire) throws SQLException {
		Connexion ap = new Connexion("insert into pc values ('"+ id +"','"+ local +"','"+ type +"','"+ tour +"','"+ ecran +"','"+ clavier +",'"+ souris +"','"+ commentaire +"'')");
		
	}
	
	public void supprimerPc(int id) throws SQLException {
		Connexion sp = new Connexion("delete from pc where id = "+ id);
		
       
	}
	
	
	
}
