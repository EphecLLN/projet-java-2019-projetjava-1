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

	private static String url= "jdbc:mysql://localhost/1formatikBdd";
	private static String user = "root";
	private static String mdp = "user1234";

	private String req;
	private Connection connexion;
	private Statement requeteStatement;
	private ResultSet resultat = null;
	/**
	 * @throws SQLException 
	 * 
	 */
	public Connexion(String requete) throws SQLException {
		req = requete;
		connexion = DriverManager.getConnection(url, user, mdp); 
		requeteStatement = connexion.createStatement();
		resultat = requeteStatement.executeQuery(req);
	}

	public void fermerConnexion() throws SQLException {
		resultat.close();
		requeteStatement.close();
		connexion.close();
	}
	
	public static void main(String args[]) throws SQLException {
		Connexion test = new Connexion("select * from adresse");
		
		test.resultat.next();
		
		System.out.println(test.resultat.getObject(3));
	}
}
