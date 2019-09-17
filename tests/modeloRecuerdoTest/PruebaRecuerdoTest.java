package modeloRecuerdoTest;

import org.junit.Assert;

import modeloRecuerdo.*;

public class PruebaRecuerdoTest {
	
	public void comprar_UnClientePostaTieneCondicionPromocionCompra50YObtienePuntos() {
		ClientePosta cliente = new ClientePosta();
		cliente.agregar(new CondicionPromocion(cliente));
		//cliente.agregar(new CondicionSafeShop(cliente));
		cliente.comprar(50);
		cliente.obtener(0).getEstado();
		Assert.assertEquals("No obtuvo puntos", cliente.getPuntos(), cliente.obtener(0).getEstado().getPuntos());
	}

}
