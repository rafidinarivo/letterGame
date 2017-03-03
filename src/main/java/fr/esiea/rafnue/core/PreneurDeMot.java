package fr.esiea.rafnue.core;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import fr.esiea.rafnue.repository.DictionnaryRepo;

/**
 * Prend les mots d'un joueur adverse 
 * lorsque le joueur a trouvé un nouveau mot. 
 *
 */
public class PreneurDeMot implements Observer {
	
	private Joueur joueur1;
	private Joueur joueur2;
	private DictionnaryRepo dico;
	
	/**
	 * Les deux joueurs de la partie
	 * 
	 * @param joueur1
	 * @param joueur2
	 */
	public PreneurDeMot(Joueur joueur1, Joueur joueur2, DictionnaryRepo dico) {
		super();
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		this.dico = dico;
		
		joueur1.addObserver(this);
		joueur2.addObserver(this);
	}


	@Override
	public void update(Observable o, Object arg) {
		if (arg == null || !(arg instanceof String)) {
			System.out.println("Aucun mot transmis au Preneur de mot lors de la notification");
			return;
		}
		
		String nouveauMot = (String) arg;
		
		if (o == joueur1) {
			// Le joueur 1 a trouvé un mot
			prendreMot(nouveauMot, joueur2);
		} else if (o == joueur2) {
			// Le joueur 2 a trouvé un mot
			prendreMot(nouveauMot, joueur1);
		} else {
			System.out.println("Erreur de notification : Le joueur (ou l'objet) " + o + " n'est pas géré par l'observeur PreneurDeMot");
		}
	}
	
	/**
	 * Enlève le mot motAPrendre au joueur j si les conditions sont vérifiées :
	 * - L'un des mots de joueur j commence par motAPrendre
	 * - Les autres caractères sont soit une lettre ou un autre mot valide
	 * 
	 * @param motTrouve
	 * @param j
	 */
	private void prendreMot(String motTrouve, Joueur j) {
		List<String> motsJoueurs = j.getMotsValidseTrouves();
		
		if (motsJoueurs == null || motsJoueurs.isEmpty()) {
			return;
		}
		
		for (String motAPrendre : motsJoueurs) {
			boolean commenceParMotTrouve = motTrouve.startsWith(motAPrendre);
			
			if (commenceParMotTrouve && !motTrouve.equalsIgnoreCase(motAPrendre)) {
				int indexOfOtherPart = motAPrendre.length();
				String otherPart = motTrouve.substring(indexOfOtherPart);
				boolean otherPartInDico = dico.contient(otherPart);
				
				if (otherPart.length() == 1 || otherPartInDico) {
					j.retirerMotValide(motAPrendre);
					System.out.println(j.getNom() + " vient de prendre le mot " + motAPrendre + " à son adversaire.");
				}
			}
		}
	}

}
