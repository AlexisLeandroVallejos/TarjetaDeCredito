package modeloEstrategia;

public interface Estrategia {
	public void comprar(int monto, ClientePosta clientePosta);
	public void pagarVencimiento(int monto, ClientePosta clientePosta);
}
