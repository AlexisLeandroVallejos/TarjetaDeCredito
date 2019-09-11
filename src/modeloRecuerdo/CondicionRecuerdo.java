package modeloRecuerdo;

public class CondicionRecuerdo {
	private ClientePosta cliente;
	
	public CondicionRecuerdo(ClientePosta cliente) {
		this.cliente = cliente;
	}
	
	public ClientePosta getEstado() {
		return cliente;
	}

	public void comprar(int monto, ClientePosta clientePosta) {
		clientePosta.disminuirCredito(monto);
	}
	
	public void pagarVencimiento(int monto, ClientePosta clientePosta) {
		
	}
}
