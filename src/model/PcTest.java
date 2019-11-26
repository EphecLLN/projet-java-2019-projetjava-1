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
class PcTest {

	/**
	 * Test method for {@link model.Pc#changerEtat(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testChangerEtat() {
		Pc pc1 = new Pc(1, 101, "bon", "bon", "bon", "bon", "bon", "bon");
		pc1.changerEtat("type", "mauvais");
		assertEquals("mauvais", pc1.getType());
	}

}
