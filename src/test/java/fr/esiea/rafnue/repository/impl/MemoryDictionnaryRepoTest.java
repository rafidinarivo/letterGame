package fr.esiea.rafnue.repository.impl;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test unitaire de MemoryDictionnaryRepoTest
 */
public class MemoryDictionnaryRepoTest {
	
	@Test
	public void testContructeur() throws FileNotFoundException {
		MemoryDictionnaryRepo dico = MemoryDictionnaryRepo.getInstance();
		Assert.assertNotNull("Aucune instance de MemoryDictionnaryRepo crée", dico);
	}
	
	@Test
	public void testContientMot() throws FileNotFoundException {
		MemoryDictionnaryRepo dico = MemoryDictionnaryRepo.getInstance();
		String motExistant = "bonjour";
		boolean exist = dico.contient(motExistant);
		Assert.assertTrue("Le mot " + motExistant + " devrait exister dans le dictionnaire", exist);
	}
	
	@Test
	public void testNeContientPas() throws FileNotFoundException {
		MemoryDictionnaryRepo dico = MemoryDictionnaryRepo.getInstance();
		String motExistant = "zzzzzzzzzzzz";
		boolean exist = dico.contient(motExistant);
		Assert.assertFalse("Le mot " + motExistant + " ne devrait pas exister dans le dictionnaire", exist);
	}

}
