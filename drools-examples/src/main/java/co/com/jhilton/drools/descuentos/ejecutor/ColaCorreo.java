package co.com.jhilton.drools.descuentos.ejecutor;

import java.util.ArrayList;
import java.util.List;

public class ColaCorreo {
	
	private static final List<CreditoPreaprobado> CREDITOS = new ArrayList<>();

	public static void clear() {
		CREDITOS.clear();		
	}
	
	public static void addMessage(CreditoPreaprobado credito) {
		CREDITOS.add(credito);
	}

	public static int getMessagesInQueue() {
		return CREDITOS.size();
	}

	public static List<CreditoPreaprobado> getCola() {
		return CREDITOS;
	}
}
