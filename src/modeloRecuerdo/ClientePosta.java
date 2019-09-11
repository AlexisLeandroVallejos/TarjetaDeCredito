package modeloRecuerdo;

import java.util.ArrayList;
import java.util.List;

public class ClientePosta implements Cliente {
	
	private static final int MAXIMO_LIMITE_COMPRA = 1000;
	private int puntos;
	private int creditoDisponible;
	
	private List<CondicionRecuerdo> recuerdos = new ArrayList<CondicionRecuerdo>();
	
	public void agregar(CondicionRecuerdo recuerdo) {
		recuerdos.add(recuerdo);
	}
	
	public CondicionRecuerdo obtener(int lugar) {
		return recuerdos.get(lugar);
	}
	
	@Override
	public void comprar(int monto) {
		recuerdos.forEach(recuerdo -> recuerdo.comprar(monto, this));
	}

	@Override
	public void pagarVencimiento(int monto) {
		// TODO Auto-generated method stub
	}

	public int getMaximoLimiteCompra() {
		return MAXIMO_LIMITE_COMPRA;
	}

	public void darPuntos() {
		puntos += 15;
	}

	public void disminuirCredito(int monto) {
		creditoDisponible -= monto;
	}

}
