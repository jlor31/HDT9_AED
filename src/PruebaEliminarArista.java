import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class PruebaEliminarArista {

	@Test
	void test() {
		Editor test_2 = new Editor();
		
		ArrayList<String> camino_chequeo = new ArrayList<>();
		
		camino_chequeo.add("ZACAPA");
		camino_chequeo.add("SANJUAN");
		camino_chequeo.add("47");
		
		Editor.listado.add(camino_chequeo);
		
		Editor.eliminar_arista();
		boolean verif = Editor.listado.contains(camino_chequeo);
		
		assertEquals(false, verif);
	}

}
