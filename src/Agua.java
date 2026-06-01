
public class Agua extends Hechizo {
private int cantCuracion;
private int presionAgua;


	public Agua(String nombreHechizo, String tipo, int daño,int cantCuracion,int presionAgua) {
		super(nombreHechizo, tipo, daño);
		this.setCantCuracion(cantCuracion);
		this.setPresionAgua(presionAgua);
	}
	

	public int getCantCuracion() {
		return cantCuracion;
	}
	
	
	public void setCantCuracion(int cantCuracion) {
		this.cantCuracion = cantCuracion;
	}
	
	
	public int getPresionAgua() {
		return presionAgua;
	}
	
  
	public void setPresionAgua(int presionAgua) {
		this.presionAgua = presionAgua;
	}


}
