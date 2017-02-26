package fr.esiea.rafnue.userInterface;

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
	public String readSingleWord(String message);
}
