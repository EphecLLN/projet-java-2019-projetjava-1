/**
 *
 */
package model;

import java.util.Observable;

/**
 * @author lb
 *
 */
public class Local extends Observable {

	private int id;
	private String nom;
	private int implantationId;
	private int localInformatique;
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
	 * @return the implantationId
	 */
	public int getImplantationId() {
		return implantationId;
	}
	/**
	 * @param implantationId the implantationId to set
	 */
	public void setImplantationId(int implantationId) {
		this.implantationId = implantationId;
	}
	/**
	 * @return the localInformatique
	 */
	public int getLocalInformatique() {
		return localInformatique;
	}
	/**
	 * @param localInformatique the localInformatique to set
	 */
	public void setLocalInformatique(int localInformatique) {
		this.localInformatique = localInformatique;
	}
	/**
	 * @param id
	 * @param nom
	 * @param implantationId
	 * @param localInformatique
	 */
	public Local(int id, String nom, int implantationId, int localInformatique) {
		this.id = id;
		this.nom = nom;
		this.implantationId = implantationId;
		this.localInformatique = localInformatique;
	}

	public String toString() {

		String str = "Local : classique";
		if(localInformatique == 1) {
			str = "Local : informatique";
		}

		return nom + " implantation : " + implantationId + " " + str;
	}


}
