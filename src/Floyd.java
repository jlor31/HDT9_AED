import java.util.ArrayList;

public class Floyd {

	private static int n;
	public static double[][] grafo_floyd;
	public static int[][] caminos;
	public static ArrayList<Integer> camino_corto;
	
	
	
	public static void floyd_warshall(double[][] grafo) {
		
		n = grafo.length;
		grafo_floyd = new double[n][n];
		caminos =  new int[n][n];
		
		for (int i = 0; i<n; i++) {    // Inicializando matrices
			
			for (int j = 0; j < n; j++) {
				
				grafo_floyd[i][j] = grafo[i][j];
				if(grafo[i][j] != Double.POSITIVE_INFINITY) {
					caminos[i][j] = j;
				}
				
			}
			
		}
		
		
		
		
		
		for (int k = 0; k < n; k++) { // Floyd Warshall
			
			for (int i = 0; i<n; i++) {
				
				for (int j = 0; j<n; j++) {
					
					if(grafo_floyd[i][k] + grafo_floyd[k][j] < grafo_floyd[i][j]) {
						
						grafo_floyd[i][j] = grafo_floyd[i][k] + grafo_floyd[k][j];
						caminos[i][j] = caminos[i][k];
						
					}
					
				}
			}
			
		}
	
		
	}
	
	
	private static void busca_caminos(int a, int b, int dest, ArrayList<Integer> camino) {
		
		if (grafo_floyd[a][b] == Double.POSITIVE_INFINITY) {
			
			camino_corto = null;
			System.out.println("");
			System.out.println("     BAJO LAS CONDICIONES ACTUALES NO HAY NIGUNA RUTA ENTRE: " + Editor.ciudades.get(a) + " Y " + Editor.ciudades.get(b));
			
	    }else if (camino.get(camino.size()-1) == dest) {
			//break
			
			camino_corto = camino;
		}else if (caminos[a][b] == b) {
			
			camino.add(caminos[a][b]);
			
			busca_caminos(caminos[a][b], dest, dest, camino);
			
			
		}else {
			
			busca_caminos(a, caminos[a][b],dest, camino);
			
		}
		
	}
		
		
	
	
	public static ArrayList<String> camino_corto(String Salida, String Destino) {
		
		ArrayList<Integer> camino = new ArrayList<>();
		ArrayList<String> camino_ciudades = new ArrayList<String>();
		
		int a = Editor.ciudades.indexOf(Salida);
		int b = Editor.ciudades.indexOf(Destino);
		
		
		
		camino.add(a);
		
		busca_caminos(a,b,b, camino);
		
		if (camino_corto == null) {
			
			camino_ciudades.clear();
			
		}else {
		
		for (int i = 0; i < camino_corto.size(); i++) {
			
			camino_ciudades.add(Editor.ciudades.get(camino_corto.get(i)));
			
		}
		
		camino_corto.clear();
		}
		
		return camino_ciudades;
		
	}
	
	
	public static void print_M(double[][] M) {
		
		for (int i = 0; i< M.length; i++) {
			System.out.println("");
			System.out.print("       ");
			for(int j = 0; j< M[i].length; j++) {
				
				System.out.print(M[i][j] + " ");
				
			}
		}
		
		System.out.println("");
		
	}
	
	
	
	public static void centro_grafo() {
		
		
		
		ArrayList<Double> Eccentricidad = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			
			double peso = 0;
			
			for (int j = 0; j < n; j++) {
				
				if (grafo_floyd[i][j] > peso) {
					
					
					peso = grafo_floyd[i][j];
					
				}
				
			}
			
			Eccentricidad.add(peso);
			
		}
		
		
		Double min = Eccentricidad.get(0); 
		
		for (Double val : Eccentricidad) {
			
			if (val < min) {
				
				min = val;
				
			}
			
		}
		
		
		System.out.println("");
		System.out.println("     EL CENTRO DEL GRAFO ES: " + Editor.ciudades.get(Eccentricidad.indexOf(min)));
		
		
	}
	
	
}
