package escobar.andres.formacion.pojos;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Persona  implements Serializable {
	private static final long serialVersionUID = -6182334798148998019L;

	// CONSTANTES
	private static final int MAYORIA_DE_EDAD = 18;
	
	// VARIABLES DE INSTANCIA
	protected Long id;
	protected String nombre;
	protected LocalDate fechaNacimiento;
	
	//protected Rol rol;

	// CONSTRUCTORES
	public Persona(Long id, String nombre, LocalDate fechaNacimiento) {
		setId(id);
		setNombre(nombre);
		setFechaNacimiento(fechaNacimiento);
	}
	
	/*public Persona(Long id, String nombre, LocalDate fechaNacimiento) {
		this(id, nombre, fechaNacimiento, null);
	}*/
	
	public Persona(String nombre, LocalDate fechaNacimiento) {
		this(null, nombre, fechaNacimiento);
	}
	
	public Persona(String nombre) {
		this(null, nombre, null);
	}
	
	public Persona() {
		this(null, "ANONIMO", null);
	}
	
	// Constructor de copia
	public Persona(Persona persona) {
		this(persona.id, persona.nombre, persona.fechaNacimiento);
	}
	
	// GETTERS Y SETTERS
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre == null) {
			throw new PojosException("NO se admite null como nombre");
		}
		
		if(nombre.isBlank()) {
			throw new PojosException("NO se admites nombres vacíos");
		}
		
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		if(fechaNacimiento != null && fechaNacimiento.isAfter(LocalDate.now())) {
			throw new PojosException("No se admiten fechas de nacimiento posteriores a la actual");
		}
		
		this.fechaNacimiento = fechaNacimiento;
	}
	
	/*public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}*/

	public int getEdad() {
		return Period.between(fechaNacimiento, LocalDate.now()).getYears();
	}
	
	public boolean isMayorDeEdad() {
		return getEdad() >= MAYORIA_DE_EDAD;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaNacimiento, id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(fechaNacimiento, other.fechaNacimiento) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", rol="
				+ "]";
	}
}
