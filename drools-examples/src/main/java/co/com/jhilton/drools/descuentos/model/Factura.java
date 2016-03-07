package co.com.jhilton.drools.descuentos.model;

public class Factura {

	private int subtotal;
	private double descuentoAplicado;
	private FormaPago formaPago;
	private Cliente cliente;

	public Factura(int subtotal, FormaPago formaPago, Cliente cliente) {
		this.subtotal = subtotal;
		this.formaPago = formaPago;
		this.cliente = cliente;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public double getTotal() {
		return getSubtotal() * (1 - getDescuentoAplicado());
	}

	public double getDescuentoAplicado() {
		return descuentoAplicado;
	}

	public void setDescuentoAplicado(double descuentoAplicado) {
		this.descuentoAplicado = descuentoAplicado;
	}

	public FormaPago getFormaPago() {
		return formaPago;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


}
