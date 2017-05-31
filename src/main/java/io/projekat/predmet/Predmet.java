package io.projekat.predmet;

import java.util.List;

public class Predmet {
	
	private int id;
	private String ime;
	private List<Smer> smerovi;
	private List<Profesor> profesori;
	
	public Predmet(int ID,String predmet,List<Smer> smerovi2,List<Profesor> profesori){
		
		this.ime = predmet;
		this.id = ID;
		this.smerovi = smerovi2;
		this.profesori = profesori;
	}
	
	public String getIme() {
		return ime;
	}

	public void setIme(String predmet) {
		this.ime = predmet;
	}

	public List<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(List<Profesor> profesori) {
		this.profesori = profesori;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Smer> getSmerovi() {
		return smerovi;
	}

	public void setSmerovi(List<Smer> smerovi) {
		this.smerovi = smerovi;
	}

	

}
