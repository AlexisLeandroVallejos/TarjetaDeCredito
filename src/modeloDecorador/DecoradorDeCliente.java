package modeloDecorador;

public class DecoradorDeCliente implements Cliente {
	
	private Cliente cliente;
	
	public DecoradorDeCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Override
	public void comprar(int monto) {
		cliente.comprar(monto);
	}

	@Override
	public void pagarVencimiento(int monto) {
		cliente.pagarVencimiento(monto);
	}

	@Override
	public void setCreditoDisponible(int creditoDisponible) {
		cliente.setCreditoDisponible(creditoDisponible);
	}

	@Override
	public int getCreditoDisponible() {
		return cliente.getCreditoDisponible();
	}

	@Override
	public void darPuntos(int cantidadDeVeces) {
		cliente.darPuntos(cantidadDeVeces);
	}

	@Override
	public int getPuntos() {
		return cliente.getPuntos();
	}

}
