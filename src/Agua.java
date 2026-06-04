/**
 * Representa un hechizo de tipo Agua con sus propias caracteristicas.
 * Su puntaje se calcula como: (Daño + CantidadHeal + PresionDelAgua) multiplicado por 2.
 */
public class Agua extends Hechizo {
private int cantCuracion;
private int presionAgua;

	/**
	 * es el constructor que inicializa un hechizo de tipo Agua con sus respectivos parametros.
	 *
	 * @param nombreHechizo el nombre del hechizo como String..
	 * @param tipo          el tipo elemental como String (siempre sera del tipo "Agua").
	 * @param daño          el daño base del hechizo como entero.
	 * @param cantCuracion  la cantidad de puntos de vida que cura el hechizo como entero.
	 * @param presionAgua   la presión del agua que ejerce el hechizo como entero.
	 */
	public Agua(String nombreHechizo, String tipo, int daño,int cantCuracion,int presionAgua) {
		super(nombreHechizo, tipo, daño);
		this.setCantCuracion(cantCuracion);
		this.setPresionAgua(presionAgua);
	}
	
	/**
     * retorna la cantidad de curación del hechizo como entero.
     *
     * @return la curación como entero.
     */
	public int getCantCuracion() {
		return cantCuracion;
	}
	
	 /**
     * Establece la cantidad de curación del hechizo como entero.
     *
     * @param cantCuracion el nuevo valor de curación.
     */
	public void setCantCuracion(int cantCuracion) {
		this.cantCuracion = cantCuracion;
	}
	
	/**
     * Retorna la presión del agua del hechizo como entero.
     *
     * @return la presión como entero.
     */
	public int getPresionAgua() {
		return presionAgua;
	}
	
    /**
     * Establece la presión del agua del hechizo como entero.
     *
     * @param presionAgua el nuevo valor de presión.
     */
	public void setPresionAgua(int presionAgua) {
		this.presionAgua = presionAgua;
	}
	
	/**
     * Calcula el puntaje del hechizo de Agua como decimal.
     * aplica la formula: (Daño + CantidadHeal + PresionDelAgua) multiplicado por 2.
     *
     * @return el puntaje calculado como número decimal.
     */
 
	@Override
	public double calcularPuntaje() {
		double puntaje = (( getDaño() + getCantCuracion() + getPresionAgua() )*2);
		return puntaje;
	}

	/**
     * esta funcion genera el String necesario para guardar este hechizo en el archivo txt Hechizos.txt.
     *
     * @return String con el siguiente formato: NombreHechizo;Agua;Daño;CantCuracion,PresionAgua
     */
	@Override
	public String almacenarDatos() {
		String datos = "" + getNombreHechizo() + ";" + getTipo() + ";" + getDaño() + ";" + cantCuracion + "," + presionAgua;
		return datos;
	}

}
