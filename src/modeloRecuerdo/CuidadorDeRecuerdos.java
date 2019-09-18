package modeloRecuerdo;

import java.util.ArrayList;
import java.util.List;

public class CuidadorDeRecuerdos {
	
	private List<Recuerdo> recuerdos = new ArrayList<Recuerdo>();
	
	public Recuerdo obtenerRecuerdo(int indice) {
		return recuerdos.get(indice);
	}
	
	public void agregarRecuerdo(Recuerdo recuerdo) {
		recuerdos.add(recuerdo);
	}

}
