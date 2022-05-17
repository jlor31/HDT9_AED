
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	
	public static void prompt() {
		
		Scanner in2 = new Scanner(System.in);
		
		System.out.println(" ");
		System.out.println("     ------------------------ CENTRO DE RESPUESTA FLOYD WARSHALL ------------------------");
		System.out.println("     ");
		System.out.println("     INGRESE DIRECCION DEL GRAFO EJ: C:\\\\Users\\\\fulanito\\\\Desktop\\\\guategrafo.txt");
		System.out.print("       URL -> ");
		
		String url;
			
		url = in2.nextLine();
		
		Editor.lector(url);
		
		opciones();	
			
		
	}
	
	
	public static void opciones() {
		
		Scanner in4 = new Scanner(System.in);
		
		System.out.println(" ");
		System.out.println("     ------------------------------------- OPCIONES -------------------------------------");
		System.out.println("     ");
		System.out.println("      1. BUSCAR RUTA MAS CORTA ENTRE 2 CIUDADES");
		System.out.println("      2. REPORTAR UN BLOQUEO ENTRE 2 CIUDADES DIRECTAMENTE CONECTADAS");
		System.out.println("      3. AGREGAR UNA NUEVA RUTA ENTRE 2 CIUDADES");
		System.out.println("      4. ENCONTRAR CENTRO DEL GRAFO");
		System.out.println("      5. FINALIZAR EL PROGRAMA");
		System.out.println("");
		System.out.print("        SELECCION -> ");
		
			
		
		
		try {
			int sel = in4.nextInt();
			
			if (sel > 0 && sel < 6) {
				
				if (sel == 1) {
					System.out.println(" ");
					
					System.out.println("     --------------------------------- CAMINO MAS CORTO ---------------------------------");
					System.out.println("     ");
					Scanner in8 = new Scanner(System.in);
					Scanner in9 = new Scanner(System.in);
					
					System.out.print("       NOMBRE DE LA CIUDAD DE SALIDA -> ");
					String Nodo1 = in8.nextLine().toUpperCase();
					System.out.print("       NOMBRE DE LA CIUDAD DE LLEGADA -> ");
					String Nodo2 = in8.nextLine().toUpperCase();
					
					if (Editor.ciudades.contains(Nodo1) && Editor.ciudades.contains(Nodo2)) {
						
						ArrayList<String> camino = Floyd.camino_corto(Nodo1, Nodo2);
						System.out.println("");
						System.out.println("     EL CAMINO A SEGUIR ES: " + camino);
						System.out.println("");
						System.out.println("     Y LA DISTANCIA A RECORRER ES DE: " + Floyd.grafo_floyd[Editor.ciudades.indexOf(Nodo1)][Editor.ciudades.indexOf(Nodo2)]);
						opciones();
					}else {
						System.out.println("");
						System.out.println("     ALGUNA DE LAS CIUDADES INGRESADAS NO SE ENCUENTRA EN EL MAPA");
						opciones();
					}
					
				
					
				} else if ( sel == 2 ) {
					
					Editor.eliminar_arista();
					opciones();
					
				} else if (sel == 3) {
					
					Editor.agregar_arista();
					opciones();
				}else if ( sel == 4) {
					
					Floyd.centro_grafo();
					opciones();
					
				}else if (sel == 5) {
					
					System.out.println("     SESION FINALIZADA EXITOSAMENTE");
					System.exit(0);
					
					
				}
				
			} else {
				
				System.out.println("");
				System.out.println("   LA SELECCION ES INVALIDA");
				opciones();
			}
			
			
		} catch(Exception E) {
			
			System.out.println("");
			System.out.println("     LA SELECCION ES INVALIDA");
			opciones();
		}
		
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		prompt();
		
		System.out.println(" ");

	}

}
