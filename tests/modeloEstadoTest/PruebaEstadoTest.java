package modeloEstadoTest;

import org.junit.Assert;
import org.junit.Test;

import exceptions.MaximoLimiteCompraException;
import modeloEstado.*;

public class PruebaEstadoTest {
	
	@Test(expected=MaximoLimiteCompraException.class)
	public void comprar_UnClientePostaAdheridoASafeShopCompraAlgoQueVale1000YSeTiraException() {
		//creo clases.
		AdheridoASafeShop adheridoASafeShop = new AdheridoASafeShop();
		ClientePosta cliente = new ClientePosta();
		//adhiero al cliente a safeshop
		adheridoASafeShop.adherirACondicionComercial(cliente);
		//agrego atributos al cliente
		cliente.setCreditoDisponible(2000);
		cliente.comprar(1000);
	}
	
	@Test
	public void comprar_UnClientePostaAdheridoASafeShopCompraAlgoQueVale999YSeDescuentaCredito() {
		//creo clases.
		AdheridoASafeShop adheridoASafeShop = new AdheridoASafeShop();
		ClientePosta cliente = new ClientePosta();
		//adhiero al cliente a safeshop
		adheridoASafeShop.adherirACondicionComercial(cliente);
		//agrego atributos al cliente
		cliente.setCreditoDisponible(2000);
		cliente.comprar(999);
		Assert.assertEquals("No se desconto credito", 2000-999, cliente.getCreditoDisponible());
	}
}
