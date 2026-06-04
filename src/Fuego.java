/**
 * Representa un hechizo del tipo Fuego con sus propias caracteristicas.
 * Su puntaje se calcula como: Daño multiplicado por DuracionQuemadura.
 */
public class Fuego extends Hechizo {
private int dur_Quemadura;
	
	/**
	 * Es el constructor que inicializa un hechizo de tipo Fuego, con sus respectivos parametros.
	 *
	 * @param nombreHechizo   el nombre del hechizo como String.
	 * @param tipo            el tipo elemental (que siempre sera "Fuego") como String.
	 * @param daño            el daño base del hechizo como entero.
	 * @param dur_Quemadura   duración en segundos de la quemadura que aplica el hechizo como entero.
	 */
	public Fuego(String nombreHechizo, String tipo, int daño,int dur_Quemadura) {
		super(nombreHechizo, tipo, daño);
		this.setDur_Quemadura(dur_Quemadura); 
}
	
	/**
     * Retorna como un entero la duración de la quemadura del hechizo .
     *
     * @return la duración en segundos como entero.
     */
	public int getDur_Quemadura() {
		return dur_Quemadura;
	}
	
	/**
     * Establece como entero la duración de la quemadura del hechizo.
     *
     * @param dur_Quemadura la nueva duración en segundos como int. 
     */
	public void setDur_Quemadura(int dur_Quemadura) {
		this.dur_Quemadura = dur_Quemadura;
	}
	
	/**
    * Calcula el puntaje del hechizo de Fuego.
    * aplica la formula: Daño multiplicado por DuracionQuemadura.
    *
    * @return el puntaje calculado como número decimal.
    */
	@Override
	public double calcularPuntaje() {
		double puntaje = getDaño()*getDur_Quemadura();
		return puntaje;

	}
	
	 /**
     * esta funcion genera el String necesario para guardar este hechizo en el archivo txt Hechizos.txt.
     *
     * @return String con el siguiente formato: NombreHechizo;Fuego;Daño;DuracionQuemadura
     */
	@Override
	public String almacenarDatos() {
		String datos = "" + getNombreHechizo() + ";" + getTipo() + ";" + getDaño() + ";" + dur_Quemadura;
		return datos;
	}

}
