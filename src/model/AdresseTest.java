package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AdresseTest {

	@Test
	void testModifierAdresse() {
		Adresse a = new Adresse(1, 5, "avenue", "lln", 1348);
		a.modifierAdresse(22, 1357, "rue du Brasseur", "Hélécine");
		assertEquals(22, a.getNumero());
		assertEquals(1357, a.getCodePostal());
		assertEquals("rue du Brasseur", a.getRue());
		assertEquals("Hélécine", a.getVille());
	}
	
	//on ne peut pas tester l'exception car elle n'est pas encore implémentée

}
