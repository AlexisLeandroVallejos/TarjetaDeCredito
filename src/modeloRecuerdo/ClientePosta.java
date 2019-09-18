package modeloRecuerdo;

import java.util.ArrayList;
import java.util.List;

public class ClientePosta implements Cliente {
	
	//Este seria mi Originator/Creador de recuerdos.
	
	private static final int PUNTOS_PARA_PROMOCION = 15;
	private static final int MAXIMO_LIMITE_COMPRA = 1000;
	
	private int puntos;
	private int creditoDisponible;
	private List<CondicionComercial> condiciones = new ArrayList<CondicionComercial>();
	
	public Recuerdo guardarClienteEnRecuerdo() {
		return new Recuerdo(this.puntos, this.creditoDisponible);
	}
	
	public void deshacerClienteEnRecuerdo(Recuerdo recuerdo) {
		this.puntos = recuerdo.getPuntos();
		this.creditoDisponible = recuerdo.getCreditoDisponible();
	}
	
	public void agregarCondicionComercial(CondicionComercial condicion) {
		condiciones.add(condicion);
	}
	
	@Override
	public void comprar(int monto) {
		condiciones.forEach(condicion -> condicion.comprar(monto, this));
	}

	@Override
	public void pagarVencimiento(int monto) {
		// TODO Auto-generated method stub
	}

	public int getMaximoLimiteCompra() {
		return MAXIMO_LIMITE_COMPRA;
	}

	public void darPuntos(int cantidadDeVeces) {
		puntos += PUNTOS_PARA_PROMOCION * cantidadDeVeces;
	}

	public void disminuirCredito(int monto) {
		creditoDisponible -= monto;
	}

	public int getCreditoDisponible() {
		return creditoDisponible;
	}

	public void setCreditoDisponible(int creditoDisponible) {
		this.creditoDisponible = creditoDisponible;
	}

	public int getPuntos() {
		return puntos;
	}

}
