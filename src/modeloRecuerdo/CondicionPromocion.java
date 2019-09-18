package modeloRecuerdo;

public class CondicionPromocion extends CondicionComercial {
	
	private static final int MONTO_PARA_PROMOCION = 50;
	
	public void comprar(int monto, ClientePosta clientePosta) {
		if(esMontoMayorA(monto)) {
			clientePosta.darPuntos(monto/MONTO_PARA_PROMOCION);
		}
		super.comprar(monto, clientePosta);
		
	}

	public boolean esMontoMayorA(int monto) {
		return monto >= MONTO_PARA_PROMOCION;
	}
	
}
