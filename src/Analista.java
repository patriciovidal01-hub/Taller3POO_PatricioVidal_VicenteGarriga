import java.util.ArrayList;
import java.util.Scanner;

public class Analista implements Menu {

	public void mostrarOpciones() {

		System.out.println("---------------------------ANALISTA--------------------------");
		System.out.println("1- Top 10 Mejores Hechizos");
		System.out.println("2- Top 3 Mejores Magos");
		System.out.println("3- Mostrar todos los Hechizos");
		System.out.println("4- Mostrar todos los magos");
		System.out.println("5- Mostrar todos los Hechizos junto a su puntuacion ");
		System.out.println("6- Mostrar todos los magos junto a su puntuacion ");
		System.out.println("7- Salir");
		System.out.print("Ingresar Opcion: ");

	}

	public void ejecutarOpcion() {

		ArrayList<Hechizo> listadeHechizos = Main.listaHechizos;
		ArrayList<Hechicero> listaHechiceros = Main.hechiceros;
		Scanner lector = new Scanner(System.in);

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

				if (opcion.equals("1")) {

					if (listadeHechizos.size() >= 10) {
						// BLOQUE NORMAL
						System.out.println("---LOS PRIMEROS 10 HECHIZOS SON---");
						for (int i = 0; i < 10; i++) {
							System.out.println((i + 1) + "- " + listadeHechizos.get(i).getNombreHechizo() + " ");
						}
					}

					else if (listadeHechizos.size() < 10 && listadeHechizos.size() >= 1) {
						// BLOQUE SI LA LISTA DE HECHIZOS ES MENOR A 10 PERO MAYOR A 1
						int limite = listadeHechizos.size();

						System.out.println("-------------------------AVISO-------------------------");
						System.out.println("Solamente hay " + limite + " Hechizos");

						if (listadeHechizos.size() == 1) {
							System.out.println("---El PRIMER Y UNICO HECHIZO ES---");
							for (int i = 0; i < limite; i++) {
								System.out.println((i + 1) + "- " + listadeHechizos.get(i).getNombreHechizo() + " ");
							}
						}

						else {
							System.out.println("---LOS PRIMEROS " + limite + " HECHIZOS SON---");
							for (int i = 0; i < limite; i++) {
								System.out.println((i + 1) + "- " + listadeHechizos.get(i).getNombreHechizo() + " ");
							}
						}
					}

					// BLOQUE SI LOS HECHIZOS DESAPARECIERON POR ADMINISTRADOR
					if (listadeHechizos.isEmpty()) {
						System.out.println("---------------ERROR---------------");
						System.out.println("--------NO EXISTEN HECHIZOS--------");
					}

					else if (opcion.equals("2")) {
						// AÑADIR PARAMETRO DE SEGURIDAD
						System.out.println("---LOS 3 PRIMEROS MAGOS---");

						if (listaHechiceros.size() >= 3) {
							for (int i = 0; i < 3; i++) { // : listaHechiceros.get(i).getPuntuacion()
								System.out.println(
										(i + 1) + "- " + "El Hechicero " + listaHechiceros.get(i).getNombre() + " ");
							}
						}

						else if (listaHechiceros.size() < 3 && listaHechiceros.size() >= 1) {

							int limite = listaHechiceros.size();

							System.out.println("-------------------------AVISO-------------------------");
							System.out.println("Solamente hay " + limite + " Hechiceros");

							if (listaHechiceros.size() == 1) {
								System.out.println("---El PRIMER Y UNICO HECHICERO ES---");
								for (int i = 0; i < limite; i++) {
									System.out.println((i + 1) + "- " + listaHechiceros.get(i).getNombre() + " ");
								}
							}

							else {
								System.out.println("---LOS PRIMEROS " + limite + " HECHICEROS SON---");
								for (int i = 0; i < limite; i++) {
									System.out.println((i + 1) + "- " + listaHechiceros.get(i).getNombre() + " ");
								}
							}
						}
					} else if (opcion.equals("3")) {

						System.out.println("---MOSTRANDO TODOS LOS HECHIZOS---");

						if (listadeHechizos.isEmpty()) {
							System.out.println("-----ERROR NO HAY HECHIZOS-----");
						}

						else {

							for (int i = 0; i < listadeHechizos.size(); i++) {
								System.out.println(listadeHechizos.get(i).getNombreHechizo() + " ");
							}
						}
					}

					else if (opcion.equals("4")) {

						System.out.println("---MOSTRANDO TODOS LOS MAGOS---");
						if (listaHechiceros.isEmpty()) {
							System.out.println("-----ERROR NO HAY MAGOS-----");
						}

						else {
							for (int i = 0; i < listaHechiceros.size(); i++) {
								System.out.println((i + 1) + "- " + listaHechiceros.get(i).getNombre() + " ");
							}
						}

					} else if (opcion.equals("5")) {

						System.out.println("---MOSTRANDO TODOS LOS HECHIZOS Y SU PUNTAJE---");

						if (listadeHechizos.isEmpty()) {
							System.out.println("-----ERROR NO HAY HECHIZOS-----");
						}

						else {
							for (int i = 0; i < listadeHechizos.size(); i++) {
								System.out.println((i + 1) + "- " + "" + listadeHechizos.get(i).getNombreHechizo()
										+ " : " + listadeHechizos.get(i).calcularPuntaje() + "");
							}
						}
					} else if (opcion.equals("6")) {

						if (listaHechiceros.isEmpty()) {
							System.out.println("-----ERROR NO HAY MAGOS-----");
						} else {
							System.out.println("---MOSTRANDO TODOS LOS MAGOS Y SU PUNTAJE---");
							for (int i = 0; i < listaHechiceros.size(); i++) {
								System.out.println((i + 1) + "-" + listaHechiceros.get(i).getNombre() + " : "
										+ listaHechiceros.get(i).getPuntuacion());
							}
						}
					}

					else if (opcion.equals("7")) {
						break;
					}
				}
				mostrarOpciones();
				opcion = lector.nextLine();
			}

		} catch (Exception e) {
			System.out.println("PROBLEMA INESPERADO");
		}

		System.out.println("---CERRANDO MENU ANALISTA---");

	}
}
