package modeloDecorador;

public class DecoradorDeClienteConPromocion extends DecoradorDeCliente {
	private static final int PUNTOS_POR_PROMOCION = 15;
	private static final int MONTO_PARA_PROMOCION = 50;
	
	private int puntos;

	public DecoradorDeClienteConPromocion(Cliente cliente) {
		super(cliente);
	}
	
	@Override
	public void comprar(int monto) {
		if(esMontoMayorA(monto)) {
			this.darPuntos(monto/MONTO_PARA_PROMOCION);
		}
		super.comprar(monto);
	}
	
	@Override
	public void darPuntos(int cantidadDeVeces) {
		puntos += PUNTOS_POR_PROMOCION * cantidadDeVeces;
		
	}
	
	@Override
	public int getPuntos() {
		return puntos;
	}
	
	public boolean esMontoMayorA(int monto) {
		return monto >= MONTO_PARA_PROMOCION;
	}

}
