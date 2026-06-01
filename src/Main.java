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
		try {
			File arch = new File("Hechizos.txt");
		    Scanner lector = new Scanner(arch); 
		            
		    while (lector.hasNextLine()) { 
		         String linea = lector.nextLine().trim(); 
		         String[] partes = linea.split(";"); 
		                
		         for (int i = 0; i < partes.length; i++) {
		             partes[i] = partes[i].trim();
		             }
				String nombreHechizo = partes[0];
				String tipo = partes[1];
				int daño = Integer.parseInt(partes[2]);
				
				if(tipo.equals("Fuego")) {
					int dur_Quemadura   = Integer.parseInt(partes[3]);
					
					listaHechizos.add(new Fuego(nombreHechizo,tipo,daño,dur_Quemadura));
				}
				
				else if(tipo.equals("Tierra")) {
					int mejoraDefensa = Integer.parseInt(partes[3]);
					
					listaHechizos.add(new Tierra(nombreHechizo,tipo,daño,mejoraDefensa));
					}
				
				else if(tipo.equals("Agua")) {
					String[] partesExtra = partes[3].split(",");
					
					int cantCuracion = Integer.parseInt(partesExtra[0]);
					int presionAgua = Integer.parseInt(partesExtra[1]);
					
					listaHechizos.add(new Agua(nombreHechizo,tipo,daño,cantCuracion,presionAgua));
					}
				
				else if(tipo.equals("Planta")) {
					String[] partesExtra = partes[3].split(",");
					
					int cantStun = Integer.parseInt(partesExtra[0]);
					int cantPlantas = Integer.parseInt(partesExtra[1]);
					
					listaHechizos.add(new Planta(nombreHechizo,tipo,daño,cantStun,cantPlantas));
					}
				}
			}
			
			catch (Exception e) {
				System.out.println("ERROR 404");
			}
			
		}		
	
    

	public static void cargarMagos() {
		try {
			File arch = new File("Magos.txt");
			Scanner lector = new Scanner(arch);
			
			 while (lector.hasNextLine()) { 
		         String linea = lector.nextLine().trim(); 
		         String[] partes = linea.split(";"); 
		                
		         for (int i = 0; i < partes.length; i++) {
		             partes[i] = partes[i].trim();  }
		        
		        if (partes.length >1 ) {
					
				
		        String nombreHechicero = partes[0]; 
		        String habilidades = partes[1];
		       		        
		        String[] skills = habilidades.split("\\|");
		        
		        Hechicero maGordito = new Hechicero(nombreHechicero);		        
		        for (int i = 0; i < skills.length; i++) {
		        	String nombreHechizo = skills[i];
		        	Hechizo hechizoActual = encontrarHechizo(nombreHechizo);
		        	
		        	if (hechizoActual != null) {
		        		maGordito.agregarHechizo(hechizoActual);
					}
				}
		        maGordito.puntuacionHechizero();
		        hechiceros.add(maGordito);
			 }
		        
		     else if (partes.length <=1) { 
		    	 System.out.println("Truco de Administrador encontrado, error desviado");}				 
		} 
			 
		} catch (Exception e) {
			System.out.println("ERROR 405");
		}
	         
	}
	
	public static Hechizo encontrarHechizo(String hechizoDeseado) {
		for(int i = 0; i < listaHechizos.size(); i++) {
			Hechizo hechizoActual =  listaHechizos.get(i);
			String nombreHechizo = hechizoActual.getNombreHechizo();

				if(nombreHechizo.equals(hechizoDeseado)) {
					return hechizoActual;
				}
			}
		System.out.println("El hechizo no fue encontrado");
		return null;
		}
}
	

