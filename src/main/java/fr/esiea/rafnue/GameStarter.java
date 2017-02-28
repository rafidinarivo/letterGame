package fr.esiea.rafnue;

import java.awt.List;
import java.util.ArrayList;

import fr.esiea.rafnue.moteurExecution.Joueur;
import fr.esiea.rafnue.userInterface.UserInputReader;
import fr.esiea.rafnue.userInterface.impl.UserInputReaderImpl;

public class GameStarter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
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
		
		// Demander aux joueurs de tirer une lettre au hasard
		Character lettreJoueur1 = joueur1.tirerLettre();
		Character lettreJoueur2 = joueur2.tirerLettre();
		
		// Ajout des lettres aux lettres tirées par les joueurs
		joueur1.ajouterLettreUtilisateur(lettreJoueur1);
		joueur2.ajouterLettreUtilisateur(lettreJoueur2);
		
		// Ajout des lettres dans le pot commun
	}
	
	public static void acceuil(Joueur j1, Joueur j2) {
		String nomJoueur1 = j1.getNom();
		String nomJoueur2 = j2.getNom();
		
		System.out.println("Bienvenue à vous " + nomJoueur1 + " et " + nomJoueur2 + " dans cette nouvelle partie.");
	}
	
}
