package modeloRecuerdo;

import exceptions.MaximoLimiteCompraException;

public class CondicionSafeShop extends CondicionRecuerdo {
	
	public CondicionSafeShop(ClientePosta clientePosta) {
		super(clientePosta);
	}

	public void comprar(int monto, ClientePosta clientePosta) {
		if(esMontoMayorAMaximoLimiteCompra(monto, clientePosta)) {
			throw new MaximoLimiteCompraException();
		}
		super.comprar(monto, clientePosta);
	}

	public boolean esMontoMayorAMaximoLimiteCompra(int monto, ClientePosta clientePosta) {
		return monto >= clientePosta.getMaximoLimiteCompra();
	}
}
