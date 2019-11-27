/**
 * 
 */
package view;

import java.util.Observer;

/**
 * @author Victoire
 *
 */
public abstract class Vue implements Observer{

	public abstract void affiche(String string);
}
