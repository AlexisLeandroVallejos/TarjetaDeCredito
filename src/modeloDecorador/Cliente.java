package modeloDecorador;

public interface Cliente {
	public void comprar(int monto);
	public void pagarVencimiento(int monto);
	public void setCreditoDisponible(int creditoDisponible);
	public int getCreditoDisponible();
	public int getPuntos();
	public void darPuntos(int cantidadDeVeces);

}
