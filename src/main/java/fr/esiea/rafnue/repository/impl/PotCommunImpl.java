package fr.esiea.rafnue.repository.impl;


import java.util.List;

import fr.esiea.rafnue.repository.PotCommunRepo;

public class PotCommunImpl implements PotCommunRepo{
	
	private List <Character> Pot;
	
	public PotCommunImpl(){
		super();
		
		
	}

	public void AjoutLettres(char a ) {
		
			this.Pot.add(a);
		
	}
	
	public void ContientLettres(char b){
		
		System.out.println(Pot.contains(b));
	}



}
