/**
 *
 */
package model;

import java.sql.SQLException;

/**
 * Classe permettant la representation de materiel special
 * @author igorv
 *
 */
public class MaterielSpecial {

///////////////////////////////////////*ATTRIBUTS*/////////////////////////////////////////////////////////////////////////////////////////////

		private int id;
		private String nom;
		private String etat;

///////////////////////////////////////*GETTERS ET SETTERS*////////////////////////////////////////////////////////////////////////////////////

		/**
		 * @return the id
		 */
		public int getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(int id) {
			this.id = id;
		}

		/**
		 * @return the nom
		 */
		public String getNom() {
			return nom;
		}

		/**
		 * @param nom the nom to set
		 */
		public void setNom(String nom) {
			this.nom = nom;
		}

		/**
		 * @return the etat
		 */
		public String getEtat() {
			return etat;
		}

		/**
		 * @param etat the etat to set
		 */
		public void setEtat(String etat) {
			this.etat = etat;
		}

///////////////////////////////////////*CONSTRUCTEUR*////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Constructeur
	 * @param id
	 * @param nom
	 * @param etat
	 * @param local
	 */
	public MaterielSpecial(int id, String nom, String etat) {
		this.id = id;
		this.nom = nom;
		this.etat = etat;
	}

///////////////////////////////////////*METHODES*/////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Methode permettant de change l'etat du materiel special
	 * @param etat
	 * @throws SQLException 
	 */
	public void majMaterielSpecial(String mat) throws SQLException {
		Connexion.requete("update materielspecial set etat = '" + mat + "' where id = " + this.id );
	}


}
