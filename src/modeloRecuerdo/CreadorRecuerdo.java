package modeloRecuerdo;

public class CreadorRecuerdo {
	private ClientePosta cliente;
	
	public void setEstado(ClientePosta cliente) {
		this.cliente = cliente;
	}
	
	public ClientePosta getEstado() {
		return cliente;
	}

	public CondicionRecuerdo guardarEstadoARecuerdo() {
		return new CondicionRecuerdo(cliente);
	}
	
	public void obtenerEstadoDelRecuerdo(CondicionRecuerdo recuerdo) {
		cliente = recuerdo.getEstado();
	}
}
