package fr.esiea.rafnue.repository.impl;

import org.junit.Assert;
import org.junit.Test;

import fr.esiea.rafnue.repository.PotCommunRepo;

/**
 * Test unitaire de la classe PotCommunImpl  
 */
public class PotCommunImplTest {
	
	private static final char[] lettres = {'a', 'o', 'u', 't', 'b', 'm', 'o', 'i', 'l', 'e'};
	
	PotCommunRepo pot = PotCommunImpl.getInstance();
	
	/**
	 * Initialisation du pot commun
	 */
	public void initPot() {
		for (char c : lettres) {
			pot.ajoutLettre(c);
		}
	}
	
	@Test
	public void verifierMotPasComposerDeLettresDuPot() {
		initPot();
		
		String motATester = "autos";
		boolean estComposeDeLettresDuPot = this.pot.estComposeDeLettresDuPot(motATester);
		Assert.assertFalse("Le mot " + motATester + " n'est pas composé de lettres du pot", estComposeDeLettresDuPot);
	}
	
	@Test
	public void verifierMotComposerDeLettresDuPot() {
		initPot();
		
		String motATester = "mobile";
		boolean estComposeDeLettresDuPot = this.pot.estComposeDeLettresDuPot(motATester);
		Assert.assertTrue("Le mot " + motATester + " est composé de lettres du pot", estComposeDeLettresDuPot);
	}

}
