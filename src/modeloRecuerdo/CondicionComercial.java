package modeloRecuerdo;

public class CondicionComercial {
	
	public void comprar(int monto, ClientePosta clientePosta) {
		clientePosta.disminuirCredito(monto);
	}
	
	public void pagarVencimiento(int monto, ClientePosta clientePosta) {
		
	}

}
