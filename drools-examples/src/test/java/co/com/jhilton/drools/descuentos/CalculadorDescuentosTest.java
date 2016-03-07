package co.com.jhilton.drools.descuentos;

import org.junit.Assert;
import org.junit.Test;

import co.com.jhilton.drools.descuentos.ejecutor.CalculadorDescuentos;
import co.com.jhilton.drools.descuentos.model.Factura;
import co.com.jhilton.drools.descuentos.model.FormaPago;

public class CalculadorDescuentosTest {

	@Test
	public void debeHacerDescuentoDelDosPorcientoCuandoPagaConTarjetaDebito() {
		Factura factura = new Factura(500000, FormaPago.DEBITO);
		CalculadorDescuentos calculador = new CalculadorDescuentos();
		calculador.calcular(factura);
		Assert.assertTrue(0.02D == factura.getDescuentoAplicado());
		Assert.assertTrue(490000 == factura.getTotal());
	}
	
	@Test
	public void debeHacerDescuentoDelCincoPorcientoCuandoPagaConTarjetaCredito() {
		Factura factura = new Factura(500000, FormaPago.CREDITO);
		CalculadorDescuentos calculador = new CalculadorDescuentos();
		calculador.calcular(factura);
		Assert.assertTrue(0.05D == factura.getDescuentoAplicado());
		Assert.assertTrue(475000 == factura.getTotal());
	}
	
	@Test
	public void noDebeHacerDescuentoCuandoPagaConEfectivo() {
		Factura factura = new Factura(500000, FormaPago.EFECTIVO);
		CalculadorDescuentos calculador = new CalculadorDescuentos();
		calculador.calcular(factura);
		Assert.assertTrue(0.00D == factura.getDescuentoAplicado());
		Assert.assertTrue(500000 == factura.getTotal());
	}
}
