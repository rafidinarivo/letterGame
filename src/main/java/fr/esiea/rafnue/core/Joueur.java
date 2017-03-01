package fr.esiea.rafnue.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import fr.esiea.rafnue.moteurExecution.LetterGenerator;

/**
 * 
 * Represente un joueur
 */
public class Joueur extends Observable {
	
	private String nom;
	private List<String> motsValidseTrouves;
	private List<Character> lettreUtilisateur;
	
	public Joueur(String nom) {
		this.nom = nom;
		this.motsValidseTrouves = new ArrayList<>();
		this.lettreUtilisateur = new ArrayList<>();
	}
	
	public Character tirerLettre() {
		Character l = LetterGenerator.getInstance().generateLetter();
		this.lettreUtilisateur.add(l);
		System.out.println(this.nom + " a tiré la lettre " + l);
		return l;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void ajouterMotValide(String mot) {
		this.motsValidseTrouves.add(mot);
		setChanged();
		notifyObservers(mot);
	}
	
	public int getNombreDeMotValide() {
		return this.motsValidseTrouves.size();
	}
	
	public void ajouterLettreUtilisateur(Character lettre) {
		this.lettreUtilisateur.add(lettre);
	}
	
	public void retirerMotValide(String mot) {
		this.motsValidseTrouves.remove(mot);
	}

	public List<String> getMotsValidseTrouves() {
		return new ArrayList<String>(this.motsValidseTrouves);
	}

	public List<Character> getLettreUtilisateur() {
		return new ArrayList<Character>(this.lettreUtilisateur);
	}
	
	
}
