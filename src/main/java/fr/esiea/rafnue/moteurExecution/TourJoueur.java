package fr.esiea.rafnue.moteurExecution;

import fr.esiea.rafnue.core.Joueur;
import fr.esiea.rafnue.repository.DictionnaryRepo;
import fr.esiea.rafnue.repository.PotCommunRepo;
import fr.esiea.rafnue.userInterface.UserInputReader;

public class TourJoueur {
	
	private Joueur joueur;
	private Joueur adversaire;
	private DictionnaryRepo dico;
	private UserInputReader inputReader;
	private PotCommunRepo pot;
	private static final int NOMBRE_DE_MOTS_A_TROUVE = 10;
	
	public TourJoueur(Joueur joueur, Joueur adversaire, DictionnaryRepo dico, UserInputReader inputReader, PotCommunRepo pot) {
		this.joueur = joueur;
		this.adversaire = adversaire;
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
		
		boolean continuezTour = true;
		while(continuezTour) {
			this.pot.affiche();
			this.joueur.afficheMotValide();
			this.adversaire.afficheMotValide();
			
			String motComposeParJoueur = inputReader.readSingleWord(nomDuJoueur + " merci de composer un mot (Appuyer Entree si vous n'avez pas de mot)");
			
			if(motComposeParJoueur == null) {
				// Arret du tour
				break;
			}
			
			// Verificaion que le mot est composé de lettres du pot commum
			boolean estComposeDeLettreDuPot = this.pot.estComposeDeLettresDuPot(motComposeParJoueur);
			
			// Vérification que le mot existe chez l'adversaire
			boolean motExistChezAdversaire = this.adversaire.aTrouve(motComposeParJoueur);
			
			// Vérification que le mot existe chez le joueur en cours
			boolean motExisteChezLeJoueurEnCours = this.joueur.aTrouve(motComposeParJoueur);
			
			// Vérification que le mot est valide : il est dans le pot et le dictionnaire
			boolean motValide = estComposeDeLettreDuPot && this.dico.contient(motComposeParJoueur);
			
			if (motExistChezAdversaire) {
				System.out.println(this.adversaire.getNom() + " a déjà trouvé le mot " + motComposeParJoueur + " , il ne sera pas pris en compte");
				continuezTour = true;
			} else if (motExisteChezLeJoueurEnCours) {
				System.out.println("Vous avez déjà trouvé le mot " + motComposeParJoueur + " , il ne sera pas pris en compte");
				continuezTour = true;
			} else if (motValide) {
				System.out.println("Bravo " + nomDuJoueur + " ! Vous avez trouvé le mot : " + motComposeParJoueur);
				// Le mot saisie est valide
				this.joueur.ajouterMotValide(motComposeParJoueur);
				
				int nombreMotJoeur = this.joueur.getNombreDeMotValide();
				System.out.println("Vous avez trouve " + nombreMotJoeur + " mot(s) au total.");
				
				continuezTour = nombreMotJoeur < NOMBRE_DE_MOTS_A_TROUVE;
				
				if (continuezTour) {
					char motTire = joueur.tirerLettre();
					this.pot.ajoutLettre(motTire);
				}
			} else {
				// Le mot saisie est invalide
				System.out.println("Le mot saisie n'est pas valide (soit il est composé de lettre qui ne sont pas dans le pot, soit le mot n'existe pas dans le dictionnaire ou bien le mot a déjà été saisi par l'adversaire.)");
				
				String reponseContinuez = "";
				while (reponseContinuez == null || !(reponseContinuez.equalsIgnoreCase("oui") || reponseContinuez.equalsIgnoreCase("non"))) {
					reponseContinuez = inputReader.readSingleWord("Souhaitez-vous saisir un nouveau mot ? Oui/Non");
				}
				
				continuezTour = reponseContinuez.equalsIgnoreCase("oui");
			}
			
		}
		
		boolean aGagne = this.joueur.getNombreDeMotValide() >= NOMBRE_DE_MOTS_A_TROUVE;
		
		return aGagne;
	}

}
