package modeloEstado;

import exceptions.MaximoLimiteCompraException;

public class AdheridoAPromocionYSafeShop implements Estado {

	private static final int MONTO_PARA_PROMOCION = 50;
	
	@Override
	public void adherirACondicionComercial(ClientePosta cliente) {
		cliente.setEstado(this);
	}

	@Override
	public void comprar(int monto, ClientePosta cliente) {
		if(esMontoMayorAlLimiteMaximoDeCompra(monto, cliente)) {
			throw new MaximoLimiteCompraException();
		}
		if(esMontoMayorA(monto)) {
			cliente.darPuntos(monto/MONTO_PARA_PROMOCION);
		}
		cliente.disminuirCredito(monto);
	}

	public boolean esMontoMayorAlLimiteMaximoDeCompra(int monto, ClientePosta cliente) {
		return monto >= cliente.getMaximoLimiteCompra();
	}

	public boolean esMontoMayorA(int monto) {
		return monto >= MONTO_PARA_PROMOCION;
	}

	@Override
	public void pagarVencimiento(int monto, ClientePosta cliente) {
		// TODO Auto-generated method stub
		
	}

}
