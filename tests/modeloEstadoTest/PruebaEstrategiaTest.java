package modeloEstadoTest;

import org.junit.Assert;
import org.junit.Test;

import exceptions.MaximoLimiteCompraException;
import modeloEstrategia.*;

public class PruebaEstrategiaTest {
	
	@Test(expected=MaximoLimiteCompraException.class)
	public void comprar_UnClientePostaConSafeShopCompraAlgoQueVale1000YTiraError() {
		//creo clases.
		SafeShop safeShop = new SafeShop();
		ClientePosta cliente = new ClientePosta(safeShop);
		//agrego atributos al cliente
		cliente.setCreditoDisponible(2000);
		cliente.comprar(1000);
	}
	
	@Test
	public void comprar_UnClientePostaConSafeShopCompraAlgoQueVale999YSeDescuentaCredito() {
		//creo clases.
		SafeShop safeShop = new SafeShop();
		ClientePosta cliente = new ClientePosta(safeShop);
		//agrego atributos al cliente
		cliente.setCreditoDisponible(2000);
		cliente.comprar(999);
		Assert.assertEquals("No se desconto credito", 2000-999, cliente.getCreditoDisponible());
	}
	
	@Test
	public void comprar_UnClientePostaConPromocionCompraAlgoQueVale50YSeAgreganPuntos() {
		//creo clases.
		Promocion promocion = new Promocion();
		ClientePosta cliente = new ClientePosta(promocion);
		//agrego atributos al cliente
		cliente.setCreditoDisponible(2000);
		cliente.comprar(50);
		Assert.assertEquals("No se sumaron puntos", 15, cliente.getPuntos());
	}
	
	@Test
	public void comprar_UnClientePostaConPromocionCompraAlgoQueVale100YSeAgregaElDobleDePuntosQueCon50DeCompra() {
		//creo clases.
		Promocion promocion = new Promocion();
		ClientePosta cliente = new ClientePosta(promocion);
		//agrego atributos al cliente
		cliente.setCreditoDisponible(2000);
		cliente.comprar(100);
		Assert.assertEquals("No se sumaron puntos", 30, cliente.getPuntos());
	}
	
	@Test
	public void comprar_UnClientePostaConPromocionCompraAlgoQueVale49YNoSeAgreganPuntos() {
		//creo clases.
		Promocion promocion = new Promocion();
		ClientePosta cliente = new ClientePosta(promocion);
		//agrego atributos al cliente
		cliente.setCreditoDisponible(2000);
		cliente.comprar(49);
		Assert.assertEquals("No se sumaron puntos", 0, cliente.getPuntos());
	}
	
	@Test
	public void comprar_UnClientePostaConPromocionCompraAlgoQueVale49YSeDescuentaCredito() {
		//creo clases.
		Promocion promocion = new Promocion();
		ClientePosta cliente = new ClientePosta(promocion);
		//agrego atributos al cliente
		cliente.setCreditoDisponible(2000);
		cliente.comprar(49);
		Assert.assertEquals("No se sumaron puntos", 2000-49, cliente.getCreditoDisponible());
	}
	
	@Test
	public void comprar_UnClientePostaConPromocionYSafeShopCompraAlgoQueVale49YNoSeAgreganPuntos() {
		//creo clases.
		PromocionYSafeShop promocionYSafeShop = new PromocionYSafeShop();
		ClientePosta cliente = new ClientePosta(promocionYSafeShop);
		//agrego atributos al cliente
		cliente.setCreditoDisponible(2000);
		cliente.comprar(49);
		Assert.assertEquals("No se sumaron puntos", 0, cliente.getPuntos());
	}
	
	@Test
	public void comprar_UnClientePostaConPromocionYSafeShopCompraAlgoQueVale50YSeAgreganPuntos() {
		//creo clases.
		PromocionYSafeShop promocionYSafeShop = new PromocionYSafeShop();
		ClientePosta cliente = new ClientePosta(promocionYSafeShop);
		//agrego atributos al cliente
		cliente.setCreditoDisponible(2000);
		cliente.comprar(50);
		Assert.assertEquals("No se sumaron puntos", 15, cliente.getPuntos());
	}
	
	@Test
	public void comprar_UnClientePostaConPromocionYSafeShopCompraAlgoQueVale100YSeAgreganElDobleDePuntosQueCon50() {
		//creo clases.
		PromocionYSafeShop promocionYSafeShop = new PromocionYSafeShop();
		ClientePosta cliente = new ClientePosta(promocionYSafeShop);
		//agrego atributos al cliente
		cliente.setCreditoDisponible(2000);
		cliente.comprar(100);
		Assert.assertEquals("No se sumaron puntos", 30, cliente.getPuntos());
	}
	
	@Test
	public void comprar_UnClientePostaConPromocionYSafeShopCompraAlgoQueVale49YSeDescuentaCredito() {
		//creo clases.
		PromocionYSafeShop promocionYSafeShop = new PromocionYSafeShop();
		ClientePosta cliente = new ClientePosta(promocionYSafeShop);
		//agrego atributos al cliente
		cliente.setCreditoDisponible(2000);
		cliente.comprar(49);
		Assert.assertEquals("No se sumaron puntos", 2000-49, cliente.getCreditoDisponible());
	}
	
	@Test(expected=MaximoLimiteCompraException.class)
	public void comprar_UnClientePostaConPromocionYSafeShopCompraAlgoQueVale1000YTiraError() {
		//creo clases.
		PromocionYSafeShop promocionYSafeShop = new PromocionYSafeShop();
		ClientePosta cliente = new ClientePosta(promocionYSafeShop);
		//agrego atributos al cliente
		cliente.setCreditoDisponible(2000);
		cliente.comprar(1000);
	}
	
	@Test
	public void comprar_UnClientePostaConPromocionYSafeShopCompraAlgoQueVale999YSeDescuentaCredito() {
		//creo clases.
		PromocionYSafeShop promocionYSafeShop = new PromocionYSafeShop();
		ClientePosta cliente = new ClientePosta(promocionYSafeShop);
		//agrego atributos al cliente
		cliente.setCreditoDisponible(2000);
		cliente.comprar(999);
		Assert.assertEquals("No se desconto credito", 2000-999, cliente.getCreditoDisponible());
	}

}
