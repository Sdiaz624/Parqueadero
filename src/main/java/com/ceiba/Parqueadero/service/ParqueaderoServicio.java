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
		
		if (tipo == constante.MOTO) {
			if(total >= constante.CANTIDAD_MAXIMA_DE_CARROS) {
				return false;
			}
		}else {
			if(total >= constante.CANTIDAD_MAXIMO_DE_MOTOS) {
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
				if (vehiculo.getTipoVehiculo()==constante.MOTO){
					salidaDeMoto(vehiculo, parqueadero, horas);
				}
				if (vehiculo.getTipoVehiculo()==constante.CARRO) {
					salidaDeCarro(parqueadero, horas);
				}
				parqueaderoRepository.save(parqueadero);			
			}
		}
	}

	public long horasACobrar(Parqueadero parqueadero) {
		
		return  diferenciaDeFechasEnMilisegundos(parqueadero)/constante.MILISEGUNDOS_EN_HORAS;
	}
	
	public long diferenciaDeFechasEnMilisegundos(Parqueadero parqueadero) {
		return parqueadero.getFechaSalida().getTimeInMillis()-parqueadero.getFechaIngreso().getTimeInMillis();
	}
		
	public double salidaDeCarro(Parqueadero parqueadero, long horas) {
		parqueadero.setTotal(totalAPagar(horas,constante.VALOR_HORA_CARRO,constante.VALOR_DIA_CARRO));
		return parqueadero.getTotal();
	}

	public double salidaDeMoto(Vehiculo vehiculo, Parqueadero parqueadero, long horas) {
		parqueadero.setTotal(totalAPagar(horas,constante.VALOR_HORA_MOTO,constante.VALOR_DIA_MOTO));
		if (vehiculo.getCilindraje()>constante.ALTO_CILINDRAJE) {
			parqueadero.setTotal(parqueadero.getTotal()+constante.VALOR_EXCEDENTE_ALTO_CILINDRAJE);
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
						
		if (horas < constante.CANTIDAD_HORAS_DIA_EN_EL_PARQUEADERO ) {
			total = horas*valor;
		}else {
			if(horas>=constante.CANTIDAD_HORAS_DIA_EN_EL_PARQUEADERO && horas<constante.CANTIDAD_HORAS_DIA) {
				total = valorDia;
			}
			if(horas>=constante.CANTIDAD_HORAS_DIA) {
				total = totalAPagar(horas-constante.CANTIDAD_HORAS_DIA, valor,valorDia) + valorDia;
			}
		}
		
		return total;
	}
	
	public boolean vehiculoEsNulo(Vehiculo vehiculoBase) {
		return vehiculoBase==null;
	}
	
}
