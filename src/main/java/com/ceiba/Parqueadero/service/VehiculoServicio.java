package com.ceiba.parqueadero.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceiba.parqueadero.domain.Vehiculo;
import com.ceiba.parqueadero.repository.VehiculoRepository;

@Service
public class VehiculoServicio {
	
	@Autowired
	private VehiculoRepository vehiculoRespository;
	
	/**
	 * 
	 * @param vehiculo
	 */
	public void registrar(Vehiculo vehiculo) {
	
		Vehiculo vehiculoBase =vehiculoRespository.findByPlaca(vehiculo.getPlaca());
		
		if (vehiculoBase.equals(null)) {
			
			vehiculoRespository.save(vehiculo);
			
		}else {
			return;
		}
		
	}
	
	/**
	 * 
	 * @param placa
	 * @return
	 */
	public Vehiculo consultar(String placa) {
		
		return vehiculoRespository.findByPlaca(placa);
				
	}
	
}
