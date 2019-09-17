package modeloEstrategia;

import exceptions.MaximoLimiteCompraException;

public class PromocionYSafeShop implements Estrategia {
	
	private static final int MONTO_PARA_PROMOCION = 50; 

	@Override
	public void comprar(int monto, ClientePosta clientePosta) {
		if(esMontoMayorAlLimiteMaximoDeCompra(monto, clientePosta)) {
			throw new MaximoLimiteCompraException();
		}
		if(esMontoMayorA(monto)) {
			clientePosta.darPuntos(monto/MONTO_PARA_PROMOCION);
		}
		clientePosta.disminuirCredito(monto);
	}

	public boolean esMontoMayorAlLimiteMaximoDeCompra(int monto, ClientePosta clientePosta) {
		return monto >= clientePosta.getMaximoLimiteCompra();
	}

	public boolean esMontoMayorA(int monto) {
		return monto >= MONTO_PARA_PROMOCION;
	}

	@Override
	public void pagarVencimiento(int monto, ClientePosta clientePosta) {
		// TODO Auto-generated method stub
		
	}

	

}
