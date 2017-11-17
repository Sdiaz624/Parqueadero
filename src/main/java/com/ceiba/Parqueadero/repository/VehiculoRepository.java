package com.ceiba.parqueadero.repository;
import org.springframework.data.repository.CrudRepository;
import com.ceiba.parqueadero.domain.Vehiculo;

public interface VehiculoRepository extends CrudRepository<Vehiculo, Integer>{

	public Vehiculo findByPlaca(String placa);
		
	public int findByTipo(String tipo);
	
}
