package io.projekat;

// Format: "HH:MM"
public class CitljivoVreme {
	private int sati;
	private int minuti;
	
	public CitljivoVreme()
	{
		this.sati = 0;
		this.minuti = 0;
	}
	
	public CitljivoVreme(String vreme)
	{
		sati = Integer.parseInt(vreme.substring(0, 2));
		minuti = Integer.parseInt(vreme.substring(3, 5));
	}

	public int getSati() {
		return sati;
	}

	public void setSati(int sati) {
		this.sati = sati;
	}

	public int getMinuti() {
		return minuti;
	}

	public void setMinuti(int minuti) {
		this.minuti = minuti;
	}
	
	public int konverzijaUMinute()
	{
		return 60 * sati + minuti;
	}
	
	public int compareTo(CitljivoVreme vreme)
	{
		return this.konverzijaUMinute() - vreme.konverzijaUMinute();
	}
	
	public boolean isGreaterThan(CitljivoVreme vreme)
	{
		return compareTo(vreme) > 0;
	}
	
	public boolean isGreaterThanOrEqualTo(CitljivoVreme vreme)
	{
		return compareTo(vreme) >= 0;
	}
	
	public boolean isLessThan(CitljivoVreme vreme)
	{
		return compareTo(vreme) < 0;
	}
	
	public boolean isLessThanOrEqualTo(CitljivoVreme vreme)
	{
		return compareTo(vreme) <= 0;
	}
	
	public boolean isEqualTo(CitljivoVreme vreme)
	{
		return compareTo(vreme) == 0;
	}
	
	public boolean isDifferentThan(CitljivoVreme vreme)
	{
		return compareTo(vreme) != 0;
	}
	
	public String toString()
	{
		return Integer.toString(sati) + ":" + Integer.toString(minuti);
	}
	
}
