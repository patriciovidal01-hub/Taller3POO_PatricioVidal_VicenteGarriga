/**
 * Interfaz que define la estructura básica de un menú de usuario.
 * Todo panel ( como la clase Administrador y Analista) debe implementar estos dos métodos.
 */
public interface Menu {
	 /**
     * Muestra en consola las opciones disponibles del menú.
     */
	public void mostrarOpciones();
	
	/**
     * Lee la opción ingresada por el usuario y ejecuta la lógica correspondiente en base al tipo de menu que lo aplica
     *
     * Contiene el ciclo principal del menú hasta que el usuario decida salir.
     */
	public void ejecutarOpcion(); 

}
