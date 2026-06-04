/**
 * representa un hechizo de tipo Tierra con sus propias caracteristicas.
 * su puntaje se calcula como: (Daño multiplicado por MejoraDefensa) dividido en 2.
 */
public class Tierra extends Hechizo {
private int mejoraDefensa;
	
	/**
	 * constructor que inicializa un hechizo de tipo Tierra con sus respectivos parametros.
	 *
	 * @param nombreHechizo el nombre del hechizo como String.
	 * @param tipo          el tipo elemental como String (siempre sera del tipo "Tierra").
	 * @param daño          el daño base del hechizo como entero.
	 * @param mejoraDefensa el valor de mejora de defensa que otorga el hechizo como entero.
	 */
	public Tierra(String nombreHechizo, String tipo, int daño,int mejoraDefensa) {
		super(nombreHechizo, tipo, daño);
		this.setMejoraDefensa(mejoraDefensa);
	}
	
	/**
     * retorna el valor de mejora de defensa del hechizo como entero.
     *
     * @return mejoraDefensa como entero.
     */
	public int getMejoraDefensa() {
		return mejoraDefensa;
	}
	
	/**
     * establece el valor de mejora de defensa del hechizo como entero.
     *
     * @param mejoraDefensa el nuevo valor de mejora de defensa.
     */
	public void setMejoraDefensa(int mejoraDefensa) {
		this.mejoraDefensa = mejoraDefensa;
	}
	
    /**
     * calcula el puntaje del hechizo de Tierra.
     * aplica la formula: (Daño multiplicado por MejoraDefensa) dividido en 2.
     *
     * @return el puntaje calculado como número decimal.
     */

	@Override
	public double calcularPuntaje() {
		double puntaje = ((getDaño()*getMejoraDefensa())/2);
		return puntaje;
	}
	/**
     * esta funcion genera el String necesario para guardar este hechizo en el archivo txt Hechizos.txt.
     *
     * @return String con formato: NombreHechizo;Tierra;Daño;MejoraDefensa
     */
	@Override
	public String almacenarDatos() {
		String datos = "" + getNombreHechizo() + ";" + getTipo() + ";" + getDaño() + ";" + mejoraDefensa;
		return datos;
	}
}
