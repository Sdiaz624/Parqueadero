package com.ceiba.parqueadero.repository;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.ceiba.parqueadero.domain.Parqueadero;
import com.ceiba.parqueadero.domain.Vehiculo;

@Repository
public interface ParqueaderoRepository extends CrudRepository<Parqueadero, Integer>{

	/**
	 * 
	 * @param vehiculo
	 * @return
	 */
	
	@Query(nativeQuery = true, value = 
			   "SELECT * "
			+  "FROM PARQUEADERO P "
			+  "WHERE P.FECHASALIDA IS NULL "
			+  "AND   P.VEHICULO_ID = :VEHICULO_ID ")
	Parqueadero findByVehiculoQuery(@Param(value = "VEHICULO_ID") int vehiculo);
	
	/**
	 * 
	 * @param tipo
	 * @return
	 */
	@Query(nativeQuery = true, value = 
		   "SELECT COUNT(*) "
		+  "FROM PARQUEADERO P ,"
		+  "	 VEHICULO V "
		+  "WHERE V.VEHICULO_ID = P.VEHICULO_ID "
		+  "AND   P.FECHASALIDA IS NULL "
		+  "AND   V.TIPOVEHICULO = :TIPOVEHICULO ")
	int findByTipoVehiculoQuery(@Param(value = "TIPOVEHICULO") char tipo);
	
	ArrayList<Parqueadero> findByVehiculo(Vehiculo vehiculo);
}
