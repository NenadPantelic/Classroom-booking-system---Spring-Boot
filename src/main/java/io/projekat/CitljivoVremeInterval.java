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
			throw new IllegalArgumentException("Pocetno vreme ne sme biti vece od vremena zavrsetka. Dobijen interval: " + uString(pocetnoVreme, krajnjeVreme));
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
		return uString(this);
	}
	
	public static String uString(CitljivoVreme pocetnoVreme, CitljivoVreme krajnjeVreme)
	{
		return "(" + pocetnoVreme + " - " + krajnjeVreme + ")";
	}
	
	public static String uString(CitljivoVremeInterval interval)
	{
		return uString(interval.pocetnoVreme, interval.krajnjeVreme);
	}
	
	public static String uString(String pocetnoVreme, String krajnjeVreme)
	{
		return uString(new CitljivoVreme(pocetnoVreme), new CitljivoVreme(krajnjeVreme));
	}
}
