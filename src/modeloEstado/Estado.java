package modeloEstado;

public interface Estado {
	public void adherirACondicionComercial(ClientePosta cliente);
	public void comprar(int monto, ClientePosta clientePosta);
	public void pagarVencimiento(int monto, ClientePosta clientePosta);
}
