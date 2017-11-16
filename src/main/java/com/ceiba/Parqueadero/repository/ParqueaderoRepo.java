package com.ceiba.Parqueadero.repository;
import java.time.LocalDateTime;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.Parqueadero.domain.Parqueadero;

@Repository
public interface ParqueaderoRepo extends CrudRepository<Parqueadero, Integer>{

	public Parqueadero findByfechaSalida(LocalDateTime fechaSalida);
	
	
	
}
