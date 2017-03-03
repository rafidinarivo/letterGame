package fr.esiea.rafnue.repository;


/**
 * 
 * Interface représentant le Pot Commun
 * Est utilisé pour contenir des lettres utilisable pour des mots
 *
 */
public interface PotCommunRepo {

	void ajoutLettre(char a);
	
	/**
	 * Vérifie que le mot en paramètre est composé de lettres du pot
	 * 
	 * @param mot
	 * @return
	 */
	boolean estComposeDeLettresDuPot(String mot);
	
	/**
	 * Affiche le contenu du pot commun
	 */
	void affiche();
	
}
