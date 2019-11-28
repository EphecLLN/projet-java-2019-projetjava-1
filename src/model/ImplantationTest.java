/**
 * 
 */
package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Victoire
 *
 */
class ImplantationTest {

	/**
	 * Test method for {@link model.Implantation#genererAdresse()}.
	 */
	@Test
	void testGenererAdresse() {
		Implantation i = new Implantation(1, "Ephec", new Adresse(1, 3, "avenue du ciseau", "lln", 1348));
		i.genererAdresse(new Adresse(1, 3, "avenue du ciseau", "lln", 1348));
		assertEquals(new Adresse(1, 3, "avenue du ciseau", "lln", 1348), i.getAdresse());
	}
	
	/**
	 * Test method for {@link model.Implantation#ajouterLocaux()}.
	 */
	@Test
	void testAjouterLocaux() {
		Implantation i = new Implantation(1, "Ephec", new Adresse(1, 3, "avenue du ciseau", "lln", 1348));
		i.ajouterLocaux();//besoin de la classe local pour la suite
		assertEquals(1, i.getId());
		assertEquals("Ephec", i.getNom());
		assertEquals(new Adresse(1, 3, "avenue du ciseau", "lln", 1348), i.getAdresse());
		
	}

	/**
	 * Test method for {@link model.Implantation#nombreLocauxTotal()}.
	 */
	@Test
	void testNombreLocauxTotal() {
		
		
	}

	/**
	 * Test method for {@link model.Implantation#nombreLocauxInformatiques()}.
	 */
	@Test
	void testNombreLocauxInformatiques() {
		fail("Not yet implemented");
	}

}
