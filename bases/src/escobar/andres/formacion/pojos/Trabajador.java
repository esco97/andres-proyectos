package escobar.andres.formacion.pojos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Trabajador extends Persona implements Serializable {
	private static final long serialVersionUID = -4703258332381597124L;

	private String apellidos;
	private String nss;
	private String dni;

	public Trabajador(String nombre, String apellidos, LocalDate fechaNacimiento, String dni, String nss) {
		super(nombre, fechaNacimiento);

		this.apellidos = apellidos;
		this.nss = nss;
		this.dni = dni;
	}

	@Override
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		super.setFechaNacimiento(fechaNacimiento);
		
		if(fechaNacimiento == null) {
			throw new PojosException("Son obligatorias las fechas de nacimiento para los trabajadores");
		}
		
		if(!isMayorDeEdad()) {
			throw new PojosException("Debes ser mayor de edad para poder trabajar");
		}
		
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNss() {
		return nss;
	}

	public void setNss(String nss) {
		this.nss = nss;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public abstract BigDecimal getSueldoMensual();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(apellidos, dni, nss);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trabajador other = (Trabajador) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(dni, other.dni)
				&& Objects.equals(nss, other.nss);
	}

	@Override
	public String toString() {
		return String.format("Trabajador [nombre=%s, apellidos=%s, fechaNacimiento=%s, dni=%s, nss=%s]", nombre,
				apellidos, fechaNacimiento, dni, nss);
	}

}
