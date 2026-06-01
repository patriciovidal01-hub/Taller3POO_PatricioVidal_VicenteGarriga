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

		try {

			for (int a = 0; a < listaHechiceros.size(); a++) {

				for (int b = a + 1; b < listaHechiceros.size(); b++) {
					Hechicero hechiceroN1 = listaHechiceros.get(a);
					Hechicero hechiceroN2 = listaHechiceros.get(b);

					if (hechiceroN1.puntuacionHechizero() < hechiceroN2.puntuacionHechizero()) {
						listaHechiceros.set(a, hechiceroN2);
						listaHechiceros.set(b, hechiceroN1);
					}
				}
			}

			for (int a = 0; a < listadeHechizos.size(); a++) {

				for (int b = a + 1; b < listadeHechizos.size(); b++) {
					Hechizo hechizoN1 = listadeHechizos.get(a);
					Hechizo hechizoN2 = listadeHechizos.get(b);

					if (hechizoN1.calcularPuntaje() < hechizoN2.calcularPuntaje()) {
						listadeHechizos.set(a, hechizoN2);
						listadeHechizos.set(b, hechizoN1);
					}
				}
			}
			String opcion = lector.nextLine();
			while (true) {
				
				if(opcion.equals("1")) {
					
					System.out.println("Ingresar nombre de nuevo mago: ");
					String nombreNuevoMago = lector.nextLine();
					System.out.println("---------------CARGANDO---------------");
					System.out.println("......................................");
					Hechicero elmagoDelMomentoWoooh = new Hechicero(nombreNuevoMago);
					listaHechiceros.add(elmagoDelMomentoWoooh);
					actualizarArchivoMagos();
					System.out.println("Nuevo mago creado: Bienvenido ¨"+ nombreNuevoMago +"¨");
					
				}
			}
			
		} catch (Exception e) {
			System.out.println("PROBLEMA INESPERADO");
		}
		System.out.println("---CERRANDO MENU ADMINISTRADOR---");
	}
	
	
	public void actualizarArchivoMagos() {
		try {
		    BufferedWriter teclado = new BufferedWriter(new FileWriter("Magos.txt"));
		    
		    for (int i = 0; i < listaHechiceros.size(); i++) {
				Hechicero hechiceroActual = listaHechiceros.get(i);
				String nombreActual = hechiceroActual.getNombre();
				int largoHechizos = hechiceroActual.getHechizos().size();
				String convertirString = "" + nombreActual+";";
				
				for (int j = 0; j < largoHechizos; j++) {
					Hechizo hechizoActual = hechiceroActual.getHechizos().get(j);
					
					if (j == 0) { convertirString += hechizoActual.getNombreHechizo(); }
					
					else { convertirString += "|" + hechizoActual.getNombreHechizo(); } 
				}
				teclado.write(convertirString);
				teclado.newLine();
				//TERMINAR LOGICA DE REESCRIBIR EL ARCHIVO TXT DE MAGOS
			}
		    
		    teclado.close(); 
		    
		} catch (Exception e) {
		    System.out.println("Error al escribir el archivo");
		}
	}
}