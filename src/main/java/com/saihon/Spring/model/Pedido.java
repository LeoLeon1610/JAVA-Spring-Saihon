package com.saihon.Spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
    private String forma_de_pago; 
    private String status;
	@Column(name="Usuario_idUsuario",nullable = false)
    private long idUsuario;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="Pedidos_idPedidos", referencedColumnName = "idPedidos")
	List<LibroPedido> pedidos_libros = new ArrayList<LibroPedido>();


    public Pedido(String domicilio, String forma_de_pago, String status, long idUsuario) {
		this.domicilio = domicilio;
		this.forma_de_pago = forma_de_pago;
		this.status = status;
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

   
    public long getIdPedidos() {
        return idPedidos;
    }//getIdPedidos

    public long getIdUsuario() {
        return idUsuario;
    }//getIdUusario

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public String getForma_de_pago() {
		return forma_de_pago;
	}

	public void setForma_de_pago(String forma_de_pago) {
		this.forma_de_pago = forma_de_pago;
	}

	public List<LibroPedido> getPedidos_usuario() {
		return pedidos_libros;
	}

	@Override
	public String toString() {
		return "Pedido [idPedidos=" + idPedidos + ", domicilio=" + domicilio + ", forma_de_pago=" + forma_de_pago
				+ ", status=" + status + ", idUsuario=" + idUsuario + "]";
	}
    
    
   
}
