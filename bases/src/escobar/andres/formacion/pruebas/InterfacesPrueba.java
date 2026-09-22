package escobar.andres.formacion.pruebas;

import java.util.ArrayList;

public class InterfacesPrueba {
	public static void main(String[] args) {
		var saco = new ArrayList<Rodable>();

		saco.add(new Naranja());
		saco.add(new Balon());

		for (var rodable : saco) {
			if (rodable instanceof Comestible comestible) {
				comestible.comer();
			}

			rodable.rodar();
		}
	}
}

class Fruto {
}

class ObjetoDeporte {
}

interface Comestible {
	void comer();
}

interface Rodable {
	void rodar();
}

class Balon extends ObjetoDeporte implements Rodable {
	@Override
	public void rodar() {
		System.out.println("Balón rodando");
	}
}

class Naranja extends Fruto implements Comestible, Rodable {
	private boolean porElSuelo = false;

	@Override
	public void comer() {
		if (porElSuelo) {
			System.out.println("Puaj que asco");
		} else {
			System.out.println("Ñam que rica");
		}
	}

	@Override
	public void rodar() {
		System.out.println("Naranja rodando");
		porElSuelo = true;
	}
}
