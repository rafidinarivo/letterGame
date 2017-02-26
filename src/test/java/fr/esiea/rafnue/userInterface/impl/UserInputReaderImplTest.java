package fr.esiea.rafnue.userInterface.impl;

import org.junit.Assert;
import org.junit.Test;

import fr.esiea.rafnue.userInterface.UserInputReader;

/**
 * Test unitaire de UserInputReaderImpl
 */
public class UserInputReaderImplTest {
	
	@Test
	public void testSingleton() {
		UserInputReader uIn1 = UserInputReaderImpl.getInstance();
		UserInputReader uIn2 = UserInputReaderImpl.getInstance();
		
		Assert.assertNotNull("Impossible de creer une instance de UserInputReaderImpl", uIn1);
		Assert.assertTrue("Attention UserInputReaderImpl n'est pas un singleton", uIn1.equals(uIn2));
	}

}
