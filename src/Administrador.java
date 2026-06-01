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
}