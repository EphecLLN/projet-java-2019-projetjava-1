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
class Mat�rielSp�cialTest {

	/**
	 * Test method for {@link model.Mat�rielSp�cial#changerEtat(java.lang.String)}.
	 */
	@Test
	public void testChangerEtat() {
		Mat�rielSp�cial ms1 = new Mat�rielSp�cial(0, " ", "sale", 0);
		assertEquals("sale", ms1.getEtat());
	}
}
