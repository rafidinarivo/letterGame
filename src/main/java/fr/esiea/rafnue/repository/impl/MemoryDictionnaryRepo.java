package fr.esiea.rafnue.repository.impl;

import fr.esiea.rafnue.repository.DictionnaryRepo;

/**
 * Implementation en mémoire du dictionnaire. 
 * Le fichier du dictionnaire doit être dans le classpath (géré avec Maven)
 * 
 *  Cette classe est un singleton.
 *
 */
public class MemoryDictionnaryRepo implements DictionnaryRepo {
	
	/**
	 * Nom du fichier dictionnaire
	 */
	private String dictionnaryFileName;
	
	public MemoryDictionnaryRepo(String dictionnaryFileName) {
		super();
		this.dictionnaryFileName = dictionnaryFileName;
	}

	@Override
	public boolean contient(String motAValider) {
		return false;
	}

}
