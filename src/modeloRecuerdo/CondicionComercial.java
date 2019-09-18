package modeloRecuerdo;

public class CondicionComercial {
	
	public void comprar(int monto, ClientePosta clientePosta) {
		if(estoyEnLaUltimaPosicion(clientePosta)) {
			clientePosta.disminuirCredito(monto);
		}
		
	}

	public boolean estoyEnLaUltimaPosicion(ClientePosta clientePosta) {
		return clientePosta.getCondiciones().lastIndexOf(this) == clientePosta.getCondiciones().size() - 1;
	}
	
	public void pagarVencimiento(int monto, ClientePosta clientePosta) {
		
	}

}
