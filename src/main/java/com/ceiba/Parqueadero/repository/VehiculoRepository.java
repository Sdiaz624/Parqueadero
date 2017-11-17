package com.ceiba.Parqueadero.repository;
import org.springframework.data.repository.CrudRepository;

import com.ceiba.Parqueadero.domain.Vehiculo;

public interface VehiculoRepository extends CrudRepository<Vehiculo, Integer>{

	public Vehiculo findByPlaca(String placa);
	
}
