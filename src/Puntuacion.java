
/**
 *Interfaz que define el contrato de puntuación para los hechizos.
 *Toda clase que la implemente debe proveer su propia fórmula de cálculo.
 */

public interface Puntuacion {
	
/**
*Calcula el puntaje del hechizo según las reglas que implementa la clase que lo tiene.
*@return el puntaje calculado como número decimal.
*/
double calcularPuntaje();
}
