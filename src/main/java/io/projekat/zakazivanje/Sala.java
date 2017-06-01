package io.projekat.zakazivanje;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sala {
	
	
	@Id
	private String id;
	private String ime;
	private int brMesta;
	private String objekat;
	private boolean projektor;
	private boolean salaSaRacunarom;
	private int brRacunara;
	
	
	public Sala() {};
	
	public Sala(String id)
	{
		this.id = id;
		
		
	}
	
	
	public Sala(String id, String ime, int brMesta, String objekat, boolean projektor, boolean salaSaRacunarom,
			int brRacunara) {
		super();
		this.id = id;
		this.ime = ime;
		this.brMesta = brMesta;
		this.objekat = objekat;
		this.projektor = projektor;
		this.salaSaRacunarom = salaSaRacunarom;
		this.brRacunara = brRacunara;
	}

	
	
	
	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public String getIme() {
		return ime;
	}




	public void setIme(String ime) {
		this.ime = ime;
	}




	public int getBrMesta() {
		return brMesta;
	}




	public void setBrMesta(int brMesta) {
		this.brMesta = brMesta;
	}




	public String getObjekat() {
		return objekat;
	}




	public void setObjekat(String objekat) {
		this.objekat = objekat;
	}




	public boolean isProjektor() {
		return projektor;
	}




	public void setProjektor(boolean projektor) {
		this.projektor = projektor;
	}




	public boolean isSalaSaRacunarom() {
		return salaSaRacunarom;
	}




	public void setSalaSaRacunarom(boolean salaSaRacunarom) {
		this.salaSaRacunarom = salaSaRacunarom;
	}




	public int getBrRacunara() {
		return brRacunara;
	}




	public void setBrRacunara(int brRacunara) {
		this.brRacunara = brRacunara;
	}





	
	
	

}
