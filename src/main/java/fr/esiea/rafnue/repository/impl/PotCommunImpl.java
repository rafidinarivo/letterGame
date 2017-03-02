package fr.esiea.rafnue.repository.impl;


import java.util.ArrayList;
import java.util.List;

import fr.esiea.rafnue.repository.PotCommunRepo;

public class PotCommunImpl implements PotCommunRepo{
	
	/**
	 * Unique instance
	 */
	private static PotCommunImpl instance;
	
	private List<Character> pot;
	
	private PotCommunImpl() {
		super();
		this.pot = new ArrayList<>();
	}

	public static PotCommunImpl getInstance() {
		if (instance == null) {
			instance = new PotCommunImpl();
		}
		
		return instance;
	}
	
	@Override
	public void ajoutLettre(char a) {
		this.pot.add(a);
		System.out.println();
		System.out.println("Nouvelle lettre ajouté au pot commun. Il contient mainenant les lettres : ");
		System.out.println(this.pot);
	}
	
	@Override
	public boolean estComposeDeLettresDuPot(String mot) {
		// On applique un filtre qui retourne 
		// toutes les lettres du mots qui sont contenues dans le pot commun
		// On compte ensuite le nombre de lettre qui ont passé le filtre
		// On retourne true si ce nombre est égale à la taille du mot en argument
		long nbFiltrer = mot.chars().filter(l -> this.pot.contains((char)l)).count();
		return nbFiltrer == mot.length();
	}
}
