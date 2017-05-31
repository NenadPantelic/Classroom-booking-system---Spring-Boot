package io.projekat.predmet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PredmetService {
	
	private List<Smer> smerovi = new ArrayList<>(Arrays.asList(new Smer("1","Racunarska tehnika i softverkos inzenjerstvo")));
	//private List<Smer>
	private List<Profesor> profesori = new ArrayList<>(Arrays.asList(new Profesor(1,"Aleksandar Peulic","profesor",smerovi),new Profesor(2,"Vladimir Milovanovic","profesor",smerovi)));
	private List<Profesor> prof = new ArrayList<>(Arrays.asList(new Profesor(1,"Aleksandar Peulic","profesor",smerovi)));
	
	private List<Predmet> predmeti = new ArrayList<>(Arrays.asList(new Predmet("1","Osnovi računarske tehnike",smerovi,profesori)
			,new Predmet("2","Osnovi računarske tehnike 2",smerovi,profesori),
			new Predmet("3","Arhitektura računarskih sistema",smerovi,profesori),
			new Predmet("4","Objektno-orijentisano programiranje",smerovi,profesori)));
	
	
	//Predmet p = new Predmet(2,"Osnovi računarske tehnike 2",smerovi);
	public List<Predmet> getPredmeti(){
		
		return predmeti;
		
		
	}
	
	
	
	
	
}

