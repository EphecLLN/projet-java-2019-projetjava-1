/**
 * 
 */
package model;

/**
 * @author lb
 *
 */
public class Pc {

	private int id;
	private int local;
	private String type;
	private String tour;
	private String ecran;
	private String clavier;
	private String souris;
	private String commentaires;
	
	
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}


	/**
	 * @param local
	 * @param type
	 * @param tour
	 * @param ecran
	 * @param clavier
	 * @param souris
	 * @param commentaires
	 */
	public Pc(int id, int local, String type, String tour, String ecran, String clavier, String souris, String commentaires) {
		
		this.id = id;
		this.local = local;
		this.type = type;
		this.tour = tour;
		this.ecran = ecran;
		this.clavier = clavier;
		this.souris = souris;
		this.commentaires = commentaires;
	}
	
	
	public void changerEtat(String nom, String etat) {
		switch (nom) {
		case "type":
			this.type = etat;
			break;
		case "tour":
			this.tour = etat;
			break;
		case "ecran":
			this.ecran = etat;
			break;
		case "clavier":
			this.clavier = etat;
			break;
		case "souris":
			this.souris = etat;
			break;
		case "commentaires":
			this.commentaires = etat;
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + nom);
		}
	}

}
