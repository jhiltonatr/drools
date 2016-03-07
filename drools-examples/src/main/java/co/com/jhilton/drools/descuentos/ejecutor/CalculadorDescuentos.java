package co.com.jhilton.drools.descuentos.ejecutor;

import java.util.Arrays;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

import co.com.jhilton.drools.descuentos.model.Factura;

public class CalculadorDescuentos {

	public void calcular(Factura factura) {
		calcular(Arrays.asList(factura));
	}

	public void calcular(List<Factura> facturas) {
		KieServices kService = KieServices.Factory.get();
		KieContainer kContainer = kService.newKieClasspathContainer();
		StatelessKieSession kSession = kContainer.newStatelessKieSession();
		kSession.setGlobal("COLA_CORREOS", ColaCorreo.getCola());
		kSession.execute(facturas);
	}

}
