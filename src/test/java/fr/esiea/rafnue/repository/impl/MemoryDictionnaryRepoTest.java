package fr.esiea.rafnue.repository.impl;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test unitaire de MemoryDictionnaryRepoTest
 */
public class MemoryDictionnaryRepoTest {
	
	@Test
	public void testContructeur() {
		MemoryDictionnaryRepo dico = MemoryDictionnaryRepo.getInstance();
		Assert.assertNotNull("Aucune instance de MemoryDictionnaryRepo crée", dico);
	}
	
	@Test
	public void testContientMot() {
		MemoryDictionnaryRepo dico = MemoryDictionnaryRepo.getInstance();
		String motExistant = "bonjour";
		boolean exist = dico.contient(motExistant);
		Assert.assertTrue("Le mot " + motExistant + " devrait exister dans le dictionnaire", exist);
	}
	
	@Test
	public void testNeContientPas() {
		MemoryDictionnaryRepo dico = MemoryDictionnaryRepo.getInstance();
		String motInexistant = "zzzzzzzzzzzz";
		boolean exist = dico.contient(motInexistant);
		Assert.assertFalse("Le mot " + motInexistant + " ne devrait pas exister dans le dictionnaire", exist);
	}

}
