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
	
	
}

