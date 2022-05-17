import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PruebaFloyd {

	@Test
	void test() {
		Floyd floyd = new Floyd();
		
		
		
		double[][] test = {{0.0, Double.POSITIVE_INFINITY, 3.0, Double.POSITIVE_INFINITY},
						   { 2.0, 0.0, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY},
						   {Double.POSITIVE_INFINITY, 7.0, 0.0, 1.0},
						   {6.0, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0.0}};
		
		
		double[][] esperado = {{0.0, 10.0, 3.0, 4.0},
							   {2.0, 0.0, 5.0, 6.0},
							   {7.0, 7.0, 0.0, 1.0},
							   {6.0, 16.0, 9.0, 0.0}};
		
		floyd.floyd_warshall(test);
	
		double[][] resultado = floyd.grafo_floyd;
		
		assertArrayEquals(esperado, resultado);
							   
	}

}
