import java.util.ArrayList;

public class Hechicero {
private String nombre;
private double puntuacion;
private ArrayList<Hechizo> hechizos  = new ArrayList<>();


	public Hechicero(String nombre) {
		this.nombre = nombre;
	}


	public String getNombre() {
		return nombre;
	}
	
  

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public ArrayList<Hechizo> getHechizos() {
		return hechizos;
	}
	
	
	public void agregarHechizo(Hechizo nuevoHechizo) {
		hechizos.add(nuevoHechizo);
	}
	
	public double puntuacionHechizero() {
		double puntajeTotal = 0.0; 
		try {
			for(int i = 0; i < hechizos.size(); i++) {
				puntajeTotal += hechizos.get(i).calcularPuntaje();				
			}
			puntuacion  = puntajeTotal;
			return puntuacion;
		}

		catch (Exception e) {
			System.out.println("Ocurrio un error inesperado");
		}
		return puntajeTotal;

	}

	
	public double getPuntuacion() {
		return puntuacion;
	}

	
	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}
	
}

