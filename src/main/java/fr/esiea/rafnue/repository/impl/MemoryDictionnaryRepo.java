package fr.esiea.rafnue.repository.impl;

import java.io.File;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import fr.esiea.rafnue.repository.DictionnaryRepo;

/**
 * Implementation en mémoire du dictionnaire. 
 * Le fichier du dictionnaire doit être dans le classpath (géré avec Maven)
 * 
 *  Cette classe est un singleton.
 *
 */
public class MemoryDictionnaryRepo implements DictionnaryRepo {
	
	private static final String DICTIONNARY_FILE_NAME = "dico.txt";
	
	/**
	 * Unique instance
	 */
	private static MemoryDictionnaryRepo instance;
	
	private Set<String> words;
	
	private MemoryDictionnaryRepo() {
		super();
		words = new HashSet<>();
		init();
	}
	
	/**
	 * Lecture du fichier dictionnaire
	 */
	private void init() {
		URL url = getClass().getClassLoader().getResource(DICTIONNARY_FILE_NAME);
		File dicoFile;
		Scanner scanner = null;
		try {
			dicoFile = new File(url.toURI());
			scanner = new Scanner(dicoFile);
		} catch (Exception e) {
			throw new RuntimeException("Impossible de lire le fichier " + DICTIONNARY_FILE_NAME + " pour initialiser le dictionnaire", e);
		}
		
		while(scanner.hasNext()) {
			String currentDicoWords = scanner.next();
			this.words.add(currentDicoWords);
		}
		
		scanner.close();
	}
	
	public static MemoryDictionnaryRepo getInstance() {
		if (instance == null) {
			instance = new MemoryDictionnaryRepo();
		}
		
		return instance;
	}
	
	@Override
	public boolean contient(String motAValider) {
		if (motAValider == null)
			return false;
		
		return this.words.contains(motAValider.trim().toLowerCase());
	}
}
