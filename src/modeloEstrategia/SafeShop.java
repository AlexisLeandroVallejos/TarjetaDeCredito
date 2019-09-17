package modeloEstrategia;

import exceptions.MaximoLimiteCompraException;

public class SafeShop implements Estrategia {

	@Override
	public void comprar(int monto, ClientePosta clientePosta) {
		if(esMontoMayorAlLimiteMaximoDeCompra(monto, clientePosta)) {
			throw new MaximoLimiteCompraException();
		}
		clientePosta.disminuirCredito(monto);
	}

	public boolean esMontoMayorAlLimiteMaximoDeCompra(int monto, ClientePosta clientePosta) {
		return monto >= clientePosta.getMaximoLimiteCompra();
	}

	@Override
	public void pagarVencimiento(int monto, ClientePosta clientePosta) {
		// TODO Auto-generated method stub
		
	}

	

}
