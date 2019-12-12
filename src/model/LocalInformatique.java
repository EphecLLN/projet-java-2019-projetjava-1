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
	
	/**
	 * Permet de générer un nouveau pc. Il est enregistré en bdd
	 * et ajouté au modèle.
	 * @param nom
	 * @param type
	 * @param tour
	 * @param ecran
	 * @param clavier
	 * @param souris
	 * @param commentaires
	 * @throws SQLException
	 */
	public void genererPc(String nom, String type, String tour, String ecran, String clavier, String souris, String commentaires) throws SQLException {
		int id = Connexion.generer("insert into pc values ('', "+ nom +"',"+ this.getId() +",'"+ type +"','"+ tour +"','"+ ecran +"','"+ clavier +",'"+ souris +"','"+ commentaires +"'')", "pc");
		Pc pc = (Pc) Connexion.requete("select * from pc where id = " + id, "Pc").get(0);
		this.getPcs().add(pc);
	}
		
       
	@Override
	public void supprimer() throws SQLException {
		for (Pc pc : pcs) {
			pc.supprimer();
		}
		super.supprimer();
	}
	
}
