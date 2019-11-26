/**
 * 
 */
package model;

/**
 * @author Victoire
 *
 */
public class Implantation {
	
	
	private int id;
	private String nom;
	private Adresse adresse;
	Local[] locaux; //à compléter une fois la classe local liée
	
	int[] test = {1, 4, 6, 7};//tableaux de int pour tester les méthodes
	int[] test2 = {1, 5, 3, 7};//tableaux de int pour tester les méthodes
	
	
	public Implantation(int id, String nom, Adresse adresse) {
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		
	}
	
	
	public void genererAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	public void ajouterLocaux() {
		
	}
	
	public int nombreLocauxTotal() {
		return this.locaux.Length;
	}
	
	public int nombreLocauxInformatiques() {
		
		//compter uniquement le nombre de locaux informatiques
		
		return 0;
	}
	
	
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
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


}
