package io.projekat.pretraga;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.projekat.CitljivoVremeInterval;
import io.projekat.sala.Sala;
import io.projekat.sala.SalaService;
import io.projekat.zakazivanje.Termin;
import io.projekat.zakazivanje.TerminService;

@RestController
public class PretragaController {
	
	@Autowired
	private TerminService terminService;
	@Autowired
	private SalaService salaService;
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST,value = "/pretraga")
	public PretragaUpit pretraziSale(@RequestBody PretragaUpit upit)
	{ 
		List<Termin> zauzetiTermini = terminService.getTerminiByDatum(upit.getDatumF());
		CitljivoVremeInterval upitInterval = new CitljivoVremeInterval(upit);
		
		Set<Sala> zauzeteSale = new HashSet<Sala>();
		for (Termin termin : zauzetiTermini)
		{
			CitljivoVremeInterval terminInterval = new CitljivoVremeInterval(termin);
			if(!upitInterval.nemaPreseka(terminInterval))
			{
				zauzeteSale.add(termin.getSala());
			}
		}
		
		List<Sala> dostupneSale = new ArrayList<Sala>();
		for(Sala mogucaSala : salaService.getSale())
		{
			if(!zauzeteSale.contains(mogucaSala))
			{
				dostupneSale.add(mogucaSala);
			}
		}
		
		upit.setDostupneSale(dostupneSale);
		return upit;
	}
}
