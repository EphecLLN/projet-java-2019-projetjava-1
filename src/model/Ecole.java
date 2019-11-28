/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.Observable;

/**
 * @author Victoire
 *
 */
public class Ecole extends Observable {

	public Ecole() {
		
	}
	
	
	//ArrayList<Adresse> adresse = new ArrayList<Adresse>();
	ArrayList<Implantation> implantation = new ArrayList<Implantation>();
	ArrayList<Intervention> intervention = new ArrayList<Intervention>();
	ArrayList<Local> local = new ArrayList<Local>();
	ArrayList<LocalInformatique> localInformatique = new ArrayList<LocalInformatique>();
	ArrayList<Materiels> materiel = new ArrayList<Materiels>();
	
	public static void main(String[] args) {
		Adresse a = new Adresse(1,1,1,"ffd","zzz");
		System.out.println(a.getRue());
		a.modifierAdresse(3, 555, "ppp", "zzz");
		System.out.println(a.getRue());
	}
	
}
