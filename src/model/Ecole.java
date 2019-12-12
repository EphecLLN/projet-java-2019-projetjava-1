/**
 *
 */
package model;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Observable;

/**
 * @author Victoire
 *
 */
@SuppressWarnings({"deprecation", "unchecked"})
public class Ecole extends Observable {

	public ArrayList<Implantation> implantations = new ArrayList<Implantation>();

	public Ecole() throws SQLException {
		synchroImplantationsEtAdresses();
	}

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

	public static void main(String args[]) throws SQLException {
		Ecole e1 = new Ecole();
		System.out.println(e1.implantations.get(0).getLocaux().get(1).getInterventions().get(0).getNom());
		Utils.recupObjet(e1.implantations);
	}
}
