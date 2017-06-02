package io.projekat.zakazivanje;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import io.projekat.CitljivTerminIntervalInterfaceString;
//import io.javabrains.api.topic.Topic;
import io.projekat.predmet.Predmet;
import io.projekat.predmet.Profesor;
import io.projekat.predmet.Smer;
import io.projekat.sala.Sala;

@Entity
public class Termin implements CitljivTerminIntervalInterfaceString {
	
	
	@Id
	private String id;
	
	private Date datum;
	private String pocVreme;
	private String krajnjeVreme;
	
	private String aktivnost;
	
	@OneToMany
	private List<Smer> smerovi;
	private String info;
	private boolean visibility;
	
	@ManyToOne
	private Sala sala;
	
	@ManyToOne
	
	private Profesor profesor;
	
	@ManyToOne
	private Predmet predmet;
	
	public Termin(String id, Date datumF, String pocVreme, String krajnjeVreme, Predmet predmet, String aktivnost,
			List<Smer> smerovi, String info,Sala sala, boolean visibility, Profesor profesor) {
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
		this.sala = sala;
		
	}
	
	
public Termin(){
		
		
	}
	
	public Sala getSala() {
		return sala;
	}


	public void setSala(Sala sala) {
		this.sala = sala;
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


	@Override
	public String getPocetnoVreme() {
		return getPocVreme();
	}
	
	
	
	
}
