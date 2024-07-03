package com.saihon.Spring.model;


public class Pedido {
	private String domicilio;
	private String pago;
	private int idPedidos;
	private int idUsuario;
	private static int total=0;
	
	public Pedido(String domicilio, String pago, int idPedidos, int idUsuario) {
	this.domicilio = domicilio;
		this.pago = pago;
		this.idPedidos = idPedidos;
		this.idUsuario = idUsuario;
		Pedido.total++;
		this.idPedidos=total;
	}//constructor
	
	public Pedido(String string, String string2, String string3) {
		
	}//constructorVacio

	public String getDomicilio() {
		return domicilio;
	}//getDomicilio
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}//setDomicilio
	public String getPago() {
		return pago;
	}//getPago
	public void setPago(String pago) {
		this.pago = pago;
	}//setPago
	public static int getTotal() {
		return total;
	}//getTotal
	public static void setTotal(int total) {
		Pedido.total = total;
	}//setTotal
	public int getIdPedidos() {
		return idPedidos;
	}//getPedido
	public int getIdUsuario() {
		return idUsuario;
	}//getUsuario

	@Override
	public String toString() {
		return "Pedido [domicilio=" + domicilio + ", pago=" + pago + ", idPedidos=" + idPedidos + ", idUsuario="
				+ idUsuario + "]";
	}//toString

	
	
	
	
}//class Pedido


