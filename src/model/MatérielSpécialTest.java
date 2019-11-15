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
class MatérielSpécialTest {

	/**
	 * Test method for {@link model.MatérielSpécial#changerEtat(java.lang.String)}.
	 */
	@Test
	public void testChangerEtat() {
		MatérielSpécial ms1 = new MatérielSpécial(0, " ", "sale", 0);
		assertEquals("sale", ms1.getEtat());
	}
}
