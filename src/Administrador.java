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

				if (opcion.equals("1")) {

					System.out.println("Ingresar nombre de nuevo mago: ");
					String nombreNuevoMago = lector.nextLine();
					System.out.println("---------------CARGANDO---------------");
					System.out.println("......................................");
					Hechicero elmagoDelMomentoWoooh = new Hechicero(nombreNuevoMago);
					listaHechiceros.add(elmagoDelMomentoWoooh);
					actualizarArchivoMagos();
					System.out.println("Nuevo mago creado: Bienvenido ¨" + nombreNuevoMago + "¨");

				}
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
				else if (opcion.equals("2")) {
					if (listaHechiceros.isEmpty()) {
						System.out.println("-------------AVISO-------------");
						System.out.println("---NO HAY MAGOS DISPONIBLES---");
					} else {

						int opcionModificar = 0;
						Boolean ingresoValido = false;

						while (opcionModificar != 4) {
							ingresoValido = false;
							System.out.println("----------ACCEDIENDO----------");
							System.out.println("---¿QUE DESEA MODIFICAR?---");
							System.out.println("1- Modificar Nombre");
							System.out.println("2- Enseñar nuevo hechizo");
							System.out.println("3- Olvidar hechizo");
							System.out.println("4- Volver al menu principal");

							while (ingresoValido == false) {

								try {
									System.out.println("Ingrese opcion: ");
									opcionModificar = Integer.parseInt(lector.nextLine());

									while (opcionModificar <= 0 || opcionModificar > 4) {
										System.out.println("-----ERROR: NUMERO INVALIDO-----");
										System.out.println("1- Modificar Nombre");
										System.out.println("2- Enseñar nuevo hechizo");
										System.out.println("3- Olvidar hechizo");
										System.out.println("4- Volver al menu principal");
										System.out.println("Ingrese opcion: ");

										opcionModificar = Integer.parseInt(lector.nextLine());
									}
									ingresoValido = true;
								}

								catch (Exception e) {
									System.out.println("-----REVALIDANDO DATOS-----");
								}
							}

							if (opcionModificar != 4) {

								System.out.println("--------MAGOS--------");
								for (int i = 0; i < listaHechiceros.size(); i++) {
									System.out.println((i + 1) + "-" + listaHechiceros.get(i).getNombre());
								}

								int numeroMagoModificado = 0;
								ingresoValido = false;

								while (ingresoValido == false) {

									try {
										System.out.println("Ingrese numero del mago a Modificar: ");
										numeroMagoModificado = Integer.parseInt(lector.nextLine());

										while (numeroMagoModificado <= 0
												|| numeroMagoModificado >= listaHechiceros.size() + 1) {
											System.out.println("-----ERROR: NUMERO INVALIDO-----");
											System.out.println("Ingrese numero del mago a Modificar");
											numeroMagoModificado = Integer.parseInt(lector.nextLine());
										}
										ingresoValido = true;
									}

									catch (Exception e) {
										System.out.println("---REVALIDANDO---");
									}
								}

								Hechicero magoModificado = listaHechiceros.get(numeroMagoModificado - 1);
								String nombreMagoModificado = magoModificado.getNombre();

								System.out.println("---------------CARGANDO---------------");
								System.out.println("......................................");

								// BLOQUE DE LAS OPCIONES DE MODIFICAR

								if (opcionModificar == 1) {

									System.out.println("Ingresar nuevo nombre: ");
									String nombreNuevoMagoModificado = lector.nextLine();
									String nombreAntiguoMagoModificado = nombreMagoModificado;

									System.out.println("---------------CARGANDO---------------");
									magoModificado.setNombre(nombreNuevoMagoModificado);
									System.out.println(
											nombreAntiguoMagoModificado + " --------> " + nombreNuevoMagoModificado);

									actualizarArchivoMagos();
								}

								else if (opcionModificar == 2) {

									System.out.println("--------HECHIZOS--------");
									for (int i = 0; i < listadeHechizos.size(); i++) {
										System.out.println(
												(i + 1) + "-" + listadeHechizos.get(i).getNombreHechizo() + " ");
									}

									int hechizoSeleccionado = 0;
									ingresoValido = false;

									while (ingresoValido == false) {

										try {
											System.out.println("Ingrese numero del Hechizo a enseñar: ");
											hechizoSeleccionado = Integer.parseInt(lector.nextLine());

											while (hechizoSeleccionado <= 0
													|| hechizoSeleccionado >= listadeHechizos.size() + 1) {
												System.out.println("-----ERROR: NUMERO INVALIDO-----");
												System.out.println("Ingrese numero del Hechizo a enseñar: ");
												hechizoSeleccionado = Integer.parseInt(lector.nextLine());
											}
											ingresoValido = true;
										}

										catch (Exception e) {
											System.out.println("---REVALIDANDO HECHIZOS---");
										}

									}

									Hechizo hechizoEnseñar = listadeHechizos.get(hechizoSeleccionado - 1);
									String nombreHechizoEnseñar = hechizoEnseñar.getNombreHechizo();

									magoModificado.agregarHechizo(hechizoEnseñar);

									System.out.println("El mago " + nombreMagoModificado + " ha aprendido "
											+ nombreHechizoEnseñar + " con exito");
									actualizarArchivoMagos();

								}

								else if (opcionModificar == 3) {
									// Ingresar modificacion de olvidar hechizo
									ArrayList<Hechizo> hechizosMagoModificado = magoModificado.getHechizos();

									System.out.println("--------HECHIZOS DEL MAGO--------");
									for (int i = 0; i < hechizosMagoModificado.size(); i++) {
										System.out.println(
												(i + 1) + "-" + hechizosMagoModificado.get(i).getNombreHechizo() + " ");
									}

									int hechizoSeleccionado = 0;
									ingresoValido = false;

									while (ingresoValido == false) {

										try {
											System.out.println("Ingrese numero del Hechizo a olvidar: ");
											hechizoSeleccionado = Integer.parseInt(lector.nextLine());

											while (hechizoSeleccionado <= 0
													|| hechizoSeleccionado >= hechizosMagoModificado.size() + 1) {
												System.out.println("-----ERROR: NUMERO INVALIDO-----");
												System.out.println("Ingrese numero del Hechizo a olvidar: ");
												hechizoSeleccionado = Integer.parseInt(lector.nextLine());
											}
											ingresoValido = true;
										}

										catch (Exception e) {
											System.out.println("---REVALIDANDO HECHIZOS---");
										}

									}

									Hechizo hechizoOlvidar = hechizosMagoModificado.get(hechizoSeleccionado - 1);
									String nombreHechizoOlvidar = hechizoOlvidar.getNombreHechizo();

									hechizosMagoModificado.remove(hechizoSeleccionado - 1);

									System.out.println("El mago " + magoModificado.getNombre() + " ha olvidado "
											+ nombreHechizoOlvidar + " con exito");
									actualizarArchivoMagos();

								}
							}
						}
						System.out.println("---Volviendo al Menu Principal---");
					}
				}
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

				else if (opcion.equals("3")) {
					if (listaHechiceros.isEmpty()) {
						System.out.println("-------------AVISO-------------");
						System.out.println("---NO HAY MAGOS DISPONIBLES---");
					} else {

						for (int i = 0; i < listaHechiceros.size(); i++) {
							System.out.println((i + 1) + "-" + listaHechiceros.get(i).getNombre());
						}
						int numeroMagoEliminar = 0;
						Boolean ingresoValido = false;

						while (ingresoValido == false) {

							try {
								System.out.println("Ingrese numero del mago a expulsar");
								numeroMagoEliminar = Integer.parseInt(lector.nextLine());

								while (numeroMagoEliminar <= 0 || numeroMagoEliminar >= listaHechiceros.size() + 1) {
									System.out.println("-----ERROR: NUMERO INVALIDO-----");
									System.out.println("Ingrese numero del mago a expulsar");
									numeroMagoEliminar = Integer.parseInt(lector.nextLine());
								}
								ingresoValido = true;
							}

							catch (Exception e) {
								System.out.println("---REVALIDANDO---");
							}
						}

						Hechicero magoEliminar = listaHechiceros.get(numeroMagoEliminar - 1);
						String nombreMagoEliminar = magoEliminar.getNombre();

						System.out.println("---------------CARGANDO---------------");
						System.out.println("......................................");

						listaHechiceros.remove(numeroMagoEliminar - 1);
						actualizarArchivoMagos();
						System.out.println("El mago: ¨" + nombreMagoEliminar + "¨" + " ha sido eliminado exitosamente");

					}
				} else if (opcion.equals("4")) {
					// Ingresar opcion de Agregar hechizo y lo que se necesita.

					System.out.println("Ingresar nombre del nuevo Hechizo: ");
					String nombreNuevoHechizo = lector.nextLine();

					// BLOQUE DE VERIFICACION
					int dañoNuevoHechizo = 0;
					boolean ingresoValido = false;

					while (ingresoValido == false) {

						try {
							System.out.println("Ingresar daño del nuevo Hechizo: ");
							System.out.println("---RECORDATORIO---");
							System.out.println(
									"Para que el juego tenga un equilibrio el hechizo no puede tener más de 200 de daño ni puede tener menos de 5 de daño.");
							System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");
							dañoNuevoHechizo = Integer.parseInt(lector.nextLine());

							while (dañoNuevoHechizo <= 4 || dañoNuevoHechizo >= 201) {
								System.out.println("-----ERROR: VALOR INVALIDO-----");
								System.out.println("---------RECORDATORIO---------");
								System.out.println(
										"Para que el juego tenga un equilibrio el hechizo no puede tener más de 200 de daño ni puede tener menos de 5 de daño. ");
								System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");
								dañoNuevoHechizo = Integer.parseInt(lector.nextLine());
							}
							ingresoValido = true;
						}

						catch (Exception e) {
							System.out.println("---REVALIDANDO VALORES---");
						}

					}

					// TERMINO DE BLOQUE DE VERIFICACION

					System.out.println("Ingresar el Tipo de elemento del nuevo Hechizo: ");
					System.out.println("1- Fuego (1)");
					System.out.println("2- Tierra (2)");
					System.out.println("3- Planta (3)");
					System.out.println("4- Agua (4)");

					String tipoNuevoHechizo = "";
					int opcionNuevoHechizo = 0;
					ingresoValido = false;

					while (ingresoValido == false) {

						try {
							System.out.println("Ingresar el Tipo de elemento del nuevo Hechizo: ");
							opcionNuevoHechizo = Integer.parseInt(lector.nextLine());

							while (opcionNuevoHechizo <= 0 || opcionNuevoHechizo > 4) {
								System.out.println("-----ERROR: NUMERO INVALIDO-----");
								System.out.println("Ingresar el Tipo de elemento del nuevo Hechizo: ");
								opcionNuevoHechizo = Integer.parseInt(lector.nextLine());
							}
							ingresoValido = true;
						}

						catch (Exception e) {
							System.out.println("---REVALIDANDO ELEMENTOS---");
						}
					}
					// AQUI HAY QUE PEDIR LAS OPCIONES ESPECIALES POR CADA TIPO
					System.out.println("----------CARGANDO ELEMENTOS-----------");
					System.out.println("......................................");

					if (opcionNuevoHechizo == 1) {
						// OPCION FUEGO
						tipoNuevoHechizo = "Fuego";
						int duracionQuemadura = 0;
						ingresoValido = false;

						while (ingresoValido == false) {

							try {
								System.out.println("Ingresar Duracion del Hechizo: " + nombreNuevoHechizo);
								System.out.println("---RECORDATORIO---");
								System.out.println(
										"Para que el juego tenga un equilibrio el hechizo no puede tener más de 10(s) de duracion ni puede tener menos de 1(s) de duracion.");
								System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");
								duracionQuemadura = Integer.parseInt(lector.nextLine());

								while (duracionQuemadura <= 0 || duracionQuemadura >= 11) {
									System.out.println("-----ERROR: VALOR INVALIDO-----");
									System.out.println("---------RECORDATORIO---------");
									System.out.println(
											"Para que el juego tenga un equilibrio el hechizo no puede tener más de 10(s) de duracion ni puede tener menos de 1(s) de duracion.");
									System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");
									duracionQuemadura = Integer.parseInt(lector.nextLine());
								}
								ingresoValido = true;
							}

							catch (Exception e) {
								System.out.println("---REVALIDANDO VALORES---");
							}

						}

						// Creacion del hechizo de fuego en cuestion
						Hechizo hechizoNuevo = new Fuego(nombreNuevoHechizo, tipoNuevoHechizo, dañoNuevoHechizo,
								duracionQuemadura);
						listadeHechizos.add(hechizoNuevo);
						actualizarArchivoHechizo();
					} else if (opcionNuevoHechizo == 2) {
						// OPCION TIERRA
						tipoNuevoHechizo = "Tierra";
						int mejoradefensa = 0;
						ingresoValido = false;

						while (ingresoValido == false) {

							try {
								System.out.println("Ingresar Mejora de Defensa del Hechizo: " + nombreNuevoHechizo);
								System.out.println("---RECORDATORIO---");
								System.out.println(
										"Para que el juego tenga un equilibrio el hechizo no puede tener más de 50 de mejora de defensa ni puede tener menos de 5 de mejora de defensa.");
								System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");
								mejoradefensa = Integer.parseInt(lector.nextLine());

								while (mejoradefensa <= 4 || mejoradefensa >= 51) {
									System.out.println("-----ERROR: VALOR INVALIDO-----");
									System.out.println("---------RECORDATORIO---------");
									System.out.println(
											"Para que el juego tenga un equilibrio el hechizo no puede tener más de 50 de mejora de defensa ni puede tener menos de 5 de mejora de defensa.");
									System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");
									mejoradefensa = Integer.parseInt(lector.nextLine());
								}
								ingresoValido = true;
							}

							catch (Exception e) {
								System.out.println("---REVALIDANDO VALORES---");
							}

						}

						// Creacion del hechizo de Tierra en cuestion
						Hechizo hechizoNuevo = new Tierra(nombreNuevoHechizo, tipoNuevoHechizo, dañoNuevoHechizo,
								mejoradefensa);
						listadeHechizos.add(hechizoNuevo);
						actualizarArchivoHechizo();

					} else if (opcionNuevoHechizo == 3) {
						// OPCION PLANTA
						tipoNuevoHechizo = "Planta";
						int cantStun = 0;
						int cantPlantas = 0;
						ingresoValido = false;
						// VALIDACION DEL PARAMETRO DE STUN
						while (ingresoValido == false) {

							try {
								System.out.println("Ingresar Tiempo de Stun del Hechizo: " + nombreNuevoHechizo);
								System.out.println("---RECORDATORIO---");
								System.out.println(
										"Para que el juego tenga un equilibrio el hechizo no puede tener más de 5(s) de Stun ni puede tener menos de 1(s) de Stun.");
								System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");
								cantStun = Integer.parseInt(lector.nextLine());

								while (cantStun <= 0 || cantStun >= 6) {
									System.out.println("-----ERROR: VALOR INVALIDO-----");
									System.out.println("---------RECORDATORIO---------");
									System.out.println(
											"Para que el juego tenga un equilibrio el hechizo no puede tener más de 50 de mejora de defensa ni puede tener menos de 5 de mejora de defensa.");
									System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");
									cantStun = Integer.parseInt(lector.nextLine());
								}
								ingresoValido = true;
							}

							catch (Exception e) {
								System.out.println("---REVALIDANDO VALORES---");
							}

						}
						ingresoValido = false;
						// VALIDACION DEL PARAMETRO DE PLANTAS
						while (ingresoValido == false) {

							try {
								System.out.println("Ingresar Cantidad de Plantas del Hechizo: " + nombreNuevoHechizo);
								System.out.println("---RECORDATORIO---");
								System.out.println(
										"Para que el juego tenga un equilibrio el hechizo no puede tener más de 10 plantas ni puede tener menos de 1 planta.");
								System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");
								cantPlantas = Integer.parseInt(lector.nextLine());

								while (cantPlantas <= 0 || cantPlantas >= 11) {
									System.out.println("-----ERROR: VALOR INVALIDO-----");
									System.out.println("---------RECORDATORIO---------");
									System.out.println(
											"Para que el juego tenga un equilibrio el hechizo no puede tener más de 10 plantas ni puede tener menos de 1 planta.");
									System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");
									cantPlantas = Integer.parseInt(lector.nextLine());
								}
								ingresoValido = true;
							}

							catch (Exception e) {
								System.out.println("---REVALIDANDO PLANTAS---");
							}

						}

						// Creacion del hechizo de Planta en cuestion
						Hechizo hechizoNuevo = new Planta(nombreNuevoHechizo, tipoNuevoHechizo, dañoNuevoHechizo,
								cantStun, cantPlantas);
						listadeHechizos.add(hechizoNuevo);
						actualizarArchivoHechizo();

					} else if (opcionNuevoHechizo == 4) {
						// OPCION AGUA
						tipoNuevoHechizo = "Agua";
						int cantCuracion = 0;
						int presionAgua = 0;
						ingresoValido = false;
						// VALIDACION DEL PARAMETRO DE CURACION
						while (ingresoValido == false) {

							try {
								System.out.println("Ingresar Cantidad de Curacion del Hechizo: " + nombreNuevoHechizo);
								System.out.println("---RECORDATORIO---");
								System.out.println(
										"Para que el juego tenga un equilibrio el hechizo no puede tener más de 100 de Curacion ni puede tener menos de 1 de Curacion.");
								System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");
								cantCuracion = Integer.parseInt(lector.nextLine());

								while (cantCuracion <= 0 || cantCuracion >= 101) {
									System.out.println("-----ERROR: VALOR INVALIDO-----");
									System.out.println("---------RECORDATORIO---------");
									System.out.println(
											"Para que el juego tenga un equilibrio el hechizo no puede tener más de 50 de mejora de defensa ni puede tener menos de 5 de mejora de defensa.");
									System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");
									cantCuracion = Integer.parseInt(lector.nextLine());
								}
								ingresoValido = true;
							}

							catch (Exception e) {
								System.out.println("---REVALIDANDO SANACIONES---");
							}

						}
						ingresoValido = false;

						// VALIDACION DEL PARAMETRO DE PRESION DEL AGUA
						while (ingresoValido == false) {

							try {
								System.out
										.println("Ingresar la cantidad de Presion del Hechizo: " + nombreNuevoHechizo);
								System.out.println("---RECORDATORIO---");
								System.out.println(
										"Para que el juego tenga un equilibrio el hechizo no puede tener más de 600 de presion ni puede tener menos de 10 de presion.");
								System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");
								presionAgua = Integer.parseInt(lector.nextLine());

								while (presionAgua <= 9 || presionAgua >= 601) {
									System.out.println("-----ERROR: VALOR INVALIDO-----");
									System.out.println("---------RECORDATORIO---------");
									System.out.println(
											"Para que el juego tenga un equilibrio el hechizo no puede tener más de 600 de presion ni puede tener menos de 10 de presion.");
									System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");
									presionAgua = Integer.parseInt(lector.nextLine());
								}
								ingresoValido = true;
							}

							catch (Exception e) {
								System.out.println("---REVALIDANDO PRESION---");
							}

						}

						// Creacion del hechizo de Agua en cuestion
						Hechizo hechizoNuevo = new Agua(nombreNuevoHechizo, tipoNuevoHechizo, dañoNuevoHechizo,
								cantCuracion, presionAgua);
						listadeHechizos.add(hechizoNuevo);
						actualizarArchivoHechizo();

					} else if (opcion.equals("5")) {
						if (listadeHechizos.isEmpty()) {
							System.out.println("--------------AVISO--------------");
							System.out.println("---NO HAY HECHIZOS DISPONIBLES---");
						} else {

							int opcionModificar = 0;
							boolean ingresoValido = false;
							// CICLO DEL MENU
							while (opcionModificar != 7) {

								ingresoValido = false;
								System.out.println("----------ACCEDIENDO----------");
								System.out.println("---¿QUE DESEA MODIFICAR?---");
								System.out.println("1- Modificar Nombre");
								System.out.println("2- Modificar Daño");
								System.out.println("3- Modificar Variables de Clase");
								System.out.println("4- Aplicar Mutación Elemental");
								System.out.println("5- Buffear hechizo");
								System.out.println("6- Nerfear Hechizo");
								System.out.println("7- Salir");

								while (ingresoValido == false) {

									try {
										System.out.println("Ingrese opcion: ");
										opcionModificar = Integer.parseInt(lector.nextLine());

										while (opcionModificar <= 0 || opcionModificar > 7) {
											System.out.println("-----ERROR: NUMERO INVALIDO-----");
											System.out.println("1- Modificar Nombre");
											System.out.println("2- Modificar Daño");
											System.out.println("3- Modificar Variables de Clase");
											System.out.println("4- Aplicar Mutación Elemental");
											System.out.println("5- Buffear hechizo");
											System.out.println("6- Nerfear Hechizo");
											System.out.println("7- Salir");
											System.out.println("Ingrese opcion: ");

											opcionModificar = Integer.parseInt(lector.nextLine());
										}
										ingresoValido = true;
									}

									catch (Exception e) {
										System.out.println("-----REVALIDANDO OPCIONES-----");
									}
								}

								if (opcionModificar != 7) {

									System.out.println("--------HECHIZOS--------");
									for (int i = 0; i < listadeHechizos.size(); i++) {
										System.out.println((i + 1) + "-" + listadeHechizos.get(i).getNombreHechizo());
									}
									int numeroHechizoModificar = 0;
									ingresoValido = false;

									while (ingresoValido == false) {

										try {
											System.out.println("Ingrese numero del Hechizo a Modificar");
											numeroHechizoModificar = Integer.parseInt(lector.nextLine());

											while (numeroHechizoModificar <= 0
													|| numeroHechizoModificar >= listadeHechizos.size() + 1) {
												System.out.println("-----ERROR: NUMERO INVALIDO-----");
												System.out.println("Ingrese numero del Hechizo a Modificar");
												numeroHechizoModificar = Integer.parseInt(lector.nextLine());
											}
											ingresoValido = true;
										}

										catch (Exception e) {
											System.out.println("---REVALIDANDO---");
										}
									}

									Hechizo hechizoModificar = listadeHechizos.get(numeroHechizoModificar - 1);
									String nombreHechizoModificar = hechizoModificar.getNombreHechizo();
									int dañoHechizoModificar = hechizoModificar.getDaño();

									System.out.println("---------------CARGANDO---------------");
									System.out.println("......................................");

									if (opcionModificar == 1) {
										// Modificar nombre y cambiarlo en todos los que lo posean
										System.out.println(
												"Ingrese Nuevo nombre para el hechizo: " + nombreHechizoModificar);
										String nuevoNombreHechizoModificar = lector.nextLine();
										System.out.println("-----APLICANDO AJUSTES-----");
										for (Hechicero hechicero : listaHechiceros) {
											if (hechicero.getHechizos().contains(hechizoModificar)) {
												int posicion = hechicero.getHechizos().indexOf(hechizoModificar);
												hechicero.getHechizos().get(posicion)
														.setNombreHechizo(nuevoNombreHechizoModificar);
											}
										}
										listadeHechizos.get(numeroHechizoModificar - 1)
												.setNombreHechizo(nuevoNombreHechizoModificar);
										actualizarArchivoHechizo();
										actualizarArchivoMagos();
									}

									if (opcionModificar == 2) {
										// Modificar Daño y cambiarlo en todos los que lo posean
										System.out.println(
												"Ingrese Nuevo Daño para el hechizo: " + nombreHechizoModificar);
										int nuevoDañoHechizo = 0;
										// INGRESAR BLOQUE DE SEGURIDAD
										ingresoValido = false;

										while (ingresoValido == false) {

											try {
												System.out.println("Ingrese Nuevo Daño para el hechizo: "
														+ nombreHechizoModificar);
												nuevoDañoHechizo = Integer.parseInt(lector.nextLine());

												while (nuevoDañoHechizo <= 4 || nuevoDañoHechizo >= 201) {
													System.out.println("-----ERROR: NUMERO INVALIDO-----");
													System.out.println(
															"Para que el juego tenga un equilibrio el hechizo no puede tener más de 200 de daño ni puede tener menos de 5 de daño. ");
													System.out.println("Ingrese Nuevo Daño para el hechizo: "
															+ nombreHechizoModificar);
													nuevoDañoHechizo = Integer.parseInt(lector.nextLine());
												}
												ingresoValido = true;
											}

											catch (Exception e) {
												System.out.println("---REVALIDANDO DAÑO---");
											}
										}

										// TERMINO DE BLOQUE DE SEGURIDAD
										System.out.println("-----APLICANDO AJUSTES-----");
										for (Hechicero hechicero : listaHechiceros) {
											if (hechicero.getHechizos().contains(hechizoModificar)) {
												int posicion = hechicero.getHechizos().indexOf(hechizoModificar);
												hechicero.getHechizos().get(posicion).setDaño(nuevoDañoHechizo);
											}
										}
										System.out.println("-----AJUSTES APLICADOS -----");

										listadeHechizos.get(numeroHechizoModificar - 1).setDaño(nuevoDañoHechizo);
										actualizarArchivoHechizo();
										actualizarArchivoMagos();
									}

									if (opcionModificar == 3) {
										// Modificar Variables de clase y cambiarlo en hechizos

										if (hechizoModificar instanceof Fuego) {
											// insertar bloque de fuego
											Fuego hechizoFuego = (Fuego) hechizoModificar;
											int duracionQuemadura = hechizoFuego.getDur_Quemadura();
											duracionQuemadura = obtenerQuemaduraNueva(nombreHechizoModificar);

											System.out.println("-----APLICANDO AJUSTES DE QUEMADURA-----");

											hechizoFuego.setDur_Quemadura(duracionQuemadura);
											actualizarArchivoHechizo();
											actualizarArchivoMagos();
											System.out.println("Se ha Ajustado con exito el hechizo: "
													+ nombreHechizoModificar + " su Duracion de Quemadura ahora es de: "
													+ duracionQuemadura + "(s)");
										}

										else if (hechizoModificar instanceof Agua) {
											// INSERTAR BLOQUE DE AGUA
											Agua hechizoAgua = (Agua) hechizoModificar;

											// INICIO BLOQUE DE SEGURIDAD DE CURACION
											int[] datosAgua = obtenerDatosAguaNuevos(nombreHechizoModificar);
											int cantCuracion = datosAgua[0];
											int presionAgua = datosAgua[1];

											System.out.println("-----APLICANDO AJUSTES DE CURACION Y PRESION-----");

											hechizoAgua.setCantCuracion(cantCuracion);
											hechizoAgua.setPresionAgua(presionAgua);
											actualizarArchivoHechizo();
											actualizarArchivoMagos();
											System.out.println("Se ha Ajustado con exito el hechizo: "
													+ nombreHechizoModificar + " su Cantidad de Curacion ahora es de: "
													+ cantCuracion + ", y su Presion ahora es de:" + presionAgua);

										}

										else if (hechizoModificar instanceof Tierra) {
											// insertar bloque de Tierra
											Tierra hechizoTierra = (Tierra) hechizoModificar;
											int mejoraDefensa = hechizoTierra.getMejoraDefensa();
											mejoraDefensa = obtenerDefensaNueva(nombreHechizoModificar);

											System.out.println("-----APLICANDO AJUSTES DE DEFENSA-----");

											hechizoTierra.setMejoraDefensa(mejoraDefensa);

											actualizarArchivoHechizo();
											actualizarArchivoMagos();
											System.out.println(
													"Se ha Ajustado con exito el hechizo: " + nombreHechizoModificar
															+ " su Mejora de Defensa ahora es de: " + mejoraDefensa);

										}

										else if (hechizoModificar instanceof Planta) {
											// insertar bloque de Planta

											Planta hechizoPlanta = (Planta) hechizoModificar;
											// BLOQUE ANTIGUO int cantStun = hechizoPlanta.getCantStun();
											// BLOQUE ANTIGUO int cantPlantas = hechizoPlanta.getCantPlantas();
											int[] datosPlanta = obtenerDatosPlantaNuevos(nombreHechizoModificar);
											int cantStun = datosPlanta[0];
											int cantPlantas = datosPlanta[1];

											System.out.println("-----APLICANDO AJUSTES DE STUN Y PLANTAS-----");

											hechizoPlanta.setCantStun(cantStun);
											hechizoPlanta.setCantPlantas(cantPlantas);

											actualizarArchivoHechizo();
											actualizarArchivoMagos();
											System.out.println(
													"Se ha Ajustado con exito el hechizo: " + nombreHechizoModificar
															+ " su Cantidad de Stun ahora es de: " + cantStun
															+ ", y su Cantidad de plantas ahora es de:" + cantPlantas);

										}
									}
									if (opcionModificar == 4) {
										// Aplicar Mutacion Elemental, cambiar tipo del elemento y agregar Mutacion
										// Elemental (nombreAntiguo)
										System.out.println("---BIENVENIDO A LA MUTACION ELEMENTAL---");
										String tipoElemento = hechizoModificar.getTipo();
										System.out.println("A que elemento quieres mutar tu hechizo: "
												+ nombreHechizoModificar + " (Actual Elemento: " + tipoElemento + ")");

										// AÑADIR LOGICA DE PREGUNTA SOBRE ELEMENTO A MUTAR

										if (hechizoModificar instanceof Fuego) {
											// MODIFICACION DE FUEGO A OTRA CLASE
											System.out.println("---ELEMENTOS DISPONIBLES PARA MUTACION---");
											System.out.println("1- Tierra (1)");
											System.out.println("2- Agua (2)");
											System.out.println("3- Planta (3)");

											int opcionMutacion = verificarOpcionMutacion(nombreHechizoModificar);

											if (opcionMutacion == 1) {
												// CREACION DE ELEMENTO TIERRA
												String nombreMutacion = "Mutacion elemental de "
														+ hechizoModificar.getNombreHechizo();
												int mejoraDefensa = obtenerDefensaNueva(nombreHechizoModificar);
												Tierra mutacionTierra = new Tierra(nombreMutacion, "Tierra",
														dañoHechizoModificar, mejoraDefensa);

												aplicarMutacion(hechizoModificar, mutacionTierra);
												System.out.println("Se ha aplicando con Exito la: " + nombreMutacion
														+ " su Mejora de Defensa ahora es de: " + mejoraDefensa);
											}

											else if (opcionMutacion == 2) {
												// CREACION DE ELEMENTO AGUA
												String nombreMutacion = "Mutacion elemental de "
														+ hechizoModificar.getNombreHechizo();
												int[] datosAgua = obtenerDatosAguaNuevos(nombreHechizoModificar);
												int cantCuracion = datosAgua[0];
												int presionAgua = datosAgua[1];
												Agua mutacionAgua = new Agua(nombreMutacion, "Agua",
														dañoHechizoModificar, cantCuracion, presionAgua);

												aplicarMutacion(hechizoModificar, mutacionAgua);
												System.out.println("Se ha aplicando con Exito la: " + nombreMutacion
														+ " su Cantidad de curacion ahora es de: " + cantCuracion
														+ " y su presion de agua ahora es de:  " + presionAgua);
											}

											else if (opcionMutacion == 3) {
												// CREACION DE ELEMENTO PLANTA
												String nombreMutacion = "Mutacion elemental de "
														+ hechizoModificar.getNombreHechizo();
												int[] datosPlanta = obtenerDatosPlantaNuevos(nombreHechizoModificar);
												int cantStun = datosPlanta[0];
												int cantPlantas = datosPlanta[1];
												Planta mutacionPlanta = new Planta(nombreMutacion, "Planta",
														dañoHechizoModificar, cantStun, cantPlantas);

												aplicarMutacion(hechizoModificar, mutacionPlanta);
												System.out.println("Se ha aplicando con Exito la: " + nombreMutacion
														+ " su tiempo de stun ahora es de: " + cantStun
														+ " y su cantidad de plantas ahora es de:  " + cantPlantas);

											}

										}

//||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

										if (hechizoModificar instanceof Agua) {
											// MODIFICACION DE AGUA A OTRA CLASE
											System.out.println("---ELEMENTOS DISPONIBLES PARA MUTACION---");
											System.out.println("1- Tierra (1)");
											System.out.println("2- Fuego (2)");
											System.out.println("3- Planta (3)");

											// VERIFICACION DE OPCION
											int opcionMutacion = verificarOpcionMutacion(nombreHechizoModificar);

											if (opcionMutacion == 1) {
												// CREACION DE ELEMENTO TIERRA
												String nombreMutacion = "Mutacion elemental de "
														+ hechizoModificar.getNombreHechizo();
												int mejoraDefensa = obtenerDefensaNueva(nombreHechizoModificar);
												Tierra mutacionTierra = new Tierra(nombreMutacion, "Tierra",
														dañoHechizoModificar, mejoraDefensa);

												aplicarMutacion(hechizoModificar, mutacionTierra);
												System.out.println("Se ha aplicando con Exito la: " + nombreMutacion
														+ " su Mejora de Defensa ahora es de: " + mejoraDefensa);
											}

											if (opcionMutacion == 2) {
												// CREACION DE ELEMENTO FUEGO
												String nombreMutacion = "Mutacion elemental de "
														+ hechizoModificar.getNombreHechizo();
												int duracionQuemadura = obtenerQuemaduraNueva(nombreHechizoModificar);
												Fuego mutacionFuego = new Fuego(nombreMutacion, "Fuego",
														dañoHechizoModificar, duracionQuemadura);

												aplicarMutacion(hechizoModificar, mutacionFuego);
												System.out.println("Se ha aplicando con Exito la: " + nombreMutacion
														+ " su tiempo de Quemadura ahora es de: " + duracionQuemadura);

											}

											if (opcionMutacion == 3) {
												// CREACION DE ELEMENTO PLANTA
												String nombreMutacion = "Mutacion elemental de "
														+ hechizoModificar.getNombreHechizo();
												int[] datosPlanta = obtenerDatosPlantaNuevos(nombreHechizoModificar);
												int cantStun = datosPlanta[0];
												int cantPlantas = datosPlanta[1];
												Planta mutacionPlanta = new Planta(nombreMutacion, "Planta",
														dañoHechizoModificar, cantStun, cantPlantas);

												aplicarMutacion(hechizoModificar, mutacionPlanta);
												System.out.println("Se ha aplicando con Exito la: " + nombreMutacion
														+ " su tiempo de stun ahora es de: " + cantStun
														+ " y su cantidad de plantas ahora es de:  " + cantPlantas);

											}

											// TERMINO DE VERIFICACION
										}
//||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

										if (hechizoModificar instanceof Planta) {
											// MODIFICACION DE PLANTA A OTRA CLASE
											System.out.println("---ELEMENTOS DISPONIBLES PARA MUTACION---");
											System.out.println("1- Tierra (1)");
											System.out.println("2- Fuego (2)");
											System.out.println("3- Agua (3)");

											// VERIFICACION DE OPCION
											int opcionMutacion = verificarOpcionMutacion(nombreHechizoModificar);

											if (opcionMutacion == 1) {
												// CREACION DE ELEMENTO TIERRA
												String nombreMutacion = "Mutacion elemental de "
														+ hechizoModificar.getNombreHechizo();
												int mejoraDefensa = obtenerDefensaNueva(nombreHechizoModificar);
												Tierra mutacionTierra = new Tierra(nombreMutacion, "Tierra",
														dañoHechizoModificar, mejoraDefensa);

												aplicarMutacion(hechizoModificar, mutacionTierra);
												System.out.println("Se ha aplicando con Exito la: " + nombreMutacion
														+ " su Mejora de Defensa ahora es de: " + mejoraDefensa);

											}

											if (opcionMutacion == 2) {
												// CREACION DE ELEMENTO FUEGO
												String nombreMutacion = "Mutacion elemental de "
														+ hechizoModificar.getNombreHechizo();
												int duracionQuemadura = obtenerQuemaduraNueva(nombreHechizoModificar);
												Fuego mutacionFuego = new Fuego(nombreMutacion, "Fuego",
														dañoHechizoModificar, duracionQuemadura);

												aplicarMutacion(hechizoModificar, mutacionFuego);
												System.out.println("Se ha aplicando con Exito la: " + nombreMutacion
														+ " su tiempo de Quemadura ahora es de: " + duracionQuemadura);
											}

											if (opcionMutacion == 3) {
												// CREACION DE ELEMENTO AGUA
												String nombreMutacion = "Mutacion elemental de "
														+ hechizoModificar.getNombreHechizo();
												int[] datosAgua = obtenerDatosAguaNuevos(nombreHechizoModificar);
												int cantCuracion = datosAgua[0];
												int presionAgua = datosAgua[1];
												Agua mutacionAgua = new Agua(nombreMutacion, "Agua",
														dañoHechizoModificar, cantCuracion, presionAgua);

												aplicarMutacion(hechizoModificar, mutacionAgua);
												System.out.println("Se ha aplicando con Exito la: " + nombreMutacion
														+ " su Cantidad de curacion ahora es de: " + cantCuracion
														+ " y su presion de agua ahora es de:  " + presionAgua);
											}

											// TERMINO DE VERIFICACION

										}
//||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

										if (hechizoModificar instanceof Tierra) {
											// MODIFICACION DE TIERRA A OTRA CLASE

											System.out.println("---ELEMENTOS DISPONIBLES PARA MUTACION---");
											System.out.println("1- Fuego (1)");
											System.out.println("2- Agua (2)");
											System.out.println("3- Planta (3)");

											// VERIFICACION DE OPCION
											int opcionMutacion = verificarOpcionMutacion(nombreHechizoModificar);

											if (opcionMutacion == 1) {
												// CREACION DE ELEMENTO FUEGO
												String nombreMutacion = "Mutacion elemental de "
														+ hechizoModificar.getNombreHechizo();
												int duracionQuemadura = obtenerQuemaduraNueva(nombreHechizoModificar);
												Fuego mutacionFuego = new Fuego(nombreMutacion, "Fuego",
														dañoHechizoModificar, duracionQuemadura);

												aplicarMutacion(hechizoModificar, mutacionFuego);
												System.out.println("Se ha aplicando con Exito la: " + nombreMutacion
														+ " su tiempo de Quemadura ahora es de: " + duracionQuemadura);

											}

											if (opcionMutacion == 2) {
												// CREACION DE ELEMENTO AGUA
												String nombreMutacion = "Mutacion elemental de "
														+ hechizoModificar.getNombreHechizo();
												int[] datosAgua = obtenerDatosAguaNuevos(nombreHechizoModificar);
												int cantCuracion = datosAgua[0];
												int presionAgua = datosAgua[1];
												Agua mutacionAgua = new Agua(nombreMutacion, "Agua",
														dañoHechizoModificar, cantCuracion, presionAgua);

												aplicarMutacion(hechizoModificar, mutacionAgua);
												System.out.println("Se ha aplicando con Exito la: " + nombreMutacion
														+ " su Cantidad de curacion ahora es de: " + cantCuracion
														+ " y su presion de agua ahora es de:  " + presionAgua);
											}

											if (opcionMutacion == 3) {
												// CREACION DE ELEMENTO PLANTA
												String nombreMutacion = "Mutacion elemental de "
														+ hechizoModificar.getNombreHechizo();
												int[] datosPlanta = obtenerDatosPlantaNuevos(nombreHechizoModificar);
												int cantStun = datosPlanta[0];
												int cantPlantas = datosPlanta[1];
												Planta mutacionPlanta = new Planta(nombreMutacion, "Planta",
														dañoHechizoModificar, cantStun, cantPlantas);

												aplicarMutacion(hechizoModificar, mutacionPlanta);
												System.out.println("Se ha aplicando con Exito la: " + nombreMutacion
														+ " su tiempo de stun ahora es de: " + cantStun
														+ " y su cantidad de plantas ahora es de:  " + cantPlantas);

											}

											// TERMINO DE VERIFICACION

										}

										System.out.println("-----MUTACION ELEMENTAL EXITOSA-----");

									}

									if (opcionModificar == 5) {
										// Modificar daño de alguna variable por valores mayores a 1
										int buffDañoHechizo = 0;
										// INGRESAR BLOQUE DE SEGURIDAD
										ingresoValido = false;

										while (ingresoValido == false) {

											try {
												System.out.println("Ingrese Nuevo % de Daño para el hechizo: "
														+ nombreHechizoModificar);
												System.out.println(
														"Para aplicar un buff de daño el porcentaje debe ser mayor a 0 y menor a una mejora mayor del 200%");
												System.out.println(
														"El parametro solo devolvera valores sin decimales redondeados (ejemplo: 104,45 --- 104 ).");
												buffDañoHechizo = Integer.parseInt(lector.nextLine());

												while (buffDañoHechizo <= 0 || buffDañoHechizo >= 201) {
													System.out.println("-----ERROR: NUMERO INVALIDO-----");
													System.out.println(
															"Para aplicar un buff de daño el porcentaje debe ser mayor a 0 y menor a una mejora mayor del 200%");
													System.out.println(
															"El parametro solo recibe valores sin decimales (ejemplo: 15 %).");
													System.out.println(
															"El parametro solo devolvera valores sin decimales redondeados (ejemplo: 104,45 --- 104 ).");
													System.out.println("Ingrese Nuevo % de Daño para el hechizo: "
															+ nombreHechizoModificar);
													buffDañoHechizo = Integer.parseInt(lector.nextLine());
												}
												ingresoValido = true;
											}

											catch (Exception e) {
												System.out.println("---REVALIDANDO DAÑO---");
											}
										}

										// TERMINO DE BLOQUE DE SEGURIDAD
										System.out.println("-----APLICANDO AJUSTES-----");
										Double porcentajeBuff = 1.0 + ((Double.valueOf(buffDañoHechizo)) / 100);

										Double dañobuffeado = Double.valueOf(dañoHechizoModificar) * porcentajeBuff;

										dañoHechizoModificar = (int) Math.round(dañobuffeado);

										for (Hechicero hechicero : listaHechiceros) {
											if (hechicero.getHechizos().contains(hechizoModificar)) {
												int posicion = hechicero.getHechizos().indexOf(hechizoModificar);
												hechicero.getHechizos().get(posicion).setDaño(dañoHechizoModificar);
											}
										}
										listadeHechizos.get(numeroHechizoModificar - 1).setDaño(dañoHechizoModificar);
										actualizarArchivoHechizo();
										actualizarArchivoMagos();
										System.out.println(
												"Se ha buffeado con exito el hechizo: " + nombreHechizoModificar
														+ " su daño ahora es de: " + dañoHechizoModificar);

									}

									if (opcionModificar == 6) {
										// Modificar daño de alguna variable por valores menores a 1 y mayores que 0

										int nerfDañoHechizo = 0;
										// INGRESAR BLOQUE DE SEGURIDAD
										ingresoValido = false;

										while (ingresoValido == false) {

											try {
												System.out
														.println("Ingrese Nuevo nerfeo del % de Daño para el hechizo: "
																+ nombreHechizoModificar);
												System.out.println(
														"Para aplicar un nerf de daño el porcentaje debe ser mayor a 0 y menor a un valor mayor del 99%");
												System.out.println(
														"El parametro solo devolvera valores sin decimales redondeados (ejemplo: 104,45 --- 104 ).");
												nerfDañoHechizo = Integer.parseInt(lector.nextLine());

												while (nerfDañoHechizo <= 0 || nerfDañoHechizo >= 100) {
													System.out.println("-----ERROR: NUMERO INVALIDO-----");
													System.out.println(
															"Para aplicar un nerf de daño el porcentaje debe ser mayor a 0 y menor a un valor mayor del 99%");
													System.out.println(
															"El parametro solo recibe valores sin decimales (ejemplo: 15 %).");
													System.out.println(
															"El parametro solo devolvera valores sin decimales redondeados (ejemplo: 104,45 --- 104 ).");
													System.out.println(
															"Ingrese Nuevo nerfeo del % de Daño para el hechizo: "
																	+ nombreHechizoModificar);
													nerfDañoHechizo = Integer.parseInt(lector.nextLine());
												}
												ingresoValido = true;
											}

											catch (Exception e) {
												System.out.println("---REVALIDANDO DAÑO---");
											}
										}

										// TERMINO DE BLOQUE DE SEGURIDAD
										System.out.println("-----APLICANDO AJUSTES-----");
										Double porcentajeNerf = 1.0 - ((Double.valueOf(nerfDañoHechizo)) / 100);

										Double dañonerfeado = Double.valueOf(dañoHechizoModificar) * porcentajeNerf;

										dañoHechizoModificar = (int) Math.round(dañonerfeado);

										for (Hechicero hechicero : listaHechiceros) {
											if (hechicero.getHechizos().contains(hechizoModificar)) {
												int posicion = hechicero.getHechizos().indexOf(hechizoModificar);
												hechicero.getHechizos().get(posicion).setDaño(dañoHechizoModificar);
											}
										}
										listadeHechizos.get(numeroHechizoModificar - 1).setDaño(dañoHechizoModificar);
										actualizarArchivoHechizo();
										actualizarArchivoMagos();
										System.out.println(
												"Se ha nerfeado con exito el hechizo: " + nombreHechizoModificar
														+ " su daño ahora es de: " + dañoHechizoModificar);

									}

								}

							}

						}
					} else if(opcion.equals("6")) {
						//Ingresar opcion de Eliminar hechizo y lo que se requiere.
						if (listadeHechizos.isEmpty()) {
							System.out.println("--------------AVISO--------------");
							System.out.println("---NO HAY HECHIZOS DISPONIBLES---");
						}
						else {
							
						
						for (int i = 0; i < listadeHechizos.size(); i++) {
							System.out.println((i+1) +"-" +listadeHechizos.get(i).getNombreHechizo());
						}
						int numeroHechizoEliminar = 0;
						Boolean ingresoValido = false;
						
						while (ingresoValido == false) {							
							try {
								System.out.println("Ingrese numero del Hechizo a Eliminar");
								numeroHechizoEliminar = Integer.parseInt(lector.nextLine());
								
								while (numeroHechizoEliminar <= 0 || numeroHechizoEliminar >= listadeHechizos.size()+ 1) {
									System.out.println("-----ERROR: NUMERO INVALIDO-----");
									System.out.println("Ingrese numero del Hechizo a Eliminar");
									numeroHechizoEliminar = Integer.parseInt(lector.nextLine());
								}
								ingresoValido = true;
							} 
							
							catch (Exception e) {
								System.out.println("---REVALIDANDO---");
							}
						}

						Hechizo hechizoEliminar = listadeHechizos.get(numeroHechizoEliminar-1);
						String nombreHechizoEliminar= hechizoEliminar.getNombreHechizo();
						
						System.out.println("---------------CARGANDO---------------");
						System.out.println("......................................");
										
						for (Hechicero hechicero : listaHechiceros) {
							if (hechicero.getHechizos().contains(hechizoEliminar)) {
								int posicion2 = hechicero.getHechizos().indexOf(hechizoEliminar);
								hechicero.getHechizos().remove(posicion2);
							}
						}
						listadeHechizos.remove(numeroHechizoEliminar-1);
						actualizarArchivoHechizo();
						actualizarArchivoMagos();
						System.out.println("El Hechizo: ¨"+ nombreHechizoEliminar +"¨"+" ha sido eliminado exitosamente");

						
						}
					}
					else if(opcion.equals("7")) {
						break;
						}

				}

				mostrarOpciones();
				opcion = lector.nextLine();
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
				String convertirString = "" + nombreActual + ";";

				for (int j = 0; j < largoHechizos; j++) {
					Hechizo hechizoActual = hechiceroActual.getHechizos().get(j);

					if (j == 0) {
						convertirString += hechizoActual.getNombreHechizo();
					}

					else {
						convertirString += "|" + hechizoActual.getNombreHechizo();
					}
				}
				teclado.write(convertirString);
				teclado.newLine();
				// TERMINAR LOGICA DE REESCRIBIR EL ARCHIVO TXT DE MAGOS
			}

			teclado.close();

		} catch (Exception e) {
			System.out.println("Error al escribir el archivo");
		}
	}

	public void actualizarArchivoHechizo() {
		try {
			BufferedWriter teclado = new BufferedWriter(new FileWriter("Hechizos.txt"));

			for (int i = 0; i < listadeHechizos.size(); i++) {
				Hechizo hechizoActual = listadeHechizos.get(i);

				String convertirString = hechizoActual.almacenarDatos();

				teclado.write(convertirString);
				teclado.newLine();
			}

			// teclado.write("INSERTAR TEXTO");
			// teclado.newLine(); // Esto hace un salto de línea (un "Enter")

			teclado.close();

		} catch (Exception e) {
			System.out.println("Error al escribir el archivo");
		}
	}

	public int obtenerQuemaduraNueva(String nombreHechizo) {
		int duracionQuemadura = 0;
		boolean ingresoValido = false;

		while (ingresoValido == false) {
			try {
				System.out.println("Ingresar Duracion del Hechizo: " + nombreHechizo);
				System.out.println("---RECORDATORIO---");
				System.out.println(
						"Para que el juego tenga un equilibrio el hechizo no puede tener más de 10(s) de duracion ni puede tener menos de 1(s) de duracion.");
				System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");
				duracionQuemadura = Integer.parseInt(lector.nextLine());

				while (duracionQuemadura <= 0 || duracionQuemadura >= 11) {
					System.out.println("-----ERROR: VALOR INVALIDO-----");
					System.out.println("---------RECORDATORIO---------");
					System.out.println(
							"Para que el juego tenga un equilibrio el hechizo no puede tener más de 10(s) de duracion ni puede tener menos de 1(s) de duracion.");
					System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");
					System.out.println("Ingresar Duracion del Hechizo: " + nombreHechizo);
					duracionQuemadura = Integer.parseInt(lector.nextLine());
				}
				ingresoValido = true;
			} catch (Exception e) {
				System.out.println("---REVALIDANDO QUEMADURAS---");
			}
		}
		System.out.println("-----PROCESANDO-----");
		return duracionQuemadura;
	}

	public int obtenerDefensaNueva(String nombreHechizo) {
		int mejoraDefensa = 0;
		boolean ingresoValido = false;

		while (ingresoValido == false) {
			try {
				System.out.println("Ingresar Mejora de Defensa del Hechizo: " + nombreHechizo);
				System.out.println("---RECORDATORIO---");
				System.out.println(
						"Para que el juego tenga un equilibrio el hechizo no puede tener más de 50 de mejora de defensa ni puede tener menos de 5 de mejora de defensa.");
				System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");
				mejoraDefensa = Integer.parseInt(lector.nextLine());

				while (mejoraDefensa <= 4 || mejoraDefensa >= 51) {
					System.out.println("-----ERROR: VALOR INVALIDO-----");
					System.out.println("---------RECORDATORIO---------");
					System.out.println(
							"Para que el juego tenga un equilibrio el hechizo no puede tener más de 50 de mejora de defensa ni puede tener menos de 5 de mejora de defensa.");
					System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");
					System.out.println("Ingresar Mejora de Defensa del Hechizo: " + nombreHechizo);
					mejoraDefensa = Integer.parseInt(lector.nextLine());
				}
				ingresoValido = true;
			} catch (Exception e) {
				System.out.println("---REVALIDANDO DEFENSAS---");
			}
		}
		System.out.println("-----PROCESANDO-----");
		return mejoraDefensa;
	}

	public int[] obtenerDatosPlantaNuevos(String nombreHechizoModificar) {
		// BLOQUE DE SEGURIDAD DE STUN
		boolean ingresoValido = false;
		int cantStun = 0;
		int cantPlantas = 0;

		while (ingresoValido == false) {

			try {
				System.out.println("Ingresar Tiempo de Stun del Hechizo: " + nombreHechizoModificar);
				System.out.println("---RECORDATORIO---");
				System.out.println(
						"Para que el juego tenga un equilibrio el hechizo no puede tener más de 5(s) de Stun ni puede tener menos de 1(s) de Stun.");
				System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");
				cantStun = Integer.parseInt(lector.nextLine());

				while (cantStun <= 0 || cantStun >= 6) {
					System.out.println("-----ERROR: VALOR INVALIDO-----");
					System.out.println("---------RECORDATORIO---------");
					System.out.println(
							"Para que el juego tenga un equilibrio el hechizo no puede tener más de 5(s) de Stun ni puede tener menos de 1(s) de Stun.");
					System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");
					cantStun = Integer.parseInt(lector.nextLine());
				}
				ingresoValido = true;
			}

			catch (Exception e) {
				System.out.println("---REVALIDANDO SUEÑOS---");
			}
		}

		ingresoValido = false;

		// INICIO BLOQUE DE SEGURIDAD DE PLANTAS
		while (ingresoValido == false) {

			try {
				System.out.println("Ingresar Cantidad De Plantas del Hechizo: " + nombreHechizoModificar);
				System.out.println("---RECORDATORIO---");
				System.out.println(
						"Para que el juego tenga un equilibrio el hechizo no puede tener más de 10 plantas ni puede tener menos de 1 planta.");
				System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");
				cantPlantas = Integer.parseInt(lector.nextLine());

				while (cantPlantas <= 0 || cantPlantas >= 11) {
					System.out.println("-----ERROR: VALOR INVALIDO-----");
					System.out.println("---------RECORDATORIO---------");
					System.out.println(
							"Para que el juego tenga un equilibrio el hechizo no puede tener más de 10 plantas ni puede tener menos de 1 planta.");
					System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");
					cantPlantas = Integer.parseInt(lector.nextLine());
				}
				ingresoValido = true;
			}

			catch (Exception e) {
				System.out.println("---REVALIDANDO PLANTAS---");
			}

		} // TERMINO BLOQUE DE SEGURIDAD DE PLANTAS
		int[] datosPlanta = new int[2];
		datosPlanta[0] = cantStun;
		datosPlanta[1] = cantPlantas;
		System.out.println("-----PROCESANDO-----");
		return datosPlanta;
	}

	public int[] obtenerDatosAguaNuevos(String nombreHechizoModificar) {
		// BLOQUE DE SEGURIDAD DE STUN
		int cantCuracion = 0;
		int presionAgua = 0;

		// INICIO BLOQUE DE SEGURIDAD DE CURACION
		boolean ingresoValido = false;
		while (ingresoValido == false) {
			try {
				System.out.println("Ingresar Nueva Cantidad de Curacion del Hechizo: " + nombreHechizoModificar
						+ "(Curacion Anterior: " + cantCuracion + ")");
				System.out.println("---RECORDATORIO---");
				System.out.println(
						"Para que el juego tenga un equilibrio el hechizo no puede tener más de 100 de Curacion ni puede tener menos de 1 de Curacion.");
				System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");
				cantCuracion = Integer.parseInt(lector.nextLine());

				while (cantCuracion <= 0 || cantCuracion >= 101) {
					System.out.println("-----ERROR: VALOR INVALIDO-----");
					System.out.println("---------RECORDATORIO---------");
					System.out.println(
							"Para que el juego tenga un equilibrio el hechizo no puede tener más de 100 de Curacion ni puede tener menos de 1 de Curacion.");
					System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");
					cantCuracion = Integer.parseInt(lector.nextLine());
				}
				ingresoValido = true;
			}

			catch (Exception e) {
				System.out.println("---REVALIDANDO CURACIONES---");
			}

		} // TERMINO BLOQUE DE SEGURIDAD CURACIONES
		ingresoValido = false;

		// BLOQUE DE SEGURIDAD DE PRESION
		while (ingresoValido == false) {

			try {
				System.out.println("Ingresar Nueva Cantidad de Presion del Hechizo: " + nombreHechizoModificar);
				System.out.println("---RECORDATORIO---");
				System.out.println(
						"Para que el juego tenga un equilibrio el hechizo no puede tener más de 600 de presion ni puede tener menos de 10 de presion.");
				System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");
				presionAgua = Integer.parseInt(lector.nextLine());

				while (presionAgua <= 9 || presionAgua >= 601) {
					System.out.println("-----ERROR: VALOR INVALIDO-----");
					System.out.println("---------RECORDATORIO---------");
					System.out.println(
							"Para que el juego tenga un equilibrio el hechizo no puede tener más de 600 de presion ni puede tener menos de 10 de presion.");
					System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");
					presionAgua = Integer.parseInt(lector.nextLine());
				}
				ingresoValido = true;
			}

			catch (Exception e) {
				System.out.println("---REVALIDANDO PRESION---");
			}

		} // TERMINO BLOQUE DE SEGURIDAD DE PRESION
		int[] datosAgua = new int[2];
		datosAgua[0] = cantCuracion;
		datosAgua[1] = presionAgua;
		return datosAgua;
	}

	public int verificarOpcionMutacion(String nombreHechizo) {
		boolean ingresoValido = false;
		int opcion = 0;
		// INICIO BLOQUE DE SEGURIDAD DE PLANTAS
		while (ingresoValido == false) {

			try {
				System.out.println("Ingresar Opcion De Mutacion del Hechizo: " + nombreHechizo);
				System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");
				opcion = Integer.parseInt(lector.nextLine());

				while (opcion <= 0 || opcion >= 4) {
					System.out.println("-----ERROR: VALOR INVALIDO-----");
					System.out.println("---------RECORDATORIO---------");
					System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");
					opcion = Integer.parseInt(lector.nextLine());
				}
				ingresoValido = true;
			}

			catch (Exception e) {
				System.out.println("---REVALIDANDO MUTACIONES---");
			}

		}
		return opcion;

	}

	public void aplicarMutacion(Hechizo hechizoModificar, Hechizo mutacion) {

		int posicion = listadeHechizos.indexOf(hechizoModificar);
		if (posicion != -1) {
			listadeHechizos.set(posicion, mutacion);
			actualizarArchivoHechizo();
			for (Hechicero hechicero : listaHechiceros) {

				if (hechicero.getHechizos().contains(hechizoModificar)) {
					int posicion2 = hechicero.getHechizos().indexOf(hechizoModificar);
					hechicero.getHechizos().set(posicion2, mutacion);
				}
			}
			actualizarArchivoMagos();
		}

		else {
			System.out.println("ERROR, POSICION INEXISTENTE");
		}

	}

}