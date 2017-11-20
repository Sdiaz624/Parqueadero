package com.ceiba.parqueadero.service;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceiba.parqueadero.domain.Parqueadero;
import com.ceiba.parqueadero.domain.Vehiculo;
import com.ceiba.parqueadero.repository.ParqueaderoRepository;
import com.ceiba.parqueadero.repository.VehiculoRepository;

@Service
public class ParqueaderoServicio {

	
	
	@Autowired
	private ParqueaderoRepository parqueaderoRepository;
	@Autowired
	private VehiculoRepository vehiculoRepository;
		
	/**
	 * 
	 * @param placa
	 */
	public void ingresoVehiculo(String placa) {
		
		Vehiculo vehiculo = vehiculoRepository.findByPlaca(placa);
		
		if(validarVehiculoYParqueadero(vehiculo)){
						
			Parqueadero parqueadero =  parqueaderoRepository.findByVehiculo(vehiculo.getId());
			
			if(parqueaderoEsNulo(parqueadero)) {
				guardarVehiculo(vehiculo);
			} else {
				return;
			}				
			
		}else {
			return;
		}
		
	}

	public void guardarVehiculo(Vehiculo vehiculo) {
		parqueaderoRepository.save(new Parqueadero(Calendar.getInstance(),vehiculo));
	}

	public boolean parqueaderoEsNulo(Parqueadero parqueadero) {
		return parqueadero == null;
	}

	private boolean validarVehiculoYParqueadero(Vehiculo vehiculo) {
		return vehiculo!=null && espacioEnElParqueadero(vehiculo.getTipoVehiculo());
	}
	
	/**
	 * 
	 * @param tipo
	 * @return
	 */
	public boolean espacioEnElParqueadero(char tipo) {
		
		int total = parqueaderoRepository.findByTipoVehiculoQuery(tipo);
		
		if (tipo == 'M') {
			if(total >= 10) {
				return false;
			}
		}else {
			if(total >= 20) {
				return false;
			}
		}
		
		return true;
		
	}
	
	/**
	 * 
	 * @param placa
	 */
	public void salidaVehiculo(String placa) {
		
		Vehiculo vehiculo = vehiculoRepository.findByPlaca(placa);
		
		if (!vehiculo.equals(null)) {
			
			Parqueadero parqueadero =  parqueaderoRepository.findByVehiculo(vehiculo.getId());
			
			if(!parqueaderoEsNulo(parqueadero)) {
				
				parqueadero.setFechaSalida(Calendar.getInstance());
				long horas = horasACobrar(parqueadero);
				if (vehiculo.getTipoVehiculo()=='M'){
					salidaDeMoto(vehiculo, parqueadero, horas);
				}
				if (vehiculo.getTipoVehiculo()=='C') {
					salidaDeCarro(parqueadero, horas);
				}
				parqueaderoRepository.save(parqueadero);
							
			}else {
				return;
			}
		}else {
			return;
		}
	}

	public long horasACobrar(Parqueadero parqueadero) {
		
		return  diferenciaDeFechasEnMilisegundos(parqueadero)/3600000;
	}
	
	public long diferenciaDeFechasEnMilisegundos(Parqueadero parqueadero) {
		return parqueadero.getFechaSalida().getTimeInMillis()-parqueadero.getFechaIngreso().getTimeInMillis();
	}
		
	public double salidaDeCarro(Parqueadero parqueadero, long horas) {
		parqueadero.setTotal(totalAPagar(horas,1000.00,8000.00));
		return parqueadero.getTotal();
	}

	public double salidaDeMoto(Vehiculo vehiculo, Parqueadero parqueadero, long horas) {
		parqueadero.setTotal(totalAPagar(horas,500.00,6000.00));
		if (vehiculo.getCilindraje()>500) {
			parqueadero.setTotal(parqueadero.getTotal()+5000);
		}
		return parqueadero.getTotal();
	}
	
	/**
	 * 
	 * @param horas
	 * @param valor
	 * @param Valordia
	 * @return
	 */
	public double totalAPagar(long horas, Double valor,Double valorDia) {
		
		double total = 0;
						
		if (horas < 9 ) {
			total = horas*valor;
		}else {
			if(horas>=9 && horas<24) {
				total = valorDia;
			}
			if(horas>=24) {
				total = totalAPagar(horas-24, valor,valorDia) + valorDia;
			}
		}
		
		return total;
	}
	
}
