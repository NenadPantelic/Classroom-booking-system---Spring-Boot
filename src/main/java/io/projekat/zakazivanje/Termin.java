package io.projekat.zakazivanje;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.projekat.predmet.Predmet;
import io.projekat.predmet.Profesor;
import io.projekat.predmet.Smer;

@Entity
public class Termin {
	
	
	@Id
	private String id;
	
	private Date datum;
	private String pocVreme;
	private String krajnjeVreme;
	private Predmet predmet;
	private String aktivnost;
	private List<Smer> smerovi;
	private String info;
	private boolean visibility;
	private Profesor profesor;
	
	
	
	public Termin(String id, Date datumF, String pocVreme, String krajnjeVreme, Predmet predmet, String aktivnost,
			List<Smer> smerovi, String info, boolean visibility, Profesor profesor) {
		super();
		this.id = id;
		this.datum = datumF;
		this.pocVreme = pocVreme;
		this.krajnjeVreme = krajnjeVreme;
		this.predmet = predmet;
		this.aktivnost = aktivnost;
		this.smerovi = smerovi;
		this.info = info;
		this.visibility = visibility;
		this.profesor = profesor;
		
	}
	
	
	
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public boolean isVisibility() {
		return visibility;
	}
	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datumF) {
		this.datum = datumF;
	}
	public String getPocVreme() {
		return pocVreme;
	}
	public void setPocVreme(String pocVreme) {
		this.pocVreme = pocVreme;
	}
	public String getKrajnjeVreme() {
		return krajnjeVreme;
	}
	public void setKrajnjeVreme(String krajnjeVreme) {
		this.krajnjeVreme = krajnjeVreme;
	}
	public Predmet getPredmet() {
		return predmet;
	}
	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}
	public String getAktivnost() {
		return aktivnost;
	}
	public void setAktivnost(String aktivnost) {
		this.aktivnost = aktivnost;
	}
	public List<Smer> getSmerovi() {
		return smerovi;
	}
	public void setSmerovi(List<Smer> smerovi) {
		this.smerovi = smerovi;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	
	
	
}
