import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Editor {
	
	
	
	public static ArrayList<ArrayList<String>> listado = new ArrayList<ArrayList<String>>();
	
	public static ArrayList<String> ciudades = new ArrayList<>();
	
	private static int n;
	
	public static double[][] grafo;
	
	
	public static void lector(String url) {
		
		try {
		
		BufferedReader reader = new BufferedReader(new FileReader(url));
		
		String linea;
		
		while((linea = reader.readLine()) != null) {
			
			String[] datos = linea.toUpperCase().split(" ");
			
			listado.add(new ArrayList<String>(Arrays.asList(datos)));
			
			
		}
		
		
		
		reader.close();
		
	} catch(IOException e) {
		
		System.out.println("HAY UN ERROR CON LA DIRECCCION DEL ARCHIVO O NO FUE POSIBLE LEERLO");
		Main.prompt();
		
		}
		
	
	
	desglozar();
	grafo_a_matriz();
	System.out.println("");
	System.out.println("     EL GRAFO HA SIDO ACTUALIZADO Y LA MATRIZ DE ADYACENCIA ES: ");
	Floyd.print_M(grafo);
	System.out.println("");
	Floyd.floyd_warshall(grafo);
	
	
	
	}
	
	
	
	
	
	private static void desglozar() {
		
		ciudades.clear();
		
		for (int i = 0; i<listado.size(); i++) {
			
			for (int j = 0; j < 2; j++) {
				
				if (!ciudades.contains(listado.get(i).get(j))) {
					
					ciudades.add(listado.get(i).get(j));
					
				} else {
					
					// no hacer nada
				}
				
			}
			
		}
		
	}
	
	
	
	
	private static void grafo_a_matriz() {
		
		n = ciudades.size();
		
		grafo = new double[n][n];
		
		for (int i = 0; i < listado.size(); i++) {
			
			int a = ciudades.indexOf(listado.get(i).get(0));
			int b = ciudades.indexOf(listado.get(i).get(1));
			double dist_ab = Double.parseDouble(listado.get(i).get(2));
			
			grafo[a][b] = dist_ab;
			
		}
		
		for (int i = 0; i < grafo.length; i++) {
			
			for (int j = 0; j< grafo[i].length; j++) {
				
				if (grafo[i][j]==0 && i != j) {
					
					grafo[i][j] = Double.POSITIVE_INFINITY;
					
				}
			}
		}
		
		
		
		
	}
	
	public static void eliminar_arista() {
		
		Scanner in = new Scanner(System.in);
		Scanner in3 = new Scanner(System.in);
		System.out.println("     --------------------------------- REPORTAR BLOQUEO ---------------------------------");
		System.out.println(" ");
		System.out.print("       NOMBRE DE LA CIUDAD DE SALIDA -> ");
		String Nodo1 = in.nextLine().toUpperCase();
		System.out.print("       NOMBRE DE LA CIUDAD DE LLEGADA -> ");
		String Nodo2 = in3.nextLine().toUpperCase();
		
		ArrayList<String> arista = null;
		
		for (int i = 0; i < listado.size(); i++) {
			
			if (listado.get(i).get(0).equals(Nodo1) && listado.get(i).get(1).equals(Nodo2)) {
				
				arista = listado.remove(i);
				
				
			}
			
		}
		
		if (arista == null) {
			
			System.out.println("     ");
			System.out.println("     NO SE ENCONTRÓ UN CAMINO DIRECTO ENTRE: " + Nodo1 + " Y " +  Nodo2);
			
		} else {
			System.out.println("     ");
			System.out.println("     EL CAMINO ENTRE: " + Nodo1 + " Y " + Nodo2 + " HA SIDO ELIMINADO");
			
		}
		
		desglozar();
		
		grafo_a_matriz();
		
		Floyd.floyd_warshall(grafo);
		System.out.println("");
		System.out.println("      LA MATRIZ DE ADYACENCIA ES: ");
		Floyd.print_M(grafo);
		
	}
	
	public static void agregar_arista() {
		ArrayList<String> nueva_ruta = new ArrayList<String>();
		
		Scanner in5 = new Scanner(System.in);
		Scanner in6 = new Scanner(System.in);
		Scanner in7 = new Scanner(System.in);
		System.out.println("     ----------------------------------- AGREGAR RUTA -----------------------------------");
		System.out.println(" ");
		System.out.print("       NOMBRE DE LA CIUDAD DE SALIDA -> ");
		String Nodo1 = in5.nextLine().toUpperCase();
		System.out.print("       NOMBRE DE LA CIUDAD DE LLEGADA -> ");
		String Nodo2 = in6.nextLine().toUpperCase();
		System.out.print("       DISTANCIA ENTRE CIUDADES -> ");
		String Dist = in7.nextLine();
		
		nueva_ruta.add(Nodo1);
		nueva_ruta.add(Nodo2);
		nueva_ruta.add(Dist);
		
		listado.add(nueva_ruta);
		
		
		desglozar();
		grafo_a_matriz();
		Floyd.floyd_warshall(grafo);
		System.out.println("");
		System.out.println("      LA MATRIZ DE ADYACENCIA ES: ");
		Floyd.print_M(grafo);
		
	}

}
