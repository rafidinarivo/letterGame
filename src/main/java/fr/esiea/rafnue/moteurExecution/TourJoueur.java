package fr.esiea.rafnue.moteurExecution;

import fr.esiea.rafnue.core.Joueur;
import fr.esiea.rafnue.repository.DictionnaryRepo;
import fr.esiea.rafnue.repository.PotCommunRepo;
import fr.esiea.rafnue.userInterface.UserInputReader;

public class TourJoueur {
	
	private Joueur joueur;
	private DictionnaryRepo dico;
	private UserInputReader inputReader;
	private PotCommunRepo pot;
	
	public TourJoueur(Joueur joueur, DictionnaryRepo dico, UserInputReader inputReader, PotCommunRepo pot) {
		this.joueur = joueur;
		this.dico = dico;
		this.inputReader = inputReader;
		this.pot = pot;
	}
	
	/**
	 * Retourne true si le joueur à gagné la partie.
	 * 
	 * @param j
	 * @return
	 */
	public boolean demarrerTour() {
		String nomDuJoueur = joueur.getNom();
		
		// Tirage de deux lettres par le joueur
		System.out.println(nomDuJoueur + " merci de tirer deux lettres");
		char lettre1 = joueur.tirerLettre();
		char lettre2 = joueur.tirerLettre();
		
		// Ajout des deux lettres au pots communs
		this.pot.ajoutLettre(lettre1);
		this.pot.ajoutLettre(lettre2);
		
		String motComposeParJoueur = inputReader.readSingleWord(nomDuJoueur + " merci de composer un mot (Appuyer Entree si vous n'avez pas de mot)");
		
		return false;
	}

}
