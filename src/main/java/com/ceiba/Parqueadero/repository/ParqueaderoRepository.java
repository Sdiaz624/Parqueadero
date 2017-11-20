package com.ceiba.parqueadero.repository;
import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ceiba.parqueadero.domain.Parqueadero;

@Repository
public interface ParqueaderoRepository extends CrudRepository<Parqueadero, Integer>{

	/**
	 * 
	 * @param vehiculo
	 * @return
	 */
	
	Parqueadero findByVehiculo(int vehiculo);
	
	/**
	 * 
	 * @param tipo
	 * @return
	 */
	@Query(nativeQuery = true, value = 
		   "SELECT COUNT(*) "
		+  "FROM PARQUEADERO P ,"
		+  "	 VEHICULO V "
		+  "WHERE V.ID = P.VEHICULO_ID "
		+  "AND   P.FECHASALIDA IS NULL "
		+  "AND   V.TIPOVEHICULO = :TIPOVEHICULO ")
	int findByTipoVehiculoQuery(char tipo);	
}
