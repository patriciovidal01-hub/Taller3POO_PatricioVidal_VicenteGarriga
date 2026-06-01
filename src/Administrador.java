import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Administrador implements Menu {
	ArrayList<Hechizo> listadeHechizos = Main.listaHechizos;
	ArrayList<Hechicero> listaHechiceros = Main.hechiceros;
	Scanner lector = new Scanner(System.in);
	
  
	public void mostrarOpciones() {
	
		System.out.println("---------------------------ADMINISTRADOR--------------------------");
		System.out.println("1- Agregar Mago");
		System.out.println("2- Modificar Mago");
		System.out.println("3- Eliminar Mago");
		System.out.println("4- Agregar Hechizo");
		System.out.println("5- Modificar Hechizo");
		System.out.println("6- Eliminar Hechizo");
		System.out.println("7- Salir");	
		System.out.print("Ingresar Opcion: ");

	}

	
	public void ejecutarOpcion() {
	}
}