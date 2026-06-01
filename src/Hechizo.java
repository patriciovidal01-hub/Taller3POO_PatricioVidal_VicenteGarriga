
abstract class Hechizo implements Puntuacion{
private String nombreHechizo;
private String tipo;
private int daño;


	public Hechizo(String nombreHechizo, String tipo, int daño) {
		this.setNombreHechizo(nombreHechizo);
		this.setTipo(tipo);
		this.setDaño(daño);
	
	}

	

	public int getDaño() {
		return daño;
	}
	
	public void setDaño(int daño) {
		this.daño = daño;
	}
	
	
	public String getNombreHechizo() {
		return nombreHechizo;
	}
	
	
	public void setNombreHechizo(String nombreHechizo) {
		this.nombreHechizo = nombreHechizo;
	}

	
	public String getTipo() {
		return tipo;
	}
	
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public abstract double calcularPuntaje();

}
