package io.projekat;

import io.projekat.zakazivanje.Termin;

public class CitljivoVremeInterval {
	private CitljivoVreme pocetnoVreme;
	private CitljivoVreme krajnjeVreme;
	
	public CitljivoVremeInterval()
	{
		this(new CitljivoVreme(), new CitljivoVreme());
	}
	
	public CitljivoVremeInterval(CitljivoVreme pocetnoVreme, CitljivoVreme krajnjeVreme)
	{
		if(pocetnoVreme.isGreaterThan(krajnjeVreme))
			throw new IllegalArgumentException("Pocetno vreme ne sme biti vece od vremena zavrsetka.");
		this.pocetnoVreme = pocetnoVreme;
		this.krajnjeVreme = krajnjeVreme;
	}
	
	public CitljivoVremeInterval(String pocetnoVreme, String krajnjeVreme)
	{
		this(new CitljivoVreme(pocetnoVreme), new CitljivoVreme(krajnjeVreme));
	}
	
	public CitljivoVremeInterval(CitljivTerminIntervalInterfaceString termin)
	{
		this( new CitljivoVreme(termin.getPocetnoVreme()), new CitljivoVreme(termin.getKrajnjeVreme()) );
	}
	
	public CitljivoVreme getPocetnoVreme() {
		return pocetnoVreme;
	}

	public void setPocetnoVreme(CitljivoVreme pocetnoVreme) {
		this.pocetnoVreme = pocetnoVreme;
	}

	public CitljivoVreme getKrajnjeVreme() {
		return krajnjeVreme;
	}

	public void setKrajnjeVreme(CitljivoVreme krajnjeVreme) {
		this.krajnjeVreme = krajnjeVreme;
	}

	public boolean nemaPreseka(CitljivoVremeInterval interval)
	{
		return pocetnoVreme.isGreaterThan(interval.getKrajnjeVreme()) ||
				krajnjeVreme.isLessThan(interval.getPocetnoVreme());
	}
	
	public String toString()
	{
		return "(" + pocetnoVreme + " - " + krajnjeVreme + ")";
	}
}
