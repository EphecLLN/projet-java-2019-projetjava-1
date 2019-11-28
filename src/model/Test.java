/**
 * 
 */
package model;

import java.util.Observable;

/**
 * @author Victoire
 *
 */
@SuppressWarnings("deprecation")
public class Test extends Observable{

	int num = 0;
	
	public int getNummm() {
		setChanged();
        notifyObservers();
		return num;
	}
}
