
public class Planta extends Hechizo {
private int cantStun;
private int cantPlantas;


	public Planta(String nombreHechizo, String tipo, int daño,int cantStun,int cantPlantas) {
		super(nombreHechizo, tipo, daño);
		this.setCantStun(cantStun);
		this.setCantPlantas(cantPlantas);
	}

	public int getCantStun() {
		return cantStun;
	}

  
	public void setCantStun(int cantStun) {
		this.cantStun = cantStun;
	}

	public int getCantPlantas() {
		return cantPlantas;
	}

	
	public void setCantPlantas(int cantPlantas) {
		this.cantPlantas = cantPlantas;
	}
	



}
