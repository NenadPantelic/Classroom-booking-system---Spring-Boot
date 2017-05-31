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
	
	@RequestMapping(method = RequestMethod.POST,value = "/predmeti/{predmetId}/termin")
	public int addTermin(@RequestBody Termin termin,@PathVariable String predmetId){
		
		termin.setPredmet(new Predmet(predmetId));
		return terminService.addTermin(termin);
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/predmeti/{predmetId}/termin/{id}")
	public void deleteTermin(@PathVariable String id)
	
	
	{
		
		terminService.deleteTermin(id);
	}

}

