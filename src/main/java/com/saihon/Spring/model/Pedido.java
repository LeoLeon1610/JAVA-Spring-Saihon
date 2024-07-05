package com.saihon.Spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPedidos", unique = true, nullable = false)
	 private long idPedidos;
	@Column(nullable = false)
    private String domicilio;
    private String pago;
    private long idUsuario;


    public Pedido(String domicilio, String pago, int idUsuario) {
        this.domicilio = domicilio;
        this.pago = pago;
        this.idUsuario = idUsuario;
    }

    // Constructor vacio
    public Pedido() {
    	
    }

    public String getDomicilio() {
        return domicilio;
    }//getDomiciolio

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }//setDomicilio

    public String getPago() {
        return pago;
    }//getPago

    public void setPago(String pago) {
        this.pago = pago;
    }//setPago

    public long getIdPedidos() {
        return idPedidos;
    }//getIdPedidos

    public long getIdUsuario() {
        return idUsuario;
    }//getIdUusario
    
    @Override
    public String toString() {
        return "Pedido [domicilio=" + domicilio + ", pago=" + pago + ", idPedidos=" + idPedidos + ", idUsuario="
                + idUsuario + "]";
    }
}
