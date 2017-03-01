package fr.esiea.rafnue.core;

import org.junit.Assert;
import org.junit.Test;

import fr.esiea.rafnue.repository.DictionnaryRepo;
import fr.esiea.rafnue.repository.impl.MemoryDictionnaryRepo;

public class PreneurDeMotTest {
	
	private static final String[] MOTS_JOUEUR1 = {"abandonnai", "auto", "voiture"};
	private static final String[] MOTS_JOUEUR2 = {"abandonnais", "automobile", "voiturette"};
	
	private Joueur j1 = new Joueur("j1");
	private Joueur j2 = new Joueur("j2");
	private DictionnaryRepo dico = MemoryDictionnaryRepo.getInstance();
	
	public void initJoueur1() {
		System.out.println("Initialisation des joueurs pour les tests unitaires");
		for (String m : MOTS_JOUEUR1) {
			j1.ajouterMotValide(m);
		}
	}
	
	public void initJoueur2() {
		for (String m : MOTS_JOUEUR2) {
			j2.ajouterMotValide(m);
		}
	}
	
	@Test
	public void testPrendreAucunMot() {
		new PreneurDeMot(j1, j2, dico);
		
		// Initialisation du joueur2
		initJoueur2();
		
		// Aucun mot a prendre
		j1.ajouterMotValide(MOTS_JOUEUR1[2]);
		Assert.assertTrue("Le joueur 2 ne devrait pas avoir perdu de mot", j2.getNombreDeMotValide() == MOTS_JOUEUR2.length);
	}
	
	@Test
	public void testPrendreMotLettreEnPlus() {
		new PreneurDeMot(j1, j2, dico);
		
		// Initialisation du joueur2
		initJoueur2();
		
		// Aucun mot a prendre
		String motAPrendre = MOTS_JOUEUR1[0];
		j1.ajouterMotValide(motAPrendre);
		Assert.assertTrue("Le joueur 2 devrait avoir perdu le mot " + motAPrendre, !j2.getMotsValidseTrouves().contains(MOTS_JOUEUR2[0]));
		Assert.assertTrue("Le joueur 2 devrait avoir perdu le mot " + motAPrendre, j2.getNombreDeMotValide() == (MOTS_JOUEUR2.length - 1));
	}
	
	@Test
	public void testPrendreMotMotEnPlus() {
		new PreneurDeMot(j1, j2, dico);
		
		// Initialisation du joueur2
		initJoueur2();
		
		// Aucun mot a prendre
		String motAJouter = MOTS_JOUEUR1[1];
		String motAPrendre = MOTS_JOUEUR2[1];
		j1.ajouterMotValide(motAJouter);
		Assert.assertFalse("Le joueur 2 devrait avoir perdu le mot " + motAPrendre, j2.getMotsValidseTrouves().contains(motAPrendre));
		Assert.assertTrue("Le joueur 2 devrait avoir perdu le mot " + motAPrendre, j2.getNombreDeMotValide() == (MOTS_JOUEUR2.length - 1));
	}

}
