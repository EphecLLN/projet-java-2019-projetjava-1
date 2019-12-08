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
@SuppressWarnings("deprecation")
public class Ecole extends Observable {

	public ArrayList<Implantation> implantations = new ArrayList<Implantation>();

	public Ecole() throws SQLException {

		ajouterImplantationsEtAdresses();
		ajouterUtilisateurs();
		ajouterLocalEtMateriel();
		ajouterMaterielsSpeciaux();

		}

	public void ajouterImplantationsEtAdresses() throws SQLException {
		//on récupère les adresses
				Connexion connAdresse = new Connexion("select * from adresse");
				connAdresse.resultat.first();
				//on créé des varibales pour les boucles
				Connexion connImplantation;
				Implantation imp;
				//pour chaque adresse récupéré
				while(!connAdresse.resultat.isAfterLast()) {
					//on récupère l'implantation associée
					connImplantation = new Connexion("select * from implantation where id = " + connAdresse.resultat.getInt("id"));
					connImplantation.resultat.first();
					//On instancie l'implantation et l'adresse
					imp = new Implantation(connImplantation.resultat.getInt("id"), connImplantation.resultat.getString("nom"), new Adresse(connAdresse.resultat.getInt("id"),connAdresse.resultat.getInt("numero"),connAdresse.resultat.getString("rue"), connAdresse.resultat.getString("ville"),connAdresse.resultat.getInt("codePostal")));
					//on ajoute l'implantation dans l'arraylist implantations de ecole
					implantations.add(imp);
					connAdresse.resultat.next();
				}
				connAdresse.fermerConnexion();
	}

	public void ajouterUtilisateurs() throws SQLException {
		Connexion connUtilisateur;
		for(Implantation uneImp: implantations) {
			//on récupère les utilisateurs associés à l'implantation
			connUtilisateur = new Connexion("select * from utilisateur where implantationId = " + uneImp.getId());
			connUtilisateur.resultat.first();
			//pour chaque utilisateur
			while(!connUtilisateur.resultat.isAfterLast()) {
				//on instancie l'utilisateur et on l'ajoute à l'arraylist utilisateurs de l'implantation
				uneImp.getUtilisateurs().add(new Utilisateur(connUtilisateur.resultat.getInt("id"), connUtilisateur.resultat.getString("nom"), connUtilisateur.resultat.getString("prenom"), connUtilisateur.resultat.getInt("grade"),  connUtilisateur.resultat.getString("pseudo"),  connUtilisateur.resultat.getString("mdp")));
				connUtilisateur.resultat.next();
			}
			connUtilisateur.fermerConnexion();
		}
	}

	public void ajouterLocalEtMateriel() throws SQLException {
		Connexion connMaterielsChaises, connMaterielsTables, connLocal;
		for(Implantation uneImp: implantations) {
			connLocal = new Connexion("select * from local where implantationId = " + uneImp.getId());
			connLocal.resultat.first();
			while(!connLocal.resultat.isAfterLast()) {
				connMaterielsChaises = new Connexion("select * from materiels where nom = 'chaises' and localid = " + connLocal.resultat.getInt("id"));
				connMaterielsTables = new Connexion("select * from materiels where nom = 'tables' and localid = " + connLocal.resultat.getInt("id"));
				connMaterielsChaises.resultat.first();
				connMaterielsTables.resultat.first();
				if(connLocal.resultat.getInt("localinformatique") == 0) {
					uneImp.getLocaux().add(new Local(connLocal.resultat.getInt("id"), connLocal.resultat.getString("nom"), new Materiels(connMaterielsChaises.resultat.getInt("id"), connMaterielsChaises.resultat.getString("nom"),connMaterielsChaises.resultat.getInt("neuf"), connMaterielsChaises.resultat.getInt("bon"), connMaterielsChaises.resultat.getInt("use"), connMaterielsChaises.resultat.getInt("critique")), new Materiels(connMaterielsTables.resultat.getInt("id"), connMaterielsTables.resultat.getString("nom"),connMaterielsTables.resultat.getInt("neuf"), connMaterielsTables.resultat.getInt("bon"), connMaterielsTables.resultat.getInt("use"), connMaterielsTables.resultat.getInt("critique"))));
				}
				else {
					uneImp.getLocaux().add(new LocalInformatique(connLocal.resultat.getInt("id"), connLocal.resultat.getString("nom"), new Materiels(connMaterielsChaises.resultat.getInt("id"), connMaterielsChaises.resultat.getString("nom"),connMaterielsChaises.resultat.getInt("neuf"), connMaterielsChaises.resultat.getInt("bon"), connMaterielsChaises.resultat.getInt("use"), connMaterielsChaises.resultat.getInt("critique")), new Materiels(connMaterielsTables.resultat.getInt("id"), connMaterielsTables.resultat.getString("nom"),connMaterielsTables.resultat.getInt("neuf"), connMaterielsTables.resultat.getInt("bon"), connMaterielsTables.resultat.getInt("use"), connMaterielsTables.resultat.getInt("critique"))));

				}
				connMaterielsChaises.fermerConnexion();
				connMaterielsTables.fermerConnexion();
				connLocal.resultat.next();
			}
			connLocal.fermerConnexion();
		}
	}

	public void ajouterMaterielsSpeciaux() throws SQLException {
		Connexion connMaterielSpeciaux, connPcs;
		for(Implantation uneImp : implantations) {
			for(Local unLoc : uneImp.getLocaux()) {
				connMaterielSpeciaux = new Connexion("select * from materielSpecial where localId = " + unLoc.getId());
				connMaterielSpeciaux.resultat.first();
				while(! connMaterielSpeciaux.resultat.isAfterLast()) {
					unLoc.getMaterielsSpeciaux().add(new MaterielSpecial(connMaterielSpeciaux.resultat.getInt("id"), connMaterielSpeciaux.resultat.getString("nom"), connMaterielSpeciaux.resultat.getString("etat")));
					connMaterielSpeciaux.resultat.next();
				}
				connMaterielSpeciaux.fermerConnexion();
				if(unLoc.getClass().getSimpleName().equals("LocalInformatique")) {
					LocalInformatique unLocInf = (LocalInformatique) unLoc;
					connPcs = new Connexion("select * from pc where localid = " + unLoc.getId());
					connPcs.resultat.first();
					while(! connPcs.resultat.isAfterLast()) {
						unLocInf.getPcs().add(new Pc(connPcs.resultat.getInt("id"), connPcs.resultat.getString("nom"), connPcs.resultat.getString("type"), connPcs.resultat.getString("tour"), connPcs.resultat.getString("ecran"), connPcs.resultat.getString("clavier"), connPcs.resultat.getString("souris"), connPcs.resultat.getString("commentaires")));
						connPcs.resultat.next();
					}
					connPcs.fermerConnexion();
				}
			}
		}
	}

	public static void main(String args[]) throws SQLException {
		Ecole e1 = new Ecole();

		System.out.println(e1.implantations.get(0).getLocaux().get(1).getNbChaises().getCritique());
	}
}
