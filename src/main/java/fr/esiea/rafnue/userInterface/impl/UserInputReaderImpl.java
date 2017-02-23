package fr.esiea.rafnue.userInterface.impl;

import java.util.NoSuchElementException;
import java.util.Scanner;

import fr.esiea.rafnue.userInterface.UserInputReader;

/**
 * Implementation par defaut (singleton)
 * 
 * @author lti
 *
 */
public class UserInputReaderImpl implements UserInputReader {
	
	public static UserInputReaderImpl getInstance() {
		return new UserInputReaderImpl();
	}

	public UserInputReaderImpl() {
		super();
	}

	@Override
	public String readSingleWord(String message) {
		Scanner scanner = null;
		String result = null;
		boolean finDeSaisie = false;

		while (!finDeSaisie) {
			try {
				scanner = new Scanner(System.in);
				System.out.println(message + " (Appuyer sur ENTREE pour ne rien saisir)");

				boolean hasNext = scanner.hasNext();
				
				if (!hasNext) {
					System.out.println("Vous ne souhaitez rien saisir, confirmez-vous ce choix ? (Appuyer sur ENTREE pour valider ou saisissez votre mot)"); 
				}
				
				result = scanner.nextLine();
			} catch (NoSuchElementException e) {
				finDeSaisie = true;
			}
			
			finDeSaisie = true;
		}

		return result;
	}

	@Override
	public String[] readWords() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Character readSingleLetter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Character[] readTwoLetter() {
		// TODO Auto-generated method stub
		return null;
	}

}
