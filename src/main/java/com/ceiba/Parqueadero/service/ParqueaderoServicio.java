package com.ceiba.parqueadero.service;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.parqueadero.constantes.Constantes;
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
	
	private Constantes constante;
		
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
			}			
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
		
		if (tipo == constante.moto) {
			if(total >= constante.cantidadMaximaDeMotos) {
				return false;
			}
		}else {
			if(total >= constante.cantidadMaximaDeMotos) {
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
		
		if (!vehiculoEsNulo(vehiculo)) {
			
			Parqueadero parqueadero =  parqueaderoRepository.findByVehiculo(vehiculo.getId());
			
			if(!parqueaderoEsNulo(parqueadero)) {
				
				parqueadero.setFechaSalida(Calendar.getInstance());
				long horas = horasACobrar(parqueadero);
				if (vehiculo.getTipoVehiculo()==constante.moto){
					salidaDeMoto(vehiculo, parqueadero, horas);
				}
				if (vehiculo.getTipoVehiculo()==constante.carro) {
					salidaDeCarro(parqueadero, horas);
				}
				parqueaderoRepository.save(parqueadero);			
			}
		}
	}

	public long horasACobrar(Parqueadero parqueadero) {
		
		return  diferenciaDeFechasEnMilisegundos(parqueadero)/constante.milisegundosEnHoras;
	}
	
	public long diferenciaDeFechasEnMilisegundos(Parqueadero parqueadero) {
		return parqueadero.getFechaSalida().getTimeInMillis()-parqueadero.getFechaIngreso().getTimeInMillis();
	}
		
	public double salidaDeCarro(Parqueadero parqueadero, long horas) {
		parqueadero.setTotal(totalAPagar(horas,constante.valorHoraCarro,constante.valorDiaCarro));
		return parqueadero.getTotal();
	}

	public double salidaDeMoto(Vehiculo vehiculo, Parqueadero parqueadero, long horas) {
		parqueadero.setTotal(totalAPagar(horas,constante.valorHoraMoto,constante.valorDiaMoto));
		if (vehiculo.getCilindraje()>constante.altoCilindraje) {
			parqueadero.setTotal(parqueadero.getTotal()+constante.valorExcedenteAltoCilindraje);
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
						
		if (horas < constante.cantidadHorasDiaEnParqueadero ) {
			total = horas*valor;
		}else {
			if(horas>=constante.cantidadHorasDiaEnParqueadero && horas<constante.cantidadHorasDia) {
				total = valorDia;
			}
			if(horas>=constante.cantidadHorasDia) {
				total = totalAPagar(horas-constante.cantidadHorasDia, valor,valorDia) + valorDia;
			}
		}
		
		return total;
	}
	
	public boolean vehiculoEsNulo(Vehiculo vehiculoBase) {
		return vehiculoBase==null;
	}
	
}
