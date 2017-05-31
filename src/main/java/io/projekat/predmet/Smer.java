package io.projekat.predmet;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Smer {
	
	private String ime;
	@Id
	private String id;
	//private List<Profesor> profesori;
	
	public Smer(String id,String ime)
	{
		this.ime = ime;
		this.id = id;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Smer()
	{
		
		
		
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}
	
	
	

}
