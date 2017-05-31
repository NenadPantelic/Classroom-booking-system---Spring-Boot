package io.projekat.predmet;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
@Entity
public class Predmet {
	@Id
	private String id;
	private String ime;
	
	@OneToMany
	private List<Smer> smerovi;
	@OneToMany
	
	//@Column
    //@ElementCollection(targetClass=Profesor.class)
    //private List<Integer> countries;
	private List<Profesor> profesori;
	
	public Predmet(String ID,String predmet,List<Smer> smerovi2,List<Profesor> profesori){
		
		this.ime = predmet;
		this.id = ID;
		this.smerovi = smerovi2;
		this.profesori = profesori;
	}
	
	public Predmet()
	{
		
		
		
	}
	public Predmet(String  id)
	{
		this.id = id;
		
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Smer> getSmerovi() {
		return smerovi;
	}

	public void setSmerovi(List<Smer> smerovi) {
		this.smerovi = smerovi;
	}

	

}
