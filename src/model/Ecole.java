/**
 *
 */
package model;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

/**
 * Classe principale du modèle
 * @author Victoire
 *
 */
@SuppressWarnings({"deprecation", "unchecked"})
public class Ecole extends Observable {

//////////////////////////////////////////////*ATTRIBUTS*//////////////////////////////////////////////////////////////////////////////////
	
	public ArrayList<Implantation> implantations = new ArrayList<Implantation>();

//////////////////////////////////////////////*CONSTRUCTEUR*//////////////////////////////////////////////////////////////////////////////	
	
	public Ecole() throws SQLException {
		synchroImplantationsEtAdresses();
	}

//////////////////////////////////////////////*METHODES*//////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Permet de récupérer et d'instancier les adresses et les implantations qui leur sont associées
	 * @throws SQLException
	 */
	public void synchroImplantationsEtAdresses() throws SQLException {

		if (!implantations.isEmpty()) {
			implantations.clear();
		}

		ArrayList<Adresse> ads = Connexion.requete("select * from adresse", "Adresse");
		ArrayList<Implantation> imps = Connexion.requete("select * from implantation", "Implantation");

		for(Adresse ad : ads) {
			for(Implantation imp : imps) {
				if(ad.getId() == imp.getAdresse().getId()) {
					imp.setAdresse(ad);
					implantations.add(imp);
					imp.synchroUtilisateurs();
					imp.synchroLocalEtMateriel();
				}
			}
		}


	}
	
	/**
	 * Permet d'ajouter une nouvelle implantation. Elle est enregistré en bdd et ajouté dans le modèle
	 * @param nom
	 * @param numero
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @throws SQLException
	 */
	public void genererImplantationEtAdresse(String nom, int numero, String rue, int codePostal, String ville) throws SQLException {
		int adresseId = Connexion.generer("insert into adresse values ('', " + numero + ", '" + rue + "', '" + ville + "', " + codePostal +")", "adresse");
		Connexion.generer("insert into implantation values ('', '" + nom + "', " + adresseId + ")", "implantation");
		Implantation imp = (Implantation) Connexion.requete("select * from implantation where adresseId = " + adresseId, "Implantation").get(0);
		imp.setAdresse((Adresse) Connexion.requete("select * from adresse where id = " + adresseId, "Adresse").get(0));
		this.implantations.add(imp);
	}

	/**
	 * Renvoit un objet de type Implantation.
	 * Ne fait pas partie des getters et des setters
	 * @param nom
	 * @return Implantation
	 */
	public Implantation getImplantation(String nom) {
		Implantation implantation = null;
		Iterator<Implantation> iterateur = this.implantations.iterator();
		boolean trouve = false;
		while(iterateur.hasNext() && !trouve) {
			implantation = iterateur.next();
			if(implantation.getNom().equals(nom)) {
				trouve = true;
			}
		}
		return implantation;
	}
	
}



