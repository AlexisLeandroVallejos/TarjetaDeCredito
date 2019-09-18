package modeloRecuerdo;

import java.util.ArrayList;
import java.util.List;

public class Recuerdo {
	
	private int puntos;
	private int creditoDisponible;
	//private List<CondicionComercial> condiciones_ = new ArrayList<CondicionComercial>();
	//Este es igual al clienteposta en identidad, asi que se guarda lo mismo.
	
	public Recuerdo(int puntos, int creditoDisponible) {
		this.puntos = puntos;
		this.creditoDisponible = creditoDisponible;
	}

	public int getPuntos() {
		return puntos;
	}

	public int getCreditoDisponible() {
		return creditoDisponible;
	}
	
	
}
