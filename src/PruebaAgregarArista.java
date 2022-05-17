import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

 class PruebaAgregarArista {

	@Test
	 void test() {
		Editor test_1 = new Editor();
		ArrayList<String> camino_chequeo = new ArrayList<>();
		camino_chequeo.add("ZACAPA");
		camino_chequeo.add("SANJUAN");
		camino_chequeo.add("47");
		
		Editor.agregar_arista();
		boolean verif = Editor.listado.contains(camino_chequeo);
		assertEquals(true, verif);
	}

}
