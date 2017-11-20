package com.ceiba.parqueadero.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ceiba.parqueadero.domain.Vehiculo;

@Repository
public interface VehiculoRepository extends CrudRepository<Vehiculo, Integer>{

	
	Vehiculo findByPlaca(String placa);
	
	
	int findByTipoVehiculo(String tipo);
	
}
