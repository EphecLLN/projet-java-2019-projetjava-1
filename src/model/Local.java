/**
 *
 */
package model;



/**
 * @author lb
 *
 */
public class Local{

///////////////////////////////////////*ATTRIBUTS*/////////////////////////////////////////////////////////////////////////////////////////////


	private int id;
	private String nom;
	private Materiels nbChaises;
	private MaterielSpecial materielSpecial;
	private Intervention intervention;

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
	 * @return the nbChaises
	 */
	public Materiels getNbChaises() {
		return nbChaises;
	}
	/**
	 * @param nbChaises the nbChaises to set
	 */
	public void setNbChaises(Materiels nbChaises) {
		this.nbChaises = nbChaises;
	}
	/**
	 * @return the materielSpecial
	 */
	public MaterielSpecial getMaterielSpecial() {
		return materielSpecial;
	}
	/**
	 * @param materielSpecial the materielSpecial to set
	 */
	public void setMaterielSpecial(MaterielSpecial materielSpecial) {
		this.materielSpecial = materielSpecial;
	}
	/**
	 * @return the intervention
	 */
	public Intervention getIntervention() {
		return intervention;
	}
	/**
	 * @param intervention the intervention to set
	 */
	public void setIntervention(Intervention intervention) {
		this.intervention = intervention;
	}



///////////////////////////////////////*CONSTRUCTEURS*////////////////////////////////////////////////////////////////////////////////////


	/**
	 * @param id
	 * @param nom
	 * @param intervention2
	 * @param implantationId
	 * @param localInformatique
	 */
	public Local(int id, String nom, Materiels nbChaises, MaterielSpecial materielSpecial, Intervention intervention) {
		this.id = id;
		this.nom = nom;
		this.nbChaises = nbChaises;
		this.materielSpecial = materielSpecial;
		this.intervention = intervention;
	}


///////////////////////////////////////*METHODES*////////////////////////////////////////////////////////////////////////////////////

	public void ajouterMaterielSpecial(String nom, String etat) {

	}

	public void ajouterIntervention(int id, String nom, String etat) {

	}

///////////////////////////////////////*METHODE TOSTRING*////////////////////////////////////////////////////////////////////////////////////

	/*
	public String toString() {

		String str = "Local : classique";
		if(localInformatique == 1) {
			str = "Local : informatique";
		}

		return nom + " implantation : " + implantationId + " " + str;
	}

	public void ajouterMaterielSpecial(int id, String nom, String etat, int local) throws SQLException {
		Connexion ams = new Connexion("insert into materielspecial values ('"+ id +"','"+ nom +"','"+ etat +"')");
		setChanged();
        notifyObservers();
	}

	public void ajouterIntervention(int id, String nom, String commentaire) throws SQLException {
		Connexion ai = new Connexion("insert into intervention values ('"+ id +"','"+ nom +"','"+ commentaire +"')");
		setChanged();
        notifyObservers();
	}


}
