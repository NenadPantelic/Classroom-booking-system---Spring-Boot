package io.projekat.zakazivanje;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import io.projekat.predmet.Predmet;

@RestController
public class TerminController {
	
	
	@Autowired
	
	private TerminService terminService;
	
	@RequestMapping(method = RequestMethod.POST,value = "/sale/{salaId}/termini")
	public int addTermin(@RequestBody Termin termin,@PathVariable String salaId){
		
		termin.setSala(new Sala(salaId));
		return terminService.addTermin(termin);
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/sale/{salaId}/termini/{id}")
	public void deleteTermin(@PathVariable String id)
	
	
	{
		
		terminService.deleteTermin(id);
	}

	@RequestMapping(method = RequestMethod.PUT,value = "/sale/{salaId}/termini/{id}")
	public void updateTermin(@RequestBody Termin termin,@PathVariable String id,@PathVariable String salaId)
	{
		termin.setSala(new Sala(salaId));
		terminService.updateTermin(termin);
		
		
	}

}

