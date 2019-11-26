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
class MatérielsTest {

	@Test
	public void testActualiser() {
		Matériels chaise = new Matériels(1,2,3,4);
		assertEquals(1, chaise.getNeuf());
		assertEquals(2, chaise.getBon());
		assertEquals(3, chaise.getUse());
		assertEquals(4, chaise.getCritique());
	}
	
	@Test
	public void testTotal() {
		Matériels tt = new Matériels(1,2,3,4);
		assertEquals(10, tt.total(1,2,3,4));
	}

}
