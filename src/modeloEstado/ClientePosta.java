package modeloEstado;

public class ClientePosta implements Cliente {

	private Estado estado;
	private int puntos;
	private int creditoDisponible;
	
	private static final int PUNTOS_POR_PROMOCION = 15;
	private static final int MAXIMO_LIMITE_COMPRA = 1000;
	
	public ClientePosta() {
		estado = null;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public Estado getEstado() {
		return estado;
	}
	
	@Override
	public void comprar(int monto) {
		estado.comprar(monto, this);
	}

	@Override
	public void pagarVencimiento(int monto) {
		estado.pagarVencimiento(monto, this);
	}
	
	public void darPuntos(int cantidadDeVeces) {
		puntos += PUNTOS_POR_PROMOCION * cantidadDeVeces;
	}

	public int getMaximoLimiteCompra() {
		return MAXIMO_LIMITE_COMPRA;
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
