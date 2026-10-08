package escobar.andres.formacion.bibliotecas;

// Create
// Read
// Update
// Delete

public interface Dao <T>{
	default Iterable<T> obtenerTodos() {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	default T obtenerPorId(Long id) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	default void insertar(T objeto) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	default void modificar(T objeto) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	default void borrar(Long id){
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
}
