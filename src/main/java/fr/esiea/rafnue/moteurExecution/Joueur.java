package fr.esiea.rafnue.moteurExecution;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Represente un joueur
 */
public class Joueur {
	
	private String nom;
	private List<String> motsValidseTrouves;
	private List<Character> lettreUtilisateur;
	
	public Joueur(String nom) {
		this.nom = nom;
		this.motsValidseTrouves = new ArrayList<>();
		this.lettreUtilisateur = new ArrayList<>();
	}
	
	public Character tirerLettre() {
		return null;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void ajouterMot(String mot) {
		this.motsValidseTrouves.add(mot);
	}
	
	public void ajouterLettreUtilisateur(Character lettre) {
		this.lettreUtilisateur.add(lettre);
	}
	
	public void retirerMot(String mot) {
		this.motsValidseTrouves.remove(mot);
	}
}
