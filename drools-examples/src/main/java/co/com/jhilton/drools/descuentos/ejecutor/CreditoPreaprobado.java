package co.com.jhilton.drools.descuentos.ejecutor;

import co.com.jhilton.drools.descuentos.model.Cliente;

public class CreditoPreaprobado {

	private Cliente cliente;
	private double valorPreaprobado;

	public CreditoPreaprobado(Cliente cliente, double valorPreaprobado) {
		this.cliente = cliente;
		this.valorPreaprobado = valorPreaprobado;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
}
