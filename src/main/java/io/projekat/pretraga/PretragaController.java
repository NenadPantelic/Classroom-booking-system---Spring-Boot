package io.projekat.pretraga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.projekat.zakazivanje.TerminService;

@RestController
public class PretragaController {
	
	@Autowired
	private TerminService terminService;
	
	@RequestMapping(method = RequestMethod.POST,value = "/pretraga")
	public PretragaUpit pretraziSale(@RequestBody PretragaUpit upit)
	{ 
		return upit;
	}
}
