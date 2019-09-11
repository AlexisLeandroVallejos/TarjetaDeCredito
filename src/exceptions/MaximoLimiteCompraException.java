package exceptions;

public class MaximoLimiteCompraException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MaximoLimiteCompraException() {
		super("Ha sobrepasado el maximo de dinero permitido para esta compra.");
	}

}
