package co.com.jhilton.drools.descuentos;

import org.junit.Assert;
import org.junit.Test;

import co.com.jhilton.drools.descuentos.ejecutor.CalculadorDescuentos;
import co.com.jhilton.drools.descuentos.model.Factura;

public class CalculadorDescuentosTest {

	@Test
	public void debeHacerDescuentoDelDosPorcientoCuandoPagaConTarjetaDebito() {
		Factura factura = new Factura(500000, "DEBITO");
		CalculadorDescuentos calculador = new CalculadorDescuentos();
		calculador.calcular(factura);
		Assert.assertTrue(0.02D == factura.getDescuentoAplicado());
		Assert.assertTrue(490000 == factura.getTotal());
	}
	
	@Test
	public void debeHacerDescuentoDelCincoPorcientoCuandoPagaConTarjetaCredito() {
		Factura factura = new Factura(500000, "CREDITO");
		CalculadorDescuentos calculador = new CalculadorDescuentos();
		calculador.calcular(factura);
		Assert.assertTrue(0.05D == factura.getDescuentoAplicado());
		Assert.assertTrue(475000 == factura.getTotal());
	}
}
