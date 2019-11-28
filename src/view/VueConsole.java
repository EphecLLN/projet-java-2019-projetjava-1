/**
 * 
 */
package view;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Victoire
 *
 */
public class VueConsole extends Vue implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
		//System.out.println(model);
		
	}

	@Override
	public void affiche(String string) {
		// TODO Auto-generated method stub
		System.out.println(string);
	}

}
