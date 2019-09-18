package modeloDecoradorTest;

import org.junit.Assert;
import org.junit.Test;

import exceptions.MaximoLimiteCompraException;
import modeloDecorador.*;

public class PruebaDecoradorTest {
	
	@Test
	public void comprar_ClienteConPromocionCompra50YObtiene15Puntos() {
		Cliente cliente = new DecoradorDeClienteConPromocion(new ClientePosta());
		cliente.setCreditoDisponible(2000);
		cliente.comprar(50);
		Assert.assertEquals("No se obtuvieron puntos", cliente.getPuntos(), 15);
	}
	
	@Test
	public void comprar_ClienteConPromocionCompra100YObtiene30Puntos() {
		Cliente cliente = new DecoradorDeClienteConPromocion(new ClientePosta());
		cliente.setCreditoDisponible(2000);
		cliente.comprar(100);
		Assert.assertEquals("No se obtuvieron puntos", cliente.getPuntos(), 30);
	}
	
	@Test
	public void comprar_ClienteConPromocionCompra49YNoObtienePuntos() {
		Cliente cliente = new DecoradorDeClienteConPromocion(new ClientePosta());
		cliente.setCreditoDisponible(2000);
		cliente.comprar(49);
		Assert.assertEquals("Se obtuvieron puntos", cliente.getPuntos(), 0);
	}
	
	@Test
	public void comprar_ClienteConPromocionCompra49YSeDescuentaCredito() {
		Cliente cliente = new DecoradorDeClienteConPromocion(new ClientePosta());
		cliente.setCreditoDisponible(2000);
		cliente.comprar(49);
		Assert.assertEquals("No se desconto credito", cliente.getCreditoDisponible(), 2000-49);
	}
	
	@Test
	public void comprar_ClienteConSafeShopCompra999YSeDescuentaCredito() {
		Cliente cliente = new DecoradorDeClienteConSafeShop(new ClientePosta());
		cliente.setCreditoDisponible(2000);
		cliente.comprar(999);
		Assert.assertEquals("No se desconto credito", cliente.getCreditoDisponible(), 2000-999);
	}
	
	@Test(expected = MaximoLimiteCompraException.class)
	public void comprar_ClienteConSafeShopCompra1000YTiraError() {
		Cliente cliente = new DecoradorDeClienteConSafeShop(new ClientePosta());
		cliente.setCreditoDisponible(2000);
		cliente.comprar(1000);
	}
	
	@Test
	public void comprar_ClienteConPromocionYSafeShopCompra50YObtiene15Puntos() {
		Cliente cliente = new DecoradorDeClienteConSafeShop(new DecoradorDeClienteConPromocion(new ClientePosta())); //Entra primero a lo que hace SafeShop y despues a lo que hace Promocion.
		cliente.setCreditoDisponible(2000);
		cliente.comprar(50);
		Assert.assertEquals("No se obtuvieron puntos", cliente.getPuntos(), 15);
	}
	
	@Test
	public void comprar_ClienteConPromocionYSafeShopCompra100YObtiene30Puntos() {
		Cliente cliente = new DecoradorDeClienteConSafeShop(new DecoradorDeClienteConPromocion(new ClientePosta()));
		cliente.setCreditoDisponible(2000);
		cliente.comprar(100);
		Assert.assertEquals("No se obtuvieron puntos", cliente.getPuntos(), 30);
	}
	
	@Test
	public void comprar_ClienteConPromocionYSafeShopCompra49YNoObtienePuntos() {
		Cliente cliente = new DecoradorDeClienteConSafeShop(new DecoradorDeClienteConPromocion(new ClientePosta()));
		cliente.setCreditoDisponible(2000);
		cliente.comprar(49);
		Assert.assertEquals("Se obtuvieron puntos", cliente.getPuntos(), 0);
	}
	
	@Test
	public void comprar_ClienteConPromocionYSafeShopCompra49YSeDescuentaCredito() {
		Cliente cliente = new DecoradorDeClienteConSafeShop(new DecoradorDeClienteConPromocion(new ClientePosta()));
		cliente.setCreditoDisponible(2000);
		cliente.comprar(49);
		Assert.assertEquals("No se desconto credito", cliente.getCreditoDisponible(), 2000-49);
	}
	
	@Test
	public void comprar_ClienteConPromocionYSafeShopCompra999YSeDescuentaCredito() {
		Cliente cliente = new DecoradorDeClienteConSafeShop(new DecoradorDeClienteConPromocion(new ClientePosta()));
		cliente.setCreditoDisponible(2000);
		cliente.comprar(999);
		Assert.assertEquals("No se desconto credito", cliente.getCreditoDisponible(), 2000-999);
	}
	
	@Test(expected = MaximoLimiteCompraException.class)
	public void comprar_ClienteConPromocionYSafeShopCompra1000YTiraError() {
		Cliente cliente = new DecoradorDeClienteConSafeShop(new DecoradorDeClienteConPromocion(new ClientePosta()));
		cliente.setCreditoDisponible(2000);
		cliente.comprar(1000);
	}
	
}
