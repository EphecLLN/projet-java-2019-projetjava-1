/**
 * 
 */
package model;

import java.sql.SQLException;

/**
 * @author lb
 *
 */
public class Utils {

	/**
	 * 
	 */
	public Utils() {
		// TODO Auto-generated constructor stub
	}
	
	public static int autoId(String table) throws SQLException {
		Connexion AutoId = new Connexion("Select count(last_insert_id()) from adresse");
		AutoId.resultat.first();
		return AutoId.resultat.getInt(1) + 1;
	}

}
