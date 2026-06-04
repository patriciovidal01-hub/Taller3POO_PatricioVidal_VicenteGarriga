/**
 * Representa un hechizo de tipo Planta con sus propias caracteristicas.
 * Su puntaje se calcula como: Daño + (DuracionStun multiplicado por CantPlantas).
 */
public class Planta extends Hechizo {
private int cantStun;
private int cantPlantas;

	/**
	 * es el constructor que inicializa un hechizo de tipo Planta con sus respectivos parametros.
	 *
	 * @param nombreHechizo el nombre del hechizo como String.
	 * @param tipo          el tipo elemental (que siempre sera "Planta") como String.
	 * @param daño          el daño base del hechizo como entero.
	 * @param cantStun      la duración en segundos del efecto de stun que aplica como entero.
	 * @param cantPlantas   la cantidad de plantas invocadas por el hechizo como entero.
	 */
	public Planta(String nombreHechizo, String tipo, int daño,int cantStun,int cantPlantas) {
		super(nombreHechizo, tipo, daño);
		this.setCantStun(cantStun);
		this.setCantPlantas(cantPlantas);
	}
	
    /**
     * retorna la duración del stun del hechizo.
     *
     * @return la duración del stun en segundos como entero.
     */
	public int getCantStun() {
		return cantStun;
	}

    /**
     * esta funcion establece la duración del stun del hechizo.
     *
     * @param cantStun la nueva duración del stun en segundos como entero.
     */
	public void setCantStun(int cantStun) {
		this.cantStun = cantStun;
	}
	
	 /**
     * retorna la cantidad de plantas que invoca el hechizo.
     *
     * @return la cantidad de plantas como entero.
     */
	public int getCantPlantas() {
		return cantPlantas;
	}

	/**
     * Establece la cantidad de plantas que invoca el hechizo.
     *
     * @param cantPlantas la nueva cantidad de plantas.
     */
	public void setCantPlantas(int cantPlantas) {
		this.cantPlantas = cantPlantas;
	}
	
	/**
     * Calcula el puntaje del hechizo de Planta como decimal.
     * aplica la formula: Daño + (DuracionStun multiplicado por CantPlantas).
     *
     * @return el puntaje calculado como número decimal.
     */
  
	@Override
	public double calcularPuntaje() {
		double puntaje =  (getDaño() + getCantStun() * getCantPlantas());
		return puntaje;

	}

	/**
     * esta funcion genera el String necesario para guardar este hechizo en el archivo txt Hechizos.txt.
     *
     * @return String con el siguiente formato: NombreHechizo;Planta;Daño;CantStun,CantPlantas
     */
	
	@Override
	public String almacenarDatos() {
		String datos = "" + getNombreHechizo() + ";" + getTipo() + ";" + getDaño() + ";" + cantStun + "," + cantPlantas;
		return datos;
	}

}
