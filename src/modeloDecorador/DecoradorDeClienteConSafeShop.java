package modeloDecorador;

import exceptions.MaximoLimiteCompraException;

public class DecoradorDeClienteConSafeShop extends DecoradorDeCliente {
	
	private static final int MAXIMO_LIMITE_COMPRA = 1000;

	public DecoradorDeClienteConSafeShop(Cliente cliente) {
		super(cliente);
	}
	
	@Override
	public void comprar(int monto) {
		if(esMontoMayorAlLimiteMaximoDeCompra(monto)) {
			throw new MaximoLimiteCompraException();
		}
		super.comprar(monto);
	}

	public int getMaximoLimiteCompra() {
		return MAXIMO_LIMITE_COMPRA;
	}
	
	public boolean esMontoMayorAlLimiteMaximoDeCompra(int monto) {
		return monto >= this.getMaximoLimiteCompra();
	}
	
}
