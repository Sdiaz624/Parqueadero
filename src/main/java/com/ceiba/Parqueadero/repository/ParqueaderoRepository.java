package com.ceiba.parqueadero.repository;
import java.time.LocalDateTime;

import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ceiba.parqueadero.domain.Parqueadero;
import com.ceiba.parqueadero.domain.Vehiculo;

@Repository
public interface ParqueaderoRepository extends CrudRepository<Parqueadero, Integer>{

	public Parqueadero findByVehiculo(int vehiculo);
	
}
