package escobar.andres.formacion.tienda.mocks;

import java.math.BigDecimal;
import java.util.Map;

import escobar.andres.formacion.tienda.modelos.Producto;

public class TiendaMock {
	public static final Map<Long, Producto> PRODUCTOS = Map.of(1L,
			new Producto(1L, "Portátil", new BigDecimal("1234.56")), 2L,
			new Producto(2L, "Ratón", new BigDecimal("34.56")), 3L,
			new Producto(3L, "Monitor", new BigDecimal("234.56"))
			);
}
