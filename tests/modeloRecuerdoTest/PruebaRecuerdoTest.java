package modeloRecuerdoTest;

import org.junit.Assert;
import org.junit.Test;

import modeloRecuerdo.*;

public class PruebaRecuerdoTest {
	
	@Test
	public void comprar_UnClientePostaTieneCondicionPromocionCompra50YObtienePuntos() {
		//cliente original sin atributos.
		ClientePosta cliente = new ClientePosta();
		Recuerdo recuerdo = cliente.guardarClienteEnRecuerdo();
		CuidadorDeRecuerdos cuidador = new CuidadorDeRecuerdos();
		cuidador.agregarRecuerdo(recuerdo);
		
		//guarda otro cliente en cuidador.
		cliente.setCreditoDisponible(2000);
		cliente.agregarCondicionComercial(new CondicionPromocion());
		cliente.comprar(50);
		recuerdo = cliente.guardarClienteEnRecuerdo();
		cuidador.agregarRecuerdo(recuerdo);
		Assert.assertEquals("No obtuvo puntos", cliente.getPuntos(), 15);
	}

}
