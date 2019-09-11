package modeloEstrategia;

public class Promocion implements Estrategia {
	
	private static final int MONTO_PARA_PROMOCION = 50; 

	@Override
	public void comprar(int monto, ClientePosta clientePosta) {
		if(esMontoMayorA(monto)) {
			clientePosta.darPuntos();
		}
		clientePosta.disminuirCredito(monto);
	}

	public boolean esMontoMayorA(int monto) {
		return monto > MONTO_PARA_PROMOCION;
	}

	@Override
	public void pagarVencimiento(int monto, ClientePosta clientePosta) {
		// TODO Auto-generated method stub
		
	}

	

}
