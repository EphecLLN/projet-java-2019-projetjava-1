/**
 * 
 */
package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author igorv
 *
 */
class MaterielSpecialTest {

	/**
	 * Test method for {@link model.MatérielSpécial#changerEtat(java.lang.String)}.
	 */
	@Test
	public void testChangerEtat() {
		MaterielSpecial ms1 = new MaterielSpecial(0, " ", "sale", 0);
		assertEquals("sale", ms1.getEtat());
	}
}
