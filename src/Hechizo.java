/**
 * Clase abstracta que representa un hechizo y sus atributos basicos.
 * Define los atributos y comportamientos comunes a todos los tipos de hechizo los cuales son:
 * Fuego, Tierra, Agua y Planta.
 *
 * Cada subclase de hechizo concreta implementa su propia fórmula de puntaje
 * y su propio formato de almacenamiento en archivo.
 */
abstract class Hechizo implements Puntuacion {
private String nombreHechizo;
private String tipo;
private int daño;

	/**
	 * Constructor que inicializa los atributos comunes de cualquier hechizo.
	 *
	 * @param nombreHechizo obtiene el nombre identificador del hechizo.
	 * @param tipo, obtiene el tipo elemental del hechizo ya sea Fuego, Tierra, Agua o Planta.
	 * @param daño, obtiene el daño base que inflige el hechizo.
	 */
	public Hechizo(String nombreHechizo, String tipo, int daño) {
		this.setNombreHechizo(nombreHechizo);
		this.setTipo(tipo);
		this.setDaño(daño);
	
	}
	
	/**
     * Esta funcion genera el String con el formato de hechizo necesario para persistir en el archivo de texto Hechizos.txt.
     * Cada subclase define su propio formato según sus propios parámetros de clase.
     *
     * @return String con el siguiente formato: NombreHechizo;Tipo;Daño;*parámetros adicionales de cada clase*.
     */
	
	public abstract String almacenarDatos();
	
	 /**
     *  la funcion retorna el daño base del hechizo.
     *
     * @return el daño como número entero.
     */
	public int getDaño() {
		return daño;
	}
	/**
     * Establece un nuevo valor de daño entero para el hechizo.
     *
     * @param daño, el nuevo valor entero del daño a asignar.
     */
	public void setDaño(int daño) {
		this.daño = daño;
	}
	
	/**
    * la funcion retorna el nombre del hechizo.
    *
    * @return el nombre como String.
    */
	public String getNombreHechizo() {
		return nombreHechizo;
	}
	
	/**
     * Esta funcion establece el nuevo nombre del hechizo.
     *
     * @param nombreHechizo el nuevo nombre a asignar.
     */
	public void setNombreHechizo(String nombreHechizo) {
		this.nombreHechizo = nombreHechizo;
	}

	 /**
     * Esta funcion retorna el tipo elemental del hechizo.
     *
     * @return el tipo como String (Ejemplos: "Fuego" y/o "Agua" y/o "Tierra" y/o "Planta").
     */
	public String getTipo() {
		return tipo;
	}
	
	/**
     * esta funcion establece el nuevo tipo elemental del hechizo.
     *
     * @param tipo el nuevo tipo como String a asignar.
     */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	/**
     * Calcula el puntaje del hechizo según la fórmula de su propio tipo elemental, definido en cada subclase.
     *
     * @return el puntaje calculado como número decimal.
     */
	public abstract double calcularPuntaje();
}
