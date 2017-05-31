package io.projekat.zakazivanje;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.projekat.predmet.Predmet;
import io.projekat.predmet.Profesor;
import io.projekat.predmet.Smer;

@Service
public class TerminService {
	
	@Autowired
	private TerminRepository terminRepo;
	
	
	public int addTermin(Termin termin){
		
		Date datum = termin.getDatum();
		Profesor prof = termin.getProfesor();
		Predmet predmet = termin.getPredmet();
		List<Smer> smeroviTermina = termin.getSmerovi();
		List<Smer> smeroviProfesora = prof.getSmerovi();
		List<Smer> smeroviPredmeta = predmet.getSmerovi();
		boolean odobrenje = false;
		
		List<Smer> zajednickiSmerovi = new ArrayList<>(smeroviProfesora);
		zajednickiSmerovi.retainAll(smeroviPredmeta);
		zajednickiSmerovi.retainAll(smeroviTermina);
		
		
		//druga provera, da li taj profesor uopste predaje taj predmet
		
		for(Profesor p:predmet.getProfesori())
		{
			
			if(p.getId() == prof.getId())
			{
				odobrenje = true;
				break;
				
			}
				
		}
		
		//druga provera, da li profesor predaje na tom smeru
		
		odobrenje = odobrenje && !(zajednickiSmerovi.isEmpty());
		// treca provera - da li je termin zauzet
		
		
		List <Termin> sviTermini = terminRepo.findByDatum(datum); 
		//String dan = termin.datumString();
//		
//		List<Termin> odgovarajuciTermin = new ArrayList<>();
//		
//		for (Termin t:sviTermini)
//		
//			if (t.datumString().equals(dan))
//				odgovarajuciTermin.add(t);
			
		
		String pocetnoT = termin.getPocVreme();
		String krajnjeT = termin.getKrajnjeVreme();
		
		int pocetnoSati = Integer.parseInt(pocetnoT.substring(0, 2));
		int pocetnoMinuti = Integer.parseInt(pocetnoT.substring(3, 5));
		
		int pocetnoVremeMinuti = pocetnoSati*60+pocetnoMinuti;
		
		int krajnjeSati = Integer.parseInt(krajnjeT.substring(0, 2));
		int krajnjeMinuti = Integer.parseInt(krajnjeT.substring(3, 5));
		
		int krajnjeVremeMinuti = krajnjeSati*60+krajnjeMinuti;
		
		int terminVremePoc;
		int terminVremeKraj;
		for (Termin terminDatum:sviTermini)
		{
			
			
			pocetnoT = terminDatum.getPocVreme();
			krajnjeT = terminDatum.getKrajnjeVreme();
			pocetnoSati = Integer.parseInt(pocetnoT.substring(0, 2));
			pocetnoMinuti = Integer.parseInt(pocetnoT.substring(3, 5));
			
			terminVremePoc = pocetnoSati*60+pocetnoMinuti;
			
			krajnjeSati = Integer.parseInt(krajnjeT.substring(0, 2));
			krajnjeMinuti = Integer.parseInt(krajnjeT.substring(3, 5));
			
			
			terminVremeKraj = krajnjeSati*60+krajnjeMinuti;
			
			
			
			if ((terminVremePoc<=pocetnoVremeMinuti && pocetnoVremeMinuti<=terminVremeKraj) || (terminVremePoc<=krajnjeVremeMinuti && krajnjeVremeMinuti<=terminVremeKraj))
					{
				        odobrenje = false;
				        break;
				   
					}
		}
		
		
		int odgovor = (odobrenje == true)?1:0;
		
		if (odgovor == 1)
		{
			terminRepo.save(termin);
			return odgovor;
			
			
		}
		
		else 
			return 0;
		
		
	}

	
	public void deleteTermin(String id){
		
		
		terminRepo.delete(id);
		
	}
}
