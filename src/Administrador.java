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
				
				for (int b = a+1; b < listaHechiceros.size(); b++) {
					Hechicero hechiceroN1= listaHechiceros.get(a);
					Hechicero hechiceroN2= listaHechiceros.get(b);
					
					if (hechiceroN1.puntuacionHechizero() < hechiceroN2.puntuacionHechizero()) {
						listaHechiceros.set(a, hechiceroN2);
						listaHechiceros.set(b, hechiceroN1);
					}
				}
			}
			
			for (int a = 0; a < listadeHechizos.size(); a++) {
				
				for (int b = a+1; b < listadeHechizos.size(); b++) {
					Hechizo hechizoN1= listadeHechizos.get(a);
					Hechizo hechizoN2= listadeHechizos.get(b);
					
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
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
				else if(opcion.equals("2")) {
					if (listaHechiceros.isEmpty()) {
						System.out.println("-------------AVISO-------------");
						System.out.println("---NO HAY MAGOS DISPONIBLES---");
					}
					else {
						
					
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
							System.out.println((i+1) +"-" +listaHechiceros.get(i).getNombre()); }
							
							int numeroMagoModificado = 0;
							ingresoValido = false;
							
							while (ingresoValido == false) {
								
								try {
									System.out.println("Ingrese numero del mago a Modificar: ");
									numeroMagoModificado = Integer.parseInt(lector.nextLine());
									
									while (numeroMagoModificado <= 0 || numeroMagoModificado >= listaHechiceros.size()+ 1) {
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
							
		
							Hechicero magoModificado = listaHechiceros.get(numeroMagoModificado-1);
							String nombreMagoModificado= magoModificado.getNombre();
							
							
							System.out.println("---------------CARGANDO---------------");
							System.out.println("......................................");
							
							//BLOQUE DE LAS OPCIONES DE MODIFICAR
							
							if (opcionModificar == 1) {
								
								System.out.println("Ingresar nuevo nombre: ");
								String nombreNuevoMagoModificado = lector.nextLine();
								String nombreAntiguoMagoModificado = nombreMagoModificado;
								
								System.out.println("---------------CARGANDO---------------");
								magoModificado.setNombre(nombreNuevoMagoModificado);
								System.out.println(nombreAntiguoMagoModificado +" --------> "+ nombreNuevoMagoModificado);
															
								actualizarArchivoMagos();
								}
							
							else if (opcionModificar == 2) {
								
									System.out.println("--------HECHIZOS--------");
									for (int i = 0; i < listadeHechizos.size(); i++) {
										System.out.println((i+1) +"-" +listadeHechizos.get(i).getNombreHechizo()+" ");
										}
									
									int hechizoSeleccionado = 0;
									ingresoValido = false;
									
									while (ingresoValido == false) {
										
										try {
											System.out.println("Ingrese numero del Hechizo a enseñar: ");
											hechizoSeleccionado = Integer.parseInt(lector.nextLine());
											
											while (hechizoSeleccionado <= 0 || hechizoSeleccionado >= listadeHechizos.size()+ 1) {
												System.out.println("-----ERROR: NUMERO INVALIDO-----");
												System.out.println("Ingrese numero del Hechizo a enseñar: ");
												hechizoSeleccionado = Integer.parseInt(lector.nextLine());
												}
											ingresoValido = true;
											} 
										
										catch (Exception e) {
											System.out.println("---REVALIDANDO HECHIZOS---"); }
										
										}
									
										Hechizo hechizoEnseñar = listadeHechizos.get(hechizoSeleccionado-1);
										String nombreHechizoEnseñar= hechizoEnseñar.getNombreHechizo();
										
										magoModificado.agregarHechizo(hechizoEnseñar);
										
										System.out.println("El mago "+ nombreMagoModificado + " ha aprendido "+ nombreHechizoEnseñar + " con exito");
										actualizarArchivoMagos();
									
								}
							
							else if (opcionModificar == 3) {
								//Ingresar modificacion de olvidar hechizo
								ArrayList<Hechizo> hechizosMagoModificado = magoModificado.getHechizos();
								
								System.out.println("--------HECHIZOS DEL MAGO--------");
								for (int i = 0; i < hechizosMagoModificado.size(); i++) {
									System.out.println((i+1) +"-" + hechizosMagoModificado.get(i).getNombreHechizo()+" ");
									}
									
								int hechizoSeleccionado = 0;
								ingresoValido = false;
									
								while (ingresoValido == false) {
										
									try {
										System.out.println("Ingrese numero del Hechizo a olvidar: ");
										hechizoSeleccionado = Integer.parseInt(lector.nextLine());
											
										while (hechizoSeleccionado <= 0 || hechizoSeleccionado >= hechizosMagoModificado.size()+ 1) {
											System.out.println("-----ERROR: NUMERO INVALIDO-----");
											System.out.println("Ingrese numero del Hechizo a olvidar: ");
											hechizoSeleccionado = Integer.parseInt(lector.nextLine());
											}
											ingresoValido = true;
											} 
										
									catch (Exception e) {
										System.out.println("---REVALIDANDO HECHIZOS---"); }
										
									}
									
								Hechizo hechizoOlvidar = hechizosMagoModificado.get(hechizoSeleccionado-1);
								String nombreHechizoOlvidar = hechizoOlvidar.getNombreHechizo();
								
								hechizosMagoModificado.remove(hechizoSeleccionado-1);
								
								System.out.println("El mago "+ magoModificado.getNombre() + " ha olvidado "+ nombreHechizoOlvidar + " con exito");
								actualizarArchivoMagos();	

							}
						}						
					}
				System.out.println("---Volviendo al Menu Principal---");
			}
		}			
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
				
				else if(opcion.equals("3")) {
					if (listaHechiceros.isEmpty()) {
						System.out.println("-------------AVISO-------------");
						System.out.println("---NO HAY MAGOS DISPONIBLES---");
					}
					else {
						
					
					for (int i = 0; i < listaHechiceros.size(); i++) {
						System.out.println((i+1) +"-" +listaHechiceros.get(i).getNombre());
					}
					int numeroMagoEliminar = 0;
					Boolean ingresoValido = false;
					
					while (ingresoValido == false) {
						
						try {
							System.out.println("Ingrese numero del mago a expulsar");
							numeroMagoEliminar = Integer.parseInt(lector.nextLine());
							
							while (numeroMagoEliminar <= 0 || numeroMagoEliminar >= listaHechiceros.size()+ 1) {
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

					Hechicero magoEliminar = listaHechiceros.get(numeroMagoEliminar-1);
					String nombreMagoEliminar= magoEliminar.getNombre();
					
					System.out.println("---------------CARGANDO---------------");
					System.out.println("......................................");
									
					
					listaHechiceros.remove(numeroMagoEliminar-1);
					actualizarArchivoMagos();
					System.out.println("El mago: ¨"+ nombreMagoEliminar +"¨"+" ha sido eliminado exitosamente");
					
				}
			} else if(opcion.equals("4")) {
				//Ingresar opcion de Agregar hechizo y lo que se necesita.
				
				System.out.println("Ingresar nombre del nuevo Hechizo: ");
				String nombreNuevoHechizo = lector.nextLine();
				
				//BLOQUE DE VERIFICACION
				int dañoNuevoHechizo = 0;
				boolean ingresoValido = false;
					
				while (ingresoValido == false) {
						
					try {
						System.out.println("Ingresar daño del nuevo Hechizo: ");
						System.out.println("---RECORDATORIO---");
						System.out.println("Para que el juego tenga un equilibrio el hechizo no puede tener más de 200 de daño ni puede tener menos de 5 de daño.");	
						System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");	
						dañoNuevoHechizo = Integer.parseInt(lector.nextLine());
							
						while (dañoNuevoHechizo <= 4 || dañoNuevoHechizo >= 201) {
							System.out.println("-----ERROR: VALOR INVALIDO-----");
							System.out.println("---------RECORDATORIO---------");
							System.out.println("Para que el juego tenga un equilibrio el hechizo no puede tener más de 200 de daño ni puede tener menos de 5 de daño. ");
							System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");	
							dañoNuevoHechizo = Integer.parseInt(lector.nextLine());
							}
							ingresoValido = true;
							} 
						
					catch (Exception e) {
						System.out.println("---REVALIDANDO VALORES---"); }
						
					}
				
				//TERMINO DE BLOQUE DE VERIFICACION
				
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
				//AQUI HAY QUE PEDIR LAS OPCIONES ESPECIALES POR CADA TIPO
				System.out.println("----------CARGANDO ELEMENTOS-----------");
				System.out.println("......................................");
				
				if (opcionNuevoHechizo == 1) {
					//OPCION FUEGO
					tipoNuevoHechizo = "Fuego";
					int duracionQuemadura = 0;
					ingresoValido = false;
						
					while (ingresoValido == false) {
							
						try {
							System.out.println("Ingresar Duracion del Hechizo: "+ nombreNuevoHechizo);
							System.out.println("---RECORDATORIO---");
							System.out.println("Para que el juego tenga un equilibrio el hechizo no puede tener más de 10(s) de duracion ni puede tener menos de 1(s) de duracion.");	
							System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");	
							duracionQuemadura = Integer.parseInt(lector.nextLine());
								
							while (duracionQuemadura <= 0 || duracionQuemadura >= 11) {
								System.out.println("-----ERROR: VALOR INVALIDO-----");
								System.out.println("---------RECORDATORIO---------");
								System.out.println("Para que el juego tenga un equilibrio el hechizo no puede tener más de 10(s) de duracion ni puede tener menos de 1(s) de duracion.");	
								System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");	
								duracionQuemadura = Integer.parseInt(lector.nextLine());
								}
								ingresoValido = true;
								} 
							
						catch (Exception e) {
							System.out.println("---REVALIDANDO VALORES---"); }
							
						}
					
					//Creacion del hechizo de fuego en cuestion
					Hechizo hechizoNuevo = new Fuego(nombreNuevoHechizo,tipoNuevoHechizo,dañoNuevoHechizo,duracionQuemadura);
					listadeHechizos.add(hechizoNuevo);
					actualizarArchivoHechizo();
				}
				else if (opcionNuevoHechizo == 2) {
					//OPCION TIERRA
					tipoNuevoHechizo = "Tierra";
					int mejoradefensa = 0;
					ingresoValido = false;
						
					while (ingresoValido == false) {
							
						try {
							System.out.println("Ingresar Mejora de Defensa del Hechizo: "+ nombreNuevoHechizo);
							System.out.println("---RECORDATORIO---");
							System.out.println("Para que el juego tenga un equilibrio el hechizo no puede tener más de 50 de mejora de defensa ni puede tener menos de 5 de mejora de defensa.");	
							System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");	
							mejoradefensa = Integer.parseInt(lector.nextLine());
								
							while (mejoradefensa <= 4 || mejoradefensa >= 51) {
								System.out.println("-----ERROR: VALOR INVALIDO-----");
								System.out.println("---------RECORDATORIO---------");
								System.out.println("Para que el juego tenga un equilibrio el hechizo no puede tener más de 50 de mejora de defensa ni puede tener menos de 5 de mejora de defensa.");	
								System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");	
								mejoradefensa = Integer.parseInt(lector.nextLine());
								}
								ingresoValido = true;
								} 
							
						catch (Exception e) {
							System.out.println("---REVALIDANDO VALORES---"); }
							
						}
					
					//Creacion del hechizo de Tierra en cuestion
					Hechizo hechizoNuevo = new Tierra(nombreNuevoHechizo,tipoNuevoHechizo,dañoNuevoHechizo,mejoradefensa);
					listadeHechizos.add(hechizoNuevo);
					actualizarArchivoHechizo();

				}
				else if (opcionNuevoHechizo == 3) {
					//OPCION PLANTA
					tipoNuevoHechizo = "Planta";
					int cantStun = 0;
					int cantPlantas = 0;
					ingresoValido = false;
					//VALIDACION DEL PARAMETRO DE STUN
					while (ingresoValido == false) {
							
						try {
							System.out.println("Ingresar Tiempo de Stun del Hechizo: "+ nombreNuevoHechizo);
							System.out.println("---RECORDATORIO---");
							System.out.println("Para que el juego tenga un equilibrio el hechizo no puede tener más de 5(s) de Stun ni puede tener menos de 1(s) de Stun.");	
							System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");	
							cantStun = Integer.parseInt(lector.nextLine());
								
							while (cantStun <= 0 || cantStun >= 6) {
								System.out.println("-----ERROR: VALOR INVALIDO-----");
								System.out.println("---------RECORDATORIO---------");
								System.out.println("Para que el juego tenga un equilibrio el hechizo no puede tener más de 50 de mejora de defensa ni puede tener menos de 5 de mejora de defensa.");	
								System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");	
								cantStun = Integer.parseInt(lector.nextLine());
								}
								ingresoValido = true;
								} 
							
						catch (Exception e) {
							System.out.println("---REVALIDANDO VALORES---"); }
							
						}
					ingresoValido = false;
					//VALIDACION DEL PARAMETRO DE PLANTAS
					while (ingresoValido == false) {
							
						try {
							System.out.println("Ingresar Cantidad de Plantas del Hechizo: "+ nombreNuevoHechizo);
							System.out.println("---RECORDATORIO---");
							System.out.println("Para que el juego tenga un equilibrio el hechizo no puede tener más de 10 plantas ni puede tener menos de 1 planta.");	
							System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");	
							cantPlantas = Integer.parseInt(lector.nextLine());
								
							while (cantPlantas <= 0 || cantPlantas >= 11) {
								System.out.println("-----ERROR: VALOR INVALIDO-----");
								System.out.println("---------RECORDATORIO---------");
								System.out.println("Para que el juego tenga un equilibrio el hechizo no puede tener más de 10 plantas ni puede tener menos de 1 planta.");	
								System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");	
								cantPlantas = Integer.parseInt(lector.nextLine());
								}
								ingresoValido = true;
								} 
							
						catch (Exception e) {
							System.out.println("---REVALIDANDO PLANTAS---"); }
							
						}
					
					//Creacion del hechizo de Planta en cuestion
					Hechizo hechizoNuevo = new Planta(nombreNuevoHechizo,tipoNuevoHechizo,dañoNuevoHechizo,cantStun,cantPlantas);
					listadeHechizos.add(hechizoNuevo);
					actualizarArchivoHechizo();
					
				}
				else if (opcionNuevoHechizo == 4) {
					//OPCION AGUA
					tipoNuevoHechizo = "Agua";
					int cantCuracion = 0;
					int presionAgua = 0;
					ingresoValido = false;
					//VALIDACION DEL PARAMETRO DE CURACION
					while (ingresoValido == false) {
							
						try {
							System.out.println("Ingresar Cantidad de Curacion del Hechizo: "+ nombreNuevoHechizo);
							System.out.println("---RECORDATORIO---");
							System.out.println("Para que el juego tenga un equilibrio el hechizo no puede tener más de 100 de Curacion ni puede tener menos de 1 de Curacion.");	
							System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");	
							cantCuracion = Integer.parseInt(lector.nextLine());
								
							while (cantCuracion <= 0 || cantCuracion >= 101) {
								System.out.println("-----ERROR: VALOR INVALIDO-----");
								System.out.println("---------RECORDATORIO---------");
								System.out.println("Para que el juego tenga un equilibrio el hechizo no puede tener más de 50 de mejora de defensa ni puede tener menos de 5 de mejora de defensa.");	
								System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");	
								cantCuracion = Integer.parseInt(lector.nextLine());
								}
								ingresoValido = true;
								} 
							
						catch (Exception e) {
							System.out.println("---REVALIDANDO SANACIONES---"); }
							
						}
					ingresoValido = false;
					
					//VALIDACION DEL PARAMETRO DE PRESION DEL AGUA 
					while (ingresoValido == false) {
							
						try {
							System.out.println("Ingresar la cantidad de Presion del Hechizo: "+ nombreNuevoHechizo);
							System.out.println("---RECORDATORIO---");
							System.out.println("Para que el juego tenga un equilibrio el hechizo no puede tener más de 600 de presion ni puede tener menos de 10 de presion.");	
							System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");	
							presionAgua = Integer.parseInt(lector.nextLine());
								
							while (presionAgua <= 9 || presionAgua >= 601) {
								System.out.println("-----ERROR: VALOR INVALIDO-----");
								System.out.println("---------RECORDATORIO---------");
								System.out.println("Para que el juego tenga un equilibrio el hechizo no puede tener más de 600 de presion ni puede tener menos de 10 de presion.");	
								System.out.println("El parametro solo recibe valores sin decimales (ejemplo: 10).");	
								presionAgua = Integer.parseInt(lector.nextLine());
								}
								ingresoValido = true;
								} 
							
						catch (Exception e) {
							System.out.println("---REVALIDANDO PRESION---"); }
							
						}
					
					//Creacion del hechizo de Agua en cuestion
					Hechizo hechizoNuevo = new Agua(nombreNuevoHechizo,tipoNuevoHechizo,dañoNuevoHechizo,cantCuracion,presionAgua);
					listadeHechizos.add(hechizoNuevo);
					actualizarArchivoHechizo();
					
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
	
	public void actualizarArchivoHechizo() {
		try {
		    BufferedWriter teclado = new BufferedWriter(new FileWriter("Hechizos.txt"));
		    
		    for (int i = 0; i < listadeHechizos.size(); i++) {
				Hechizo hechizoActual = listadeHechizos.get(i);
				
				String convertirString = hechizoActual.almacenarDatos();
				
				teclado.write(convertirString);
				teclado.newLine();
			}
		    
		    //teclado.write("INSERTAR TEXTO");
		    //teclado.newLine(); // Esto hace un salto de línea (un "Enter")
		    
		    teclado.close(); 
		    
		} catch (Exception e) {
		    System.out.println("Error al escribir el archivo");
		}
	}
	
}