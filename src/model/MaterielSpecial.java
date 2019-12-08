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
		private int getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		private void setId(int id) {
			this.id = id;
		}

		/**
		 * @return the nom
		 */
		private String getNom() {
			return nom;
		}

		/**
		 * @param nom the nom to set
		 */
		private void setNom(String nom) {
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
		private void setEtat(String etat) {
			this.etat = etat;
		}

///////////////////////////////////////*CONSTRUCTEURS*////////////////////////////////////////////////////////////////////////////////////


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
	 * Methode permettant de change l'etat de la fonction, mais comme je ne connais pas encore les instructions pour acceder � un DB
	 * @param etat
	 * @throws SQLException 
	 */
	public void changerEtat(String etat, String newEtat) throws SQLException {
		Connexion ce = new Connexion("update materielspecial set " + etat + "=" + newEtat + "where id =" + this.id);
		
	}


}
