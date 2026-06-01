import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	static ArrayList<Hechicero> hechiceros = new ArrayList<>();
	static ArrayList<Hechizo> listaHechizos = new ArrayList<>();
	
	
	public static void main(String[] args) {
		// Vicente Garriga 22.380.392-K ICCI
		// Patricio Vidal  22.330.827-9 ICCI
		cargarHechizos();
		cargarMagos();
		Scanner lector = new Scanner(System.in);
		
		Analista menuAnalista = new Analista();
		Administrador menuAdministrador = new Administrador();
		
		System.out.println("-----INGRESANDO-----");
		System.out.println("---Bienvenido Usuario---");
		System.out.println("Ingrese el tipo de menu que usara:");
		System.out.println("1- Analista (1)");
		System.out.println("2- Administrador (2)");
		System.out.println("3- Salir (3)");
		System.out.print("Ingresar Opcion: ");
		boolean ingreso = false;
		while (ingreso == false) {
			
			String opcion = lector.nextLine();
			
			if (opcion.equals("1")) {
				menuAnalista.mostrarOpciones();
				menuAnalista.ejecutarOpcion();
			}
			else if (opcion.equals("2")) {
				menuAdministrador.mostrarOpciones();
				menuAdministrador.ejecutarOpcion();
			}
			else if (opcion.equals("3")) {
				break;
			}
			
			else {
				System.out.println("------ERROR OPCION INVALIDA------");
			}
			System.out.println("Ingrese el tipo de menu que usara:");
			System.out.println("1- Analista (1)");
			System.out.println("2- Administrador (2)");
			System.out.println("3- Salir (3)");
			System.out.print("Ingresar Opcion: ");
		}
		
	}
	
	 
	public static void cargarHechizos() {
	
		
	}		
	
    

	public static void cargarMagos() {
		
	}
}
	

