package co.com.jhilton.drools.descuentos;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import co.com.jhilton.drools.descuentos.ejecutor.CalculadorDescuentos;
import co.com.jhilton.drools.descuentos.ejecutor.ColaCorreo;
import co.com.jhilton.drools.descuentos.model.Cliente;
import co.com.jhilton.drools.descuentos.model.Factura;
import co.com.jhilton.drools.descuentos.model.FormaPago;

public class CalculadorDescuentosTest {

	@Before
	public void init() {
		ColaCorreo.clear();
	}
	
	@Test
	public void debeHacerDescuentoDelDosPorcientoCuandoPagaConTarjetaDebito() {
		Factura factura = new Factura(500000, FormaPago.DEBITO, new Cliente("Isabel"));
		CalculadorDescuentos calculador = new CalculadorDescuentos();
		calculador.calcular(factura);
		Assert.assertTrue(0.02D == factura.getDescuentoAplicado());
		Assert.assertTrue(490000 == factura.getTotal());
	}
	
	@Test
	public void debeHacerDescuentoDelCincoPorcientoCuandoPagaConTarjetaCredito() {
		Factura factura = new Factura(500000, FormaPago.CREDITO, new Cliente("Isabel"));
		CalculadorDescuentos calculador = new CalculadorDescuentos();
		calculador.calcular(factura);
		Assert.assertTrue(0.05D == factura.getDescuentoAplicado());
		Assert.assertTrue(475000 == factura.getTotal());
	}
	
	@Test
	public void noDebeHacerDescuentoCuandoPagaConEfectivo() {
		Factura factura = new Factura(500000, FormaPago.EFECTIVO, new Cliente("Isabel"));
		CalculadorDescuentos calculador = new CalculadorDescuentos();
		calculador.calcular(factura);
		Assert.assertTrue(0.00D == factura.getDescuentoAplicado());
		Assert.assertTrue(500000 == factura.getTotal());
	}
	
	@Test
	public void debeAgregarCreditoPreaprobadoAColaDeCorreoPorCompraDeUnMillon() {
		Factura factura = new Factura(1000000, FormaPago.EFECTIVO, new Cliente("Isabel"));
		CalculadorDescuentos calculador = new CalculadorDescuentos();
		calculador.calcular(factura);
		Assert.assertEquals(1, ColaCorreo.getMessagesInQueue());
	}
	
	@Test
	public void noDebeAgregarCreditoPreaprobadoAColaDeCorreoPorSegundaCompraDelCliente() {
		Factura factura1 = new Factura(1000000, FormaPago.EFECTIVO, new Cliente("Isabel"));
		Factura factura2 = new Factura(1500000, FormaPago.EFECTIVO, new Cliente("Isabel"));
		CalculadorDescuentos calculador = new CalculadorDescuentos();
		calculador.calcular(Arrays.asList(factura1, factura2));
		Assert.assertEquals(1, ColaCorreo.getMessagesInQueue());
	}
	
	@Test
	public void debeAgregarDosCreditosPreaprobadoAColaDeCorreo() {
		Factura factura1 = new Factura(1000000, FormaPago.EFECTIVO, new Cliente("Isabel"));
		Factura factura2 = new Factura(1500000, FormaPago.EFECTIVO, new Cliente("Maria"));
		CalculadorDescuentos calculador = new CalculadorDescuentos();
		calculador.calcular(Arrays.asList(factura1, factura2));
		Assert.assertEquals(2, ColaCorreo.getMessagesInQueue());
	}
	
	@Test
	public void debeAgregarUnCreditoPreaprobadoAColaDeCorreo() {
		Factura factura1 = new Factura(1000000, FormaPago.EFECTIVO, new Cliente("Isabel"));
		Factura factura2 = new Factura(999999, FormaPago.EFECTIVO, new Cliente("Maria"));
		CalculadorDescuentos calculador = new CalculadorDescuentos();
		calculador.calcular(Arrays.asList(factura1, factura2));
		Assert.assertEquals(1, ColaCorreo.getMessagesInQueue());
	}
}
