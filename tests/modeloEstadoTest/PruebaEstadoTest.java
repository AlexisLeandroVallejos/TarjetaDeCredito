package modeloEstadoTest;

import org.junit.Assert;
import org.junit.Test;

import exceptions.MaximoLimiteCompraException;
import modeloEstado.*;

public class PruebaEstadoTest {
	
	@Test(expected=MaximoLimiteCompraException.class)
	public void comprar_UnClientePostaAdheridoASafeShopCompraAlgoQueVale1000YTiraError() {
		//creo clases.
		AdheridoASafeShop adheridoASafeShop = new AdheridoASafeShop();
		ClientePosta cliente = new ClientePosta();
		//adhiero al cliente
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
		//adhiero al cliente
		adheridoASafeShop.adherirACondicionComercial(cliente);
		//agrego atributos al cliente
		cliente.setCreditoDisponible(2000);
		cliente.comprar(999);
		Assert.assertEquals("No se desconto credito", 2000-999, cliente.getCreditoDisponible());
	}
	
	@Test
	public void comprar_UnClientePostaAdheridoAPromocionCompraAlgoQueVale50YSeAgreganPuntos() {
		//creo clases.
		AdheridoAPromocion adheridoAPromocion = new AdheridoAPromocion();
		ClientePosta cliente = new ClientePosta();
		//adhiero al cliente
		adheridoAPromocion.adherirACondicionComercial(cliente);
		//agrego atributos al cliente
		cliente.setCreditoDisponible(2000);
		cliente.comprar(50);
		Assert.assertEquals("No se sumaron puntos", 15, cliente.getPuntos());
	}
	
	@Test
	public void comprar_UnClientePostaAdheridoAPromocionCompraAlgoQueVale100YSeAgregaElDobleDePuntosQueCon50DeCompra() {
		//creo clases.
		AdheridoAPromocion adheridoAPromocion = new AdheridoAPromocion();
		ClientePosta cliente = new ClientePosta();
		//adhiero al cliente
		adheridoAPromocion.adherirACondicionComercial(cliente);
		//agrego atributos al cliente
		cliente.setCreditoDisponible(2000);
		cliente.comprar(100);
		Assert.assertEquals("No se sumaron puntos", 30, cliente.getPuntos());
	}
	
	@Test
	public void comprar_UnClientePostaAdheridoAPromocionCompraAlgoQueVale49YNoSeAgreganPuntos() {
		//creo clases.
		AdheridoAPromocion adheridoAPromocion = new AdheridoAPromocion();
		ClientePosta cliente = new ClientePosta();
		//adhiero al cliente
		adheridoAPromocion.adherirACondicionComercial(cliente);
		//agrego atributos al cliente
		cliente.setCreditoDisponible(2000);
		cliente.comprar(49);
		Assert.assertEquals("Se sumaron puntos", 0, cliente.getPuntos());
	}
	
	@Test
	public void comprar_UnClientePostaAdheridoAPromocionCompraAlgoQueVale49YSeDescuentaCredito() {
		//creo clases.
		AdheridoAPromocion adheridoAPromocion = new AdheridoAPromocion();
		ClientePosta cliente = new ClientePosta();
		//adhiero al cliente
		adheridoAPromocion.adherirACondicionComercial(cliente);
		//agrego atributos al cliente
		cliente.setCreditoDisponible(2000);
		cliente.comprar(49);
		Assert.assertEquals("No se desconto credito", 2000-49, cliente.getCreditoDisponible());
	}
	
	@Test
	public void comprar_UnClientePostaAdheridoAPromocionYSafeShopCompraAlgoQueVale49YNoSeAgreganPuntos() {
		//creo clases.
		AdheridoAPromocionYSafeShop adheridoAPromocionYSafeShop = new AdheridoAPromocionYSafeShop();
		ClientePosta cliente = new ClientePosta();
		//adhiero al cliente
		adheridoAPromocionYSafeShop.adherirACondicionComercial(cliente);
		//agrego atributos al cliente
		cliente.setCreditoDisponible(2000);
		cliente.comprar(49);
		Assert.assertEquals("Se sumaron puntos", 0, cliente.getPuntos());
	}
	
	@Test
	public void comprar_UnClientePostaAdheridoAPromocionYSafeShopCompraAlgoQueVale50YSeAgreganPuntos() {
		//creo clases.
		AdheridoAPromocionYSafeShop adheridoAPromocionYSafeShop = new AdheridoAPromocionYSafeShop();
		ClientePosta cliente = new ClientePosta();
		//adhiero al cliente
		adheridoAPromocionYSafeShop.adherirACondicionComercial(cliente);
		//agrego atributos al cliente
		cliente.setCreditoDisponible(2000);
		cliente.comprar(50);
		Assert.assertEquals("No se sumaron puntos", 15, cliente.getPuntos());
	}
	
	@Test
	public void comprar_UnClientePostaAdheridoAPromocionYSafeShopCompraAlgoQueVale100YSeAgreganElDobleDePuntosQueCon50() {
		//creo clases.
		AdheridoAPromocionYSafeShop adheridoAPromocionYSafeShop = new AdheridoAPromocionYSafeShop();
		ClientePosta cliente = new ClientePosta();
		//adhiero al cliente
		adheridoAPromocionYSafeShop.adherirACondicionComercial(cliente);
		//agrego atributos al cliente
		cliente.setCreditoDisponible(2000);
		cliente.comprar(100);
		Assert.assertEquals("No se sumaron puntos", 30, cliente.getPuntos());
	}
	
	@Test
	public void comprar_UnClientePostaAdheridoAPromocionYSafeShopCompraAlgoQueVale49YSeDescuentaCredito() {
		//creo clases.
		AdheridoAPromocionYSafeShop adheridoAPromocionYSafeShop = new AdheridoAPromocionYSafeShop();
		ClientePosta cliente = new ClientePosta();
		//adhiero al cliente
		adheridoAPromocionYSafeShop.adherirACondicionComercial(cliente);
		//agrego atributos al cliente
		cliente.setCreditoDisponible(2000);
		cliente.comprar(49);
		Assert.assertEquals("No se desconto credito", 2000-49, cliente.getCreditoDisponible());
	}
	
	@Test(expected=MaximoLimiteCompraException.class)
	public void comprar_UnClientePostaAdheridoAPromocionYSafeShopCompraAlgoQueVale1000YTiraError() {
		//creo clases.
		AdheridoAPromocionYSafeShop adheridoAPromocionYSafeShop = new AdheridoAPromocionYSafeShop();
		ClientePosta cliente = new ClientePosta();
		//adhiero al cliente
		adheridoAPromocionYSafeShop.adherirACondicionComercial(cliente);
		//agrego atributos al cliente
		cliente.setCreditoDisponible(2000);
		cliente.comprar(1000);
	}
	
	@Test
	public void comprar_UnClientePostaAdheridoAPromocionYSafeShopCompraAlgoQueVale999YSeDescuentaCredito() {
		//creo clases.
		AdheridoAPromocionYSafeShop adheridoAPromocionYSafeShop = new AdheridoAPromocionYSafeShop();
		ClientePosta cliente = new ClientePosta();
		//adhiero al cliente
		adheridoAPromocionYSafeShop.adherirACondicionComercial(cliente);
		//agrego atributos al cliente
		cliente.setCreditoDisponible(2000);
		cliente.comprar(999);
		Assert.assertEquals("No se desconto credito", 2000-999, cliente.getCreditoDisponible());
	}
	
	
}
