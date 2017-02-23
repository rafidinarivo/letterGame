package fr.esiea.rafnue.infra;

/**
 * Interface pour la lecture des données utilisateurs 
 *
 */
public interface UserInputReader {
	
	/**
	 * Lecture d'un seule mot
	 * 
	 * @return
	 */
	public String readSingleWord();
	
	/**
	 * Lecture de plusieurs mots
	 * 
	 * @return
	 */
	public String[] readWords();
	
	/**
	 * Lecture d'une seule lettre
	 * 
	 * @return
	 */
	public Character readSingleLetter();
	
	/**
	 * Lecture de deux lettres
	 * 
	 * @return
	 */
	public Character[] readTwoLetter();
}
