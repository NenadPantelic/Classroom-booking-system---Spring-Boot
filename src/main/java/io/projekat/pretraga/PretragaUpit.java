package io.projekat.pretraga;
import java.util.Date;
import java.util.List;

import io.projekat.CitljivTerminIntervalInterfaceString;
import io.projekat.sala.Sala;

public class PretragaUpit implements CitljivTerminIntervalInterfaceString {
	private int response;
	
	private String datum;
	private Date datumF;
	private String pocetnoVreme;
	private Date pocetnoVremeF;
	private String vremeZavrsetka;
	private Date vremeZavrsetkaF;
	
	private List<String> objekat;
	private boolean sadrziProjektor;
	private boolean salaSaRacunarima;
	
	private int brojRacunara;
	private int brojMesta;
	
	private List<Sala> dostupneSale;

	public int getResponse() {
		return response;
	}

	public void setResponse(int response) {
		this.response = response;
	}

	public List<String> getObjekat() {
		return objekat;
	}

	public void setObjekat(List<String> objekat) {
		this.objekat = objekat;
	}

	public boolean isSadrziProjektor() {
		return sadrziProjektor;
	}

	public void setSadrziProjektor(boolean sadrziProjektor) {
		this.sadrziProjektor = sadrziProjektor;
	}

	public boolean isSalaSaRacunarima() {
		return salaSaRacunarima;
	}

	public void setSalaSaRacunarima(boolean salaSaRacunarima) {
		this.salaSaRacunarima = salaSaRacunarima;
	}

	public int getBrojRacunara() {
		return brojRacunara;
	}

	public void setBrojRacunara(int brojRacunara) {
		this.brojRacunara = brojRacunara;
	}

	public int getBrojMesta() {
		return brojMesta;
	}

	public void setBrojMesta(int brojMesta) {
		this.brojMesta = brojMesta;
	}

	public List<Sala> getDostupneSale() {
		return dostupneSale;
	}

	public void setDostupneSale(List<Sala> dostupneSale) {
		this.dostupneSale = dostupneSale;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public Date getDatumF() {
		return datumF;
	}

	public void setDatumF(Date datumF) {
		this.datumF = datumF;
	}

	public String getPocetnoVreme() {
		return pocetnoVreme;
	}

	public void setPocetnoVreme(String pocetnoVreme) {
		this.pocetnoVreme = pocetnoVreme;
	}

	public Date getPocetnoVremeF() {
		return pocetnoVremeF;
	}

	public void setPocetnoVremeF(Date pocetnoVremeF) {
		this.pocetnoVremeF = pocetnoVremeF;
	}

	public String getVremeZavrsetka() {
		return vremeZavrsetka;
	}

	public void setVremeZavrsetka(String vremeZavrsetka) {
		this.vremeZavrsetka = vremeZavrsetka;
	}

	public Date getVremeZavrsetkaF() {
		return vremeZavrsetkaF;
	}

	public void setVremeZavrsetkaF(Date vremeZavrsetkaF) {
		this.vremeZavrsetkaF = vremeZavrsetkaF;
	}

	@Override
	public String getKrajnjeVreme() {
		return getVremeZavrsetka();
	}
}
