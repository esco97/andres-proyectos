package escobar.andres.formacion.bibliotecas;

// Create
// Read
// Update
// Delete

public interface Dao <T>{
	Iterable<T> obtenerTodos();
	T obtenerPorId(Long id);
	
	void insertar(T objeto);
	void modificar(T objeto);
	void borrar(Long id);
}
