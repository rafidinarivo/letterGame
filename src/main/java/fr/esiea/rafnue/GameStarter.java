package fr.esiea.rafnue;

import fr.esiea.rafnue.core.Joueur;
import fr.esiea.rafnue.core.PreneurDeMot;
import fr.esiea.rafnue.moteurExecution.TourJoueur;
import fr.esiea.rafnue.repository.DictionnaryRepo;
import fr.esiea.rafnue.repository.PotCommunRepo;
import fr.esiea.rafnue.repository.impl.MemoryDictionnaryRepo;
import fr.esiea.rafnue.repository.impl.PotCommunImpl;
import fr.esiea.rafnue.userInterface.UserInputReader;
import fr.esiea.rafnue.userInterface.impl.UserInputReaderImpl;

public class GameStarter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		intialiserPartie();
		
	}
	
	public static void acceuil(Joueur j1, Joueur j2) {
		String nomJoueur1 = j1.getNom();
		String nomJoueur2 = j2.getNom();
		
		System.out.println("Bienvenue à vous " + nomJoueur1 + " et " + nomJoueur2 + " dans cette nouvelle partie.");
	}
	
	public static void intialiserPartie() {
		System.out.println("Demarrage du jeux");
		
		// Lecture du nom des joueurs
		UserInputReader reader = UserInputReaderImpl.getInstance();
		String nomJoueur1 = reader.readSingleWord("Joueur 1 merci de saisir votre nom");
		String nomJoueur2 = reader.readSingleWord("Joueur 2 merci de saisir votre nom");
		
		// Creation des joueurs
		Joueur joueur1 = new Joueur(nomJoueur1);
		Joueur joueur2 = new Joueur(nomJoueur2);
		
		// Acceuil des joueurs
		acceuil(joueur1, joueur2);
		
		// Initialisation du dictionnaire
		DictionnaryRepo dico = MemoryDictionnaryRepo.getInstance();
		
		// Creation du preneur de mot
		new PreneurDeMot(joueur1, joueur2, dico);
		
		// Demander aux joueurs de tirer une lettre au hasard
		Character lettreJoueur1 = joueur1.tirerLettre();
		Character lettreJoueur2 = joueur2.tirerLettre();
		
		// Ajout des lettres aux lettres tirées par les joueurs
		joueur1.ajouterLettreUtilisateur(lettreJoueur1);
		joueur2.ajouterLettreUtilisateur(lettreJoueur2);
		
		// Ajout des lettres dans le pot commun
		PotCommunRepo pot = PotCommunImpl.getInstance();
		pot.ajoutLettre(lettreJoueur1);
		pot.ajoutLettre(lettreJoueur2);
		
		// Determination du premier à commencer
		Joueur joueurEnCours = trouvePremierADemarrer(joueur1, joueur2);
		boolean joueurEnCoursAGagne = false;
		
		while (!joueurEnCoursAGagne) {
			// On demarre un nouveau tour
			System.out.println("C'est la tour du joueur " + joueurEnCours.getNom());
			TourJoueur t = new TourJoueur(joueurEnCours, dico, reader, pot);
			joueurEnCoursAGagne = t.demarrerTour();
			
			if (joueurEnCours == joueur1) {
				joueurEnCours = joueur2;
			} else {
				joueurEnCours = joueur1;
			}
		}
	}
	
	/**
	 * Permet de déterminer qui commence en premier
	 * @param j1
	 * @param j2
	 * @return
	 */
	public static Joueur trouvePremierADemarrer(Joueur j1, Joueur j2) {
		Character lettrej1 = j1.getLettreUtilisateur().get(0);
		Character lettrej2 = j2.getLettreUtilisateur().get(0);
		
		Joueur premier = null;
		if (lettrej1.compareTo(lettrej2) <= 0) {
			premier = j1;
		} else {
			premier = j2;
		}
		
		return premier;
	}
	
}
