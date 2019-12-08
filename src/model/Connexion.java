/**
 * 
 */
package model;

import java.sql.*;
/**
 * @author lb
 *
 */
public class Connexion {

///////////////////////////////////////*ATTRIBUTS*/////////////////////////////////////////////////////////////////////////////////////////////
	
	private static String url= "jdbc:mysql://localhost/1formatikBdd";
	private static String user = "root";
	private static String mdp = "user1234";

	private String req;
	private Connection connexion;
	private Statement requeteStatement;
	public ResultSet resultat = null;
	
///////////////////////////////////////*CONSTRUCTEURS*/////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * @throws SQLException 
	 * 
	 */
	public Connexion(String requete) throws SQLException {
		req = requete;
		connexion = DriverManager.getConnection(url, user, mdp); 
		Statement requeteStatement = connexion.createStatement();
		if(requeteStatement.execute(req)) {
			resultat = requeteStatement.getResultSet();
		}
	}
	
///////////////////////////////////////*METHODE*/////////////////////////////////////////////////////////////////////////////////////////////


	public void fermerConnexion() throws SQLException {
		connexion.close();
	}
}
