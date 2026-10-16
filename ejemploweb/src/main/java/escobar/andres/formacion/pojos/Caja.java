package escobar.andres.formacion.pojos;

import java.util.Objects;

public class Caja <T>{
	private T contenido;

	public Caja(T contenido) {
		super();
		this.contenido = contenido;
	}

	public Caja() {
	}

	public T getContenido() {
		return contenido;
	}

	public void setContenido(T contenido) {
		this.contenido = contenido;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(contenido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("rawtypes")
		Caja other = (Caja) obj;
		return Objects.equals(contenido, other.contenido);
	}

	@Override
	public String toString() {
		return String.format("Caja [contenido=%s]", contenido);
	}
}
