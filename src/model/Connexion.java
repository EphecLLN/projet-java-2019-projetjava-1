/**
 * 
 */
package model;

import java.sql.*;
import java.util.*;

/**
 * @author lb
 *
 */
public class Connexion {

///////////////////////////////////////*ATTRIBUTS*/////////////////////////////////////////////////////////////////////////////////////////////
	
	private static String url= "jdbc:mysql://localhost/1formatikBdd?serverTimezone=UTC";
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
		requeteStatement = connexion.createStatement();
		if(requeteStatement.execute(req)) {
			resultat = requeteStatement.getResultSet();
		}
	}
	
///////////////////////////////////////*METHODE*/////////////////////////////////////////////////////////////////////////////////////////////
	public static int autoId(String table) throws SQLException {
		Connexion AutoId = new Connexion("Select count(last_insert_id()) from " + table);
		AutoId.resultat.first();
		return AutoId.resultat.getInt(1) + 1;
	}
	
	/**
	 * Permet de faire une requête qui ne renvoie rien (update, delete)
	 * @param requete
	 * @throws SQLException
	 */
	public static void requete(String requete) throws SQLException {
		Connexion conn = new Connexion(requete);
		conn.fermerConnexion();
	}
	
	/**
	 * Permet de récuperer une ArrayList contenant tous les objets d'une classe 
	 * stockés en bdd
	 * @param requete
	 * @param classe
	 * @return ArrayList
	 * @throws SQLException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ArrayList requete(String requete, String classe) throws SQLException {
		ArrayList arr = new ArrayList();
		switch(classe){
			case "Adresse":
				arr = new ArrayList<Adresse>();
				break;
			case "Implantation":
				arr = new ArrayList<Implantation>();
				break;
			case "Utilisateur":
				arr = new ArrayList<Utilisateur>();
				break;
			case "Local":
				arr = new ArrayList<Local>();
				break;
			case "Materiels":
				arr = new ArrayList<Materiels>();
				break;
			case "MaterielSpecial":
				arr = new ArrayList<MaterielSpecial>();
				break;
			case "Pc":
				arr = new ArrayList<Pc>();
				break;
			case "Intervention":
				arr = new ArrayList<Intervention>();
					break;
			default : throw new IllegalArgumentException("Valeur incorrecte : " + classe);
		}
		
		Connexion conn = new Connexion(requete);
		while(conn.resultat.next()) {
			switch(classe) {
				case "Adresse":
					arr.add(new Adresse(conn.resultat.getInt("id"),conn.resultat.getInt("numero"),conn.resultat.getString("rue"), conn.resultat.getString("ville"),conn.resultat.getInt("codePostal")));
					break;
				case "Implantation":
					arr.add(new Implantation(conn.resultat.getInt("id"), conn.resultat.getString("nom"), new Adresse(conn.resultat.getInt("adresseId"), 0, null, null, 0)));
					break;
				case "Utilisateur":
					arr.add(new Utilisateur(conn.resultat.getInt("id"), conn.resultat.getString("nom"), conn.resultat.getString("prenom"), conn.resultat.getInt("grade"),  conn.resultat.getString("pseudo"),  conn.resultat.getString("mdp")));
					break;
				case "Local":
					if(conn.resultat.getInt("localInformatique") == 0) {
						arr.add(new Local(conn.resultat.getInt("id"), conn.resultat.getString("nom"), null, null));
					}
					else {
						arr.add(new LocalInformatique(conn.resultat.getInt("id"), conn.resultat.getString("nom"), null, null));
					}
					break;
				case "Materiels":
					arr.add(new Materiels(conn.resultat.getInt("id"), conn.resultat.getString("nom"),conn.resultat.getInt("neuf"), conn.resultat.getInt("bon"), conn.resultat.getInt("use"), conn.resultat.getInt("critique")));
					break;
				case "MaterielSpecial":
					arr.add(new MaterielSpecial(conn.resultat.getInt("id"), conn.resultat.getString("nom"), conn.resultat.getString("etat")));
					break;
				case "Pc":
					arr.add(new Pc(conn.resultat.getInt("id"), conn.resultat.getString("nom"), conn.resultat.getString("type"), conn.resultat.getString("tour"), conn.resultat.getString("ecran"), conn.resultat.getString("clavier"), conn.resultat.getString("souris"), conn.resultat.getString("commentaires")));
					break;
				case "Intervention":	
					arr.add(new Intervention(conn.resultat.getInt("id"), conn.resultat.getString("nom"), conn.resultat.getString("commentaires")));
					break;
				default : throw new IllegalArgumentException("Valeur incorrecte : " + classe);
			}
		}
		conn.fermerConnexion();
		return arr;
	}
	
	/**
	 * Permet de créer une nouvelle entité. Elle est stocké en bdd.
	 * @param requete
	 * @param table
	 * @return
	 * @throws SQLException
	 */
	public static int generer(String requete, String table) throws SQLException {
		int id = autoId(table);
		System.out.println(requete.substring(0, requete.indexOf("''")) + id + requete.substring(requete.indexOf("''")+2));
		Connexion conn = new Connexion(requete.substring(0, requete.indexOf("''")) + id + requete.substring(requete.indexOf("''")+2));
		conn.fermerConnexion();
		return id;
	}

	public static void supprimer(Object obj, int id) throws SQLException {
		Connexion.requete("delete from " + obj.getClass().getSimpleName().toLowerCase() + " where id = " + id);
	}
	
	public void fermerConnexion() throws SQLException {
		connexion.close();
	}
}
