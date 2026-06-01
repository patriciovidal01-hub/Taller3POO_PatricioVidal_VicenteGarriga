
public class Tierra extends Hechizo {
private int mejoraDefensa;
	

	public Tierra(String nombreHechizo, String tipo, int daño,int mejoraDefensa) {
		super(nombreHechizo, tipo, daño);
		this.setMejoraDefensa(mejoraDefensa);
	}
	

	public int getMejoraDefensa() {
		return mejoraDefensa;
	}
	
	
	public void setMejoraDefensa(int mejoraDefensa) {
		this.mejoraDefensa = mejoraDefensa;
	}
	
  

	public double calcularPuntaje() {
		double puntaje = ((getDaño()*getMejoraDefensa())/2);
		return puntaje;
	}
	

	public String almacenarDatos() {
		String datos = "" + getNombreHechizo() + ";" + getTipo() + ";" + getDaño() + ";" + mejoraDefensa;
		return datos;
	}
	
}
