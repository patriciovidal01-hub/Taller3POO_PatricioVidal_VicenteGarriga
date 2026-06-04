import java.util.ArrayList;
/**
 * Representa a un mago y los hechizos que posee.
 * Cada hechicero posee un nombre, y una lista de hechizos que domina,
 * ademas tiene una puntuación total calculada en base a los hechizos que domina.
 */
public class Hechicero {
private String nombre;
private double puntuacion;
private ArrayList<Hechizo> hechizos  = new ArrayList<>();

	/**
	 * es el constructor que crea un nuevo hechicero con el nombre dado en String.
	 * La lista de hechizos comienza con los hechizos predeterminado del archivo y la puntuación en 0.0.
	 *
	 * @param nombre el nombre del hechicero.
	 */
	public Hechicero(String nombre) {
		this.nombre = nombre;
	}

	/**
     * retorna el nombre del hechicero en String.
     *
     * @return el nombre como String.
     */
	public String getNombre() {
		return nombre;
	}
	
    /**
     * Establece el nombre del hechicero como String.
     *
     * @param nombre el nuevo nombre a asignar en String.
     */

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
     * retorna la lista de hechizos que domina el hechicero.
     *
     * @return ArrayList con los hechizos del mago/Hechicero.
     */
	public ArrayList<Hechizo> getHechizos() {
		return hechizos;
	}
	
	 /**
     * Agrega un "Hechizo" al repertorio del hechicero .
     *
     * @param nuevoHechizo el hechizo a agregar.
     */
	public void agregarHechizo(Hechizo nuevoHechizo) {
		hechizos.add(nuevoHechizo);
	}
	
	 /**
     * Calcula la puntuación total del hechicero sumando el puntaje de
     * cada hechizo de su repertoria y luego actualiza el atributo de puntuacion del hechicero.
     *
     * @return la puntuación total acumulada de los hechizos que tiene el hechicero.
     */
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

	 /**
     * Retorna la puntuacion actual del hechicero.
     * Para obtener el valor actualizado, llamar primero a puntuacionHechizero().
     *
     * @return la puntuación almacenada como decimal.
     */
	public double getPuntuacion() {
		return puntuacion;
	}

	/**
     * Establece manualmente la puntuación del hechicero.
     *
     * @param puntuacion el nuevo valor de puntuación.
     */
	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}
	
}

