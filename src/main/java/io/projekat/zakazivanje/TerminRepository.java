package io.projekat.zakazivanje;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.projekat.sala.Sala;

public interface TerminRepository extends CrudRepository<Termin,String> {
	
	public List<Termin>findByDatum(Date datumF);
	public List<Termin>findBySala(Sala sala);
	

}
