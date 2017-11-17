package com.ceiba.Parqueadero.repository;
import java.time.LocalDateTime;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.Parqueadero.domain.Parqueadero;

@Repository
public interface ParqueaderoRepository extends CrudRepository<Parqueadero, Integer>{

	public Parqueadero findByFechaSalida(LocalDateTime fechaSalida);
	
	
	
}
