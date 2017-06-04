package io.projekat.predmet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PredmetController {
	
	
	@Autowired
	private PredmetService predmetService;
	
	@CrossOrigin
	@RequestMapping("/predmeti")
	public List<Predmet> getPredmeti(){
		
		return predmetService.getPredmeti();
		
		
		
		
	}
	
	

	
	

}
