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
		
		if (validarVehiculo(vehiculoBase)) {
			
			vehiculoRespository.save(vehiculo);
			
		}else {
			return;
		}
		
	}

	public boolean validarVehiculo(Vehiculo vehiculoBase) {
		return vehiculoBase.equals(null);
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
