package modeloEstrategia;

public class ClientePosta implements Cliente {
	
	private static final int PUNTOS_PARA_PROMOCION = 15;
	private static final int MAXIMO_LIMITE_COMPRA = 1000;
	
	private Estrategia estrategia;
	private int puntos;
	private int creditoDisponible;
	
	public ClientePosta(Estrategia estrategia) {
		this.estrategia = estrategia;
	}

	public void setEstrategia(Estrategia estrategia) {
		this.estrategia = estrategia;
	}

	@Override
	public void comprar(int monto) {
		estrategia.comprar(monto, this);
	}

	@Override
	public void pagarVencimiento(int monto) {
		estrategia.pagarVencimiento(monto, this);
	}

	public void darPuntos() {
		puntos += PUNTOS_PARA_PROMOCION;
	}

	public void disminuirCredito(int monto) {
		creditoDisponible -= monto;
	}

	public int getMaximoLimiteCompra() {
		return MAXIMO_LIMITE_COMPRA;
	}

}
