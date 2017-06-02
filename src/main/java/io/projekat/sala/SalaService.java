package io.projekat.sala;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import io.projekat.Objekti;

@Service
public class SalaService {
	private List<Sala> sveSale;
	
	public SalaService()
	{
		sveSale = new ArrayList<Sala>();
		sveSale.add(new Sala("a-amfiteatar", "Amfiteatar", 90, Objekti.objekatD, true, true, 1));
		sveSale.add(new Sala("a-119", "RTSI 1", 40, Objekti.objekatD, true, true, 1));
		sveSale.add(new Sala("a-216", "RTSI 2", 40, Objekti.objekatD, true, true, 1));
		sveSale.add(new Sala("d-62", "Laboratorija za Elektrotehniku", 20, Objekti.objekatD, true, true, 20));
		sveSale.add(new Sala("a-2-21", "TEMPUS veca", 40, Objekti.objekatA, true, true, 40));
		sveSale.add(new Sala("a-1-19", "TEMPUS manja", 30, Objekti.objekatA, true, true, 30));
	}
	
	public List<Sala> getSale()
	{
		return sveSale;
	}
	
	public List<Sala> getSaleKopija()
	{
		return new ArrayList<Sala>(sveSale);
	}

}
