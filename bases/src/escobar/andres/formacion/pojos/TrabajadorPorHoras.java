package escobar.andres.formacion.pojos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class TrabajadorPorHoras extends Trabajador implements Serializable  {
	private static final long serialVersionUID = -438690435832250324L;

	private BigDecimal precioHora;
	private Integer numeroHorasMensuales;
	
	public TrabajadorPorHoras(String nombre, String apellidos, LocalDate fechaNacimiento, String dni, String nss,
			BigDecimal precioHora, Integer numeroHorasMensuales) {
		super(nombre, apellidos, fechaNacimiento, dni, nss);
		this.precioHora = precioHora;
		this.numeroHorasMensuales = numeroHorasMensuales;
	}

	@Override
	public BigDecimal getSueldoMensual() {
		return precioHora.multiply(new BigDecimal(numeroHorasMensuales));
	}
	
	
}
