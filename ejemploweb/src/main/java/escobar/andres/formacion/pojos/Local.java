package escobar.andres.formacion.pojos;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Local {
	private String nombre;
	
	private Persona responsable;
	
	private Set<Persona> visitantes = new HashSet<>();

	public Local(String nombre, Persona responsable) {
		setNombre(nombre);
		setResponsable(responsable);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Persona getResponsable() {
		return responsable;
	}

	public void setResponsable(Persona responsable) {
		this.responsable = validarPersona(responsable);
	}

	public Set<Persona> getVisitantes() {
		return visitantes;
	}
	
	public boolean compararVisitantes(Local otro) {
		return Local.compararVisitantes(this, otro);
	}
	
	public static boolean compararVisitantes(Local local1, Local local2) {
		return local1.getVisitantes().equals(local2.getVisitantes());
	}

	public void entrar(Persona visitante) {
		visitantes.add(validarPersona(visitante));
	}

	private Persona validarPersona(Persona persona) {
		if(persona == null) {
			throw new PojosException("NO se admiten valores nulos");
		}
		
		if(persona.getFechaNacimiento() == null || !persona.isMayorDeEdad()) {
			throw new PojosException("NO se admiten menores de edad o personas que no tengan una fecha de nacimiento");
		}
		
		return persona;
	}
	
	public void salir(Persona visitante) {
		visitantes.remove(visitante);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nombre, responsable);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Local other = (Local) obj;
		return Objects.equals(nombre, other.nombre) && Objects.equals(responsable, other.responsable);
	}

	@Override
	public String toString() {
		return "Local [nombre=" + nombre + ", responsable=" + responsable + "]";
	}
	
	
}
