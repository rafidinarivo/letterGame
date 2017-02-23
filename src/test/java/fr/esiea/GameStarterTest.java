package fr.esiea;

import org.junit.Assert;

import org.junit.Test;

import fr.esiea.rafnue.GameStarter;

public class GameStarterTest {
	
	@Test
	public void testInstance() {
		GameStarter starter = new GameStarter();
		Assert.assertNotNull("Aucun objet starter", starter);
	}

}
