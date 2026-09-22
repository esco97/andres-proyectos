package escobar.andres.formacion.pojos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class TrabajadorIndefinido  extends Trabajador implements Serializable  {
	private static final long serialVersionUID = -4858563256073478377L;

	private BigDecimal sueldoAnual;
	private Integer numeroPagas;
	
	public TrabajadorIndefinido(String nombre, String apellidos, LocalDate fechaNacimiento, String dni, String nss,
			BigDecimal sueldoAnual, Integer numeroPagas) {
		super(nombre, apellidos, fechaNacimiento, dni, nss);
		this.sueldoAnual = sueldoAnual;
		this.numeroPagas = numeroPagas;
	}

	@Override
	public BigDecimal getSueldoMensual() {
		return sueldoAnual.divide(new BigDecimal(numeroPagas), 2, RoundingMode.HALF_UP);
	}
	
	
}
