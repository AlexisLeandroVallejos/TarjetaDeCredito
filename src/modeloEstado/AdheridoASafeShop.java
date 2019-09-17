package modeloEstado;

import exceptions.MaximoLimiteCompraException;

public class AdheridoASafeShop implements Estado {

	@Override
	public void adherirACondicionComercial(ClientePosta cliente) {
		cliente.setEstado(this);
	}

	@Override
	public void comprar(int monto, ClientePosta cliente) {
		if(esMontoMayorAlLimiteMaximoDeCompra(monto, cliente)) {
			throw new MaximoLimiteCompraException();
		}
		cliente.disminuirCredito(monto);
	}

	public boolean esMontoMayorAlLimiteMaximoDeCompra(int monto, ClientePosta cliente) {
		return monto >= cliente.getMaximoLimiteCompra();
	}

	@Override
	public void pagarVencimiento(int monto, ClientePosta cliente) {
		// TODO Auto-generated method stub
		
	}

}
