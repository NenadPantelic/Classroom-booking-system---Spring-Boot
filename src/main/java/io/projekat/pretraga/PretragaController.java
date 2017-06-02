package io.projekat.pretraga;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PretragaController {
	
	@RequestMapping(method = RequestMethod.POST,value = "/pretraga")
	public Object pretraziSale(@RequestBody PretragaUpit upit)
	{ 
		throw new UnsupportedOperationException("Coming soon");
	}
}
