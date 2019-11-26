/**
 * 
 */
package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author lb
 *
 */
class InterventionTest {

	/**
	 * Test method for {@link model.Intervention#modifierIntervention(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testModifierIntervention() {
		Intervention intervention1 = new Intervention(1, "test", "aaaaaaaa");
		
		intervention1.modifierIntervention("test", "zerersfs");
		
		assertEquals("test", intervention1.getNom());
		assertEquals("zerersfs", intervention1.getCommentaires());
		
		intervention1.modifierIntervention("azeazeaze", "zerersfs");
		
		assertEquals("azeazeaze", intervention1.getNom());
		assertEquals("zerersfs", intervention1.getCommentaires());
		
		// On ne peut pas tester l'exception car elle n'est pas encore implémentée
	}

}
