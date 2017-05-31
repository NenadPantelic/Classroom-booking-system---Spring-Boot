package io.projekat.zakazivanje;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TerminRepository extends CrudRepository<Termin,String> {
	
	public List<Termin>findByDatum(Date datumF);
	

}
