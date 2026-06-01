
public class Fuego extends Hechizo {
private int dur_Quemadura;
	

	public Fuego(String nombreHechizo, String tipo, int daño,int dur_Quemadura) {
		super(nombreHechizo, tipo, daño);
		this.setDur_Quemadura(dur_Quemadura); 
}
	
	public int getDur_Quemadura() {
		return dur_Quemadura;
	}
	
	
	public void setDur_Quemadura(int dur_Quemadura) {
		this.dur_Quemadura = dur_Quemadura;
	}

	public double calcularPuntaje() {
		double puntaje = getDaño()*getDur_Quemadura();
		return puntaje;

	}
	
	
	public String almacenarDatos() {
		String datos = "" + getNombreHechizo() + ";" + getTipo() + ";" + getDaño() + ";" + dur_Quemadura;
		return datos;
	}

}
