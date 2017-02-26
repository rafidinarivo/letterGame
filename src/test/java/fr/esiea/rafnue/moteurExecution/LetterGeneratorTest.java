package fr.esiea.rafnue.moteurExecution;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test unitaire de LetterGenerator
 */
public class LetterGeneratorTest {
	
	private static final char LETTRE_A_MAJUSCULE = 'A';
	private static final char LETTRE_Z_MAJUSCULE = 'Z';
	
	@Test
	public void testConstruction() {
		LetterGenerator letterGen = LetterGenerator.getInstance();
		Assert.assertNotNull("Erreur lors de la création du générateur de lettre", letterGen);
	}
	
	@Test
	public void testGenerateLetter() {
		LetterGenerator letterGen = LetterGenerator.getInstance();
		Character letter = letterGen.generateLetter();
		Assert.assertNotNull("Aucune lettre générée par le générateur de lettre", letter);
		
		boolean lettreEntreAetZ = letter.compareTo(LETTRE_A_MAJUSCULE) >= 0 && letter.compareTo(LETTRE_Z_MAJUSCULE) <= 0;
		Assert.assertTrue("Attention la valeur générer n'est pas comprise entre a et z", lettreEntreAetZ);
	}
}
