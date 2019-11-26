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
class UtilisateurTest {

	@Test
	void test() {
		Utilisateur u = new Utilisateur(1, "m", "v", "gérant", "vm", "1234", "ephec" );
		u.ajouterUtilisateur(1, "m", "v", "gérant", "vm", "1234", "ephec" );
		assertEquals(1, u.getId());
		assertEquals("m", u.getNom());
		assertEquals("v", u.getPrenom());
		assertEquals("vm", u.getPseudo());
		assertEquals("1234", u.getMotDePasse());
		assertEquals("ephec", u.getImplantation());
		
		u.changerGrade("prof");
		assertEquals("prof", u.getGrade());
		
		u.supprimerUtilisateur(1);
		assertEquals("", u.getId());
		
		// à compléter u.authentifier()
		
		u.changerPseudo("pepe");
		assertEquals("pepe", u.getPseudo());
		
		u.changerMDP("0987");
		assertEquals("0987", u.getMotDePasse());
		
		// à completer u.synchroniserBDD()
		
		
	}

}
