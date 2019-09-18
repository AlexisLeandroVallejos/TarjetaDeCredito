package modeloRecuerdo;

import exceptions.MaximoLimiteCompraException;

public class CondicionSafeShop extends CondicionComercial {

	public void comprar(int monto, ClientePosta clientePosta) {
		try {
		if(esMontoMayorAMaximoLimiteCompra(monto, clientePosta)) {
			throw new MaximoLimiteCompraException();
		}
		super.comprar(monto, clientePosta);
		} catch (Exception e) {
			clientePosta.deshacerClienteEnRecuerdo(clientePosta.getCuidador().recuperacionAnteProteccionSafeShop());
		}
	}

	public boolean esMontoMayorAMaximoLimiteCompra(int monto, ClientePosta clientePosta) {
		return monto >= clientePosta.getMaximoLimiteCompra();
	}
}
