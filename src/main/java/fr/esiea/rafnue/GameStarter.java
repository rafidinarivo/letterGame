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
	
	public static String demanderNom(String message) {
		UserInputReader reader = UserInputReaderImpl.getInstance();
		String nom = "";
		
		boolean nomPasValide = true;
		while (nomPasValide) {
			nom = reader.readSingleWord(message);
			nomPasValide = nom == null;
		}
		
		return nom;
	}
	
	public static void intialiserPartie() {
		System.out.println("Demarrage du jeux");
		
		// Lecture du nom des joueurs
		UserInputReader reader = UserInputReaderImpl.getInstance();
		String nomJoueur1 = demanderNom("Joueur 1 merci de saisir votre nom");
		String nomJoueur2 = demanderNom("Joueur 2 merci de saisir votre nom");
		
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
		
		// Création du pot commun
		PotCommunRepo pot = PotCommunImpl.getInstance();
		
		// Ajout des lettres dans le pot commun
		pot.ajoutLettre(lettreJoueur1);
		pot.ajoutLettre(lettreJoueur2);
		pot.affiche();
		
		// Determination du premier à commencer
		Joueur joueurEnCours = trouvePremierADemarrer(joueur1, joueur2);
		
		Joueur adversaireJoueur;
		if (joueurEnCours == joueur1) {
			adversaireJoueur = joueur2;
		} else {
			adversaireJoueur = joueur1;
		}
		
		boolean joueurEnCoursAGagne = false;
		
		String nomJoueurEnCours = "";
		while (!joueurEnCoursAGagne) {
			nomJoueurEnCours = joueurEnCours.getNom();
			// On demarre un nouveau tour
			System.out.println("C'est le tour de " + nomJoueurEnCours);
			TourJoueur t = new TourJoueur(joueurEnCours, adversaireJoueur, dico, reader, pot);
			joueurEnCoursAGagne = t.demarrerTour();
			
			adversaireJoueur = joueurEnCours;
			if (joueurEnCours == joueur1) {
				joueurEnCours = joueur2;
			} else {
				joueurEnCours = joueur1;
			}
			
			if (!joueurEnCoursAGagne) {
				System.out.println("Fin du tour de " + nomJoueurEnCours);
			}
			
		}
		
		System.out.println("Fin de la partie. " + nomJoueurEnCours + " a gagné !!!");
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
