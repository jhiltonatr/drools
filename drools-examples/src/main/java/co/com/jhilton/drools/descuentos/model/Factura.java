package co.com.jhilton.drools.descuentos.model;

public class Factura {

	private int subtotal;
	private double total;
	private double descuentoAplicado;
	private String formaPago;

	public Factura(int subtotal, String formaPago) {
		this.subtotal = subtotal;
		this.formaPago = formaPago;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getDescuentoAplicado() {
		return descuentoAplicado;
	}

	public void setDescuentoAplicado(double descuentoAplicado) {
		this.descuentoAplicado = descuentoAplicado;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

}
