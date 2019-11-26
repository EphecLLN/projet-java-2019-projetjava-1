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
class Mat�rielsTest {

	@Test
	public void testActualiser() {
		Mat�riels chaise = new Mat�riels(1,2,3,4);
		assertEquals(1, chaise.getNeuf());
		assertEquals(2, chaise.getBon());
		assertEquals(3, chaise.getUse());
		assertEquals(4, chaise.getCritique());
	}
	
	@Test
	public void testTotal() {
		Mat�riels tt = new Mat�riels(1,2,3,4);
		assertEquals(10, tt.total(1,2,3,4));
	}

}
