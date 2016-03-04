package co.com.jhilton.drools.descuentos.ejecutor;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

import co.com.jhilton.drools.descuentos.model.Factura;

public class CalculadorDescuentos {

	public void calcular(Factura factura) {
		KieServices kService = KieServices.Factory.get();
		KieContainer kContainer = kService.newKieClasspathContainer();
		StatelessKieSession kSession = kContainer.newStatelessKieSession();
		
		kSession.execute(factura);
	}

}
