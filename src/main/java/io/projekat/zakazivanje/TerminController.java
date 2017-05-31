package io.projekat.zakazivanje;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TerminController {
	
	
	@Autowired
	
	private TerminService terminService;
	
	@RequestMapping(method = RequestMethod.POST,value = "/zakazivanje")
	public int addTermin(@RequestBody Termin termin){
		
		
		return terminService.addTermin(termin);
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/zakazivanje/{id}")
	public void deleteTermin(@PathVariable String id)
	
	
	{
		
		terminService.deleteTermin(id);
	}

}

