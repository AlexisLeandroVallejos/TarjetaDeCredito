package modeloDecorador;

public class ClientePosta implements Cliente {
	private int creditoDisponible;

	@Override
	public void comprar(int monto) {
		creditoDisponible -= monto;
	}

	@Override
	public void pagarVencimiento(int monto) {
		// TODO Auto-generated method stub

	}

	public int getCreditoDisponible() {
		return creditoDisponible;
	}

	public void setCreditoDisponible(int creditoDisponible) {
		this.creditoDisponible = creditoDisponible;
	}

	@Override
	public void darPuntos(int cantidadDeVeces) {
		//no se encarga de esto.
	}

	@Override
	public int getPuntos() {
		return 0;
	}

}
