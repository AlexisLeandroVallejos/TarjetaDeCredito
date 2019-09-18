package modeloRecuerdoTest;

import org.junit.Assert;
import org.junit.Test;

import exceptions.MaximoLimiteCompraException;
import modeloRecuerdo.*;

public class PruebaRecuerdoTest {
	
	@Test
	public void comprar_UnClientePostaTieneCondicionPromocionCompra50YObtienePuntos() {
		//cliente original sin atributos.
		CuidadorDeRecuerdos cuidador = new CuidadorDeRecuerdos();
		ClientePosta cliente = new ClientePosta(cuidador);
		Recuerdo recuerdo = cliente.guardarClienteEnRecuerdo();
		cuidador.agregarRecuerdo(recuerdo);
		
		//guarda otro cliente en cuidador.
		cliente.setCreditoDisponible(2000);
		cliente.agregarCondicionComercial(new CondicionPromocion());
		recuerdo = cliente.guardarClienteEnRecuerdo();
		cuidador.agregarRecuerdo(recuerdo);
		
		//compra
		cliente.comprar(50);
		recuerdo = cliente.guardarClienteEnRecuerdo();
		cuidador.agregarRecuerdo(recuerdo);
		Assert.assertEquals("No obtuvo puntos", cuidador.obtenerRecuerdo(2).getPuntos(), 15);
	}
	
	@Test
	public void comprar_UnClientePostaTieneCondicionPromocionCompra49YNoObtienePuntos() {
		//cliente original sin atributos.
		CuidadorDeRecuerdos cuidador = new CuidadorDeRecuerdos();
		ClientePosta cliente = new ClientePosta(cuidador);
		Recuerdo recuerdo = cliente.guardarClienteEnRecuerdo();
		cuidador.agregarRecuerdo(recuerdo);
		
		//guarda otro cliente en cuidador.
		cliente.setCreditoDisponible(2000);
		cliente.agregarCondicionComercial(new CondicionPromocion());
		recuerdo = cliente.guardarClienteEnRecuerdo();
		cuidador.agregarRecuerdo(recuerdo);
		
		//compra
		cliente.comprar(49);
		recuerdo = cliente.guardarClienteEnRecuerdo();
		cuidador.agregarRecuerdo(recuerdo);
		Assert.assertEquals("No obtuvo puntos", cuidador.obtenerRecuerdo(1).getPuntos(), 0);
	}
	
	@Test
	public void comprar_UnClientePostaTieneCondicionPromocionCompra49YSeDescuentaCredito() {
		//cliente original sin atributos.
		CuidadorDeRecuerdos cuidador = new CuidadorDeRecuerdos();
		ClientePosta cliente = new ClientePosta(cuidador);
		Recuerdo recuerdo = cliente.guardarClienteEnRecuerdo();
		cuidador.agregarRecuerdo(recuerdo);
		
		//guarda otro cliente en cuidador.
		cliente.setCreditoDisponible(2000);
		cliente.agregarCondicionComercial(new CondicionPromocion());
		recuerdo = cliente.guardarClienteEnRecuerdo();
		cuidador.agregarRecuerdo(recuerdo);
		
		//compra
		cliente.comprar(49);
		recuerdo = cliente.guardarClienteEnRecuerdo();
		cuidador.agregarRecuerdo(recuerdo);
		Assert.assertEquals("No se desconto credito", cuidador.obtenerRecuerdo(2).getCreditoDisponible(), 2000-49);
	}
	
	@Test
	public void comprar_UnClientePostaTieneCondicionPromocionCompra100YObtieneElDobleDePuntosQueConComprar50() {
		//cliente original sin atributos.
		CuidadorDeRecuerdos cuidador = new CuidadorDeRecuerdos();
		ClientePosta cliente = new ClientePosta(cuidador);
		Recuerdo recuerdo = cliente.guardarClienteEnRecuerdo();
		cuidador.agregarRecuerdo(recuerdo);
		
		//guarda otro cliente en cuidador.
		cliente.setCreditoDisponible(2000);
		cliente.agregarCondicionComercial(new CondicionPromocion());
		recuerdo = cliente.guardarClienteEnRecuerdo();
		cuidador.agregarRecuerdo(recuerdo);
		
		//compra
		cliente.comprar(100);
		recuerdo = cliente.guardarClienteEnRecuerdo();
		cuidador.agregarRecuerdo(recuerdo);
		Assert.assertEquals("No obtuvo el doble de puntos", cuidador.obtenerRecuerdo(2).getPuntos(), 15*2);
	}
	
	@Test
	public void comprar_UnClientePostaTieneCondicionSafeShopCompra999YSeDescuentaCredito() {
		//cliente original sin atributos.
		CuidadorDeRecuerdos cuidador = new CuidadorDeRecuerdos();
		ClientePosta cliente = new ClientePosta(cuidador);
		Recuerdo recuerdo = cliente.guardarClienteEnRecuerdo();
		cuidador.agregarRecuerdo(recuerdo);
		
		//guarda otro cliente en cuidador.
		cliente.setCreditoDisponible(2000);
		cliente.agregarCondicionComercial(new CondicionSafeShop());
		recuerdo = cliente.guardarClienteEnRecuerdo();
		cuidador.agregarRecuerdo(recuerdo);
		
		//compra
		cliente.comprar(999);
		recuerdo = cliente.guardarClienteEnRecuerdo();
		cuidador.agregarRecuerdo(recuerdo);
		Assert.assertEquals("No se desconto credito", cuidador.obtenerRecuerdo(2).getCreditoDisponible(), 2000-999);
	}
	
	@Test
	public void comprar_UnClientePostaTieneCondicionSafeShopCompra1000YSeRestauraASuUltimoEstado() {
		//cliente original sin atributos.
		CuidadorDeRecuerdos cuidador = new CuidadorDeRecuerdos();
		ClientePosta cliente = new ClientePosta(cuidador);
		Recuerdo recuerdo = cliente.guardarClienteEnRecuerdo();
		cuidador.agregarRecuerdo(recuerdo);
		
		//guarda otro cliente en cuidador.
		cliente.setCreditoDisponible(2000);
		cliente.agregarCondicionComercial(new CondicionSafeShop());
		recuerdo = cliente.guardarClienteEnRecuerdo();
		cuidador.agregarRecuerdo(recuerdo);
		
		//compra
		cliente.comprar(1000);
		recuerdo = cliente.guardarClienteEnRecuerdo();
		cuidador.agregarRecuerdo(recuerdo);
		Assert.assertTrue("No se restauro a su ultimo estado.", cliente.getCreditoDisponible() == 2000 && cliente.getPuntos() == 0);
	}
	
	@Test
	public void comprar_UnClientePostaTieneCondicionPromocionYSafeShopCompra50YObtienePuntos() {
		//cliente original sin atributos.
		CuidadorDeRecuerdos cuidador = new CuidadorDeRecuerdos();
		ClientePosta cliente = new ClientePosta(cuidador);
		Recuerdo recuerdo = cliente.guardarClienteEnRecuerdo();
		cuidador.agregarRecuerdo(recuerdo);
		
		//guarda otro cliente en cuidador.
		cliente.setCreditoDisponible(2000);
		cliente.agregarCondicionComercial(new CondicionPromocion());
		cliente.agregarCondicionComercial(new CondicionSafeShop());
		recuerdo = cliente.guardarClienteEnRecuerdo();
		cuidador.agregarRecuerdo(recuerdo);
		
		//compra
		cliente.comprar(50);
		recuerdo = cliente.guardarClienteEnRecuerdo();
		cuidador.agregarRecuerdo(recuerdo);
		Assert.assertEquals("No obtuvo puntos", cuidador.obtenerRecuerdo(2).getPuntos(), 15);
	}
	
	@Test
	public void comprar_UnClientePostaTieneCondicionPromocionYSafeShopCompra49YNoObtienePuntos() {
		//cliente original sin atributos.
		CuidadorDeRecuerdos cuidador = new CuidadorDeRecuerdos();
		ClientePosta cliente = new ClientePosta(cuidador);
		Recuerdo recuerdo = cliente.guardarClienteEnRecuerdo();
		cuidador.agregarRecuerdo(recuerdo);
		
		//guarda otro cliente en cuidador.
		cliente.setCreditoDisponible(2000);
		cliente.agregarCondicionComercial(new CondicionPromocion());
		cliente.agregarCondicionComercial(new CondicionSafeShop());
		recuerdo = cliente.guardarClienteEnRecuerdo();
		cuidador.agregarRecuerdo(recuerdo);
		
		//compra
		cliente.comprar(49);
		recuerdo = cliente.guardarClienteEnRecuerdo();
		cuidador.agregarRecuerdo(recuerdo);
		Assert.assertEquals("Obtuvo puntos", cuidador.obtenerRecuerdo(1).getPuntos(), 0);
	}
	
	@Test
	public void comprar_UnClientePostaTieneCondicionPromocionYSafeShopCompra49YSeDescuentaCredito() {
		//cliente original sin atributos.
		CuidadorDeRecuerdos cuidador = new CuidadorDeRecuerdos();
		ClientePosta cliente = new ClientePosta(cuidador);
		Recuerdo recuerdo = cliente.guardarClienteEnRecuerdo();
		cuidador.agregarRecuerdo(recuerdo);
		
		//guarda otro cliente en cuidador.
		cliente.setCreditoDisponible(2000);
		cliente.agregarCondicionComercial(new CondicionPromocion());
		cliente.agregarCondicionComercial(new CondicionSafeShop());
		recuerdo = cliente.guardarClienteEnRecuerdo();
		cuidador.agregarRecuerdo(recuerdo);
		
		//compra
		cliente.comprar(49);
		recuerdo = cliente.guardarClienteEnRecuerdo();
		cuidador.agregarRecuerdo(recuerdo);
		Assert.assertEquals("No se desconto credito", cuidador.obtenerRecuerdo(2).getCreditoDisponible(), 2000-49);
	}
	
	@Test
	public void comprar_UnClientePostaTieneCondicionPromocionYSafeShopCompra100YObtieneElDobleDePuntosQueConComprar50() {
		//cliente original sin atributos.
		CuidadorDeRecuerdos cuidador = new CuidadorDeRecuerdos();
		ClientePosta cliente = new ClientePosta(cuidador);
		Recuerdo recuerdo = cliente.guardarClienteEnRecuerdo();
		cuidador.agregarRecuerdo(recuerdo);
		
		//guarda otro cliente en cuidador.
		cliente.setCreditoDisponible(2000);
		cliente.agregarCondicionComercial(new CondicionPromocion());
		cliente.agregarCondicionComercial(new CondicionSafeShop());
		recuerdo = cliente.guardarClienteEnRecuerdo();
		cuidador.agregarRecuerdo(recuerdo);
		
		//compra
		cliente.comprar(100);
		recuerdo = cliente.guardarClienteEnRecuerdo();
		cuidador.agregarRecuerdo(recuerdo);
		Assert.assertEquals("No obtuvo el doble de puntos", cuidador.obtenerRecuerdo(2).getPuntos(), 15*2);
	}
	
	@Test
	public void comprar_UnClientePostaTieneCondicionPromocionYSafeShopCompra999YSeDescuentaCredito() {
		//cliente original sin atributos.
		CuidadorDeRecuerdos cuidador = new CuidadorDeRecuerdos();
		ClientePosta cliente = new ClientePosta(cuidador);
		Recuerdo recuerdo = cliente.guardarClienteEnRecuerdo();
		cuidador.agregarRecuerdo(recuerdo);
		
		//guarda otro cliente en cuidador.
		cliente.setCreditoDisponible(2000);
		cliente.agregarCondicionComercial(new CondicionPromocion());
		cliente.agregarCondicionComercial(new CondicionSafeShop());
		recuerdo = cliente.guardarClienteEnRecuerdo();
		cuidador.agregarRecuerdo(recuerdo);
		
		//compra
		cliente.comprar(999);
		recuerdo = cliente.guardarClienteEnRecuerdo();
		cuidador.agregarRecuerdo(recuerdo);
		Assert.assertEquals("No se desconto credito", cuidador.obtenerRecuerdo(2).getCreditoDisponible(), 2000-999);
	}
	
	@Test
	public void comprar_UnClientePostaTieneCondicionPromocionYSafeShopCompra1000YSeRestauraASuUltimoEstado() {
		//cliente original sin atributos.
		CuidadorDeRecuerdos cuidador = new CuidadorDeRecuerdos();
		ClientePosta cliente = new ClientePosta(cuidador);
		Recuerdo recuerdo = cliente.guardarClienteEnRecuerdo();
		cuidador.agregarRecuerdo(recuerdo);
		
		//guarda otro cliente en cuidador.
		cliente.setCreditoDisponible(2000);
		cliente.agregarCondicionComercial(new CondicionPromocion());
		cliente.agregarCondicionComercial(new CondicionSafeShop());
		recuerdo = cliente.guardarClienteEnRecuerdo();
		cuidador.agregarRecuerdo(recuerdo);
		
		//compra
		cliente.comprar(1000);
		recuerdo = cliente.guardarClienteEnRecuerdo();
		cuidador.agregarRecuerdo(recuerdo);
		Assert.assertTrue("No se restauro a su ultimo estado.", cliente.getCreditoDisponible() == 2000 && cliente.getPuntos() == 0);
		
	}


}
