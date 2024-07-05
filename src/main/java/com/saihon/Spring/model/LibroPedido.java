package com.saihon.Spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "libro_pedido")
public class LibroPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @ManyToOne
    // @JoinColumn(name = "idLibro", referencedColumnName = "id")
    private Long libro;

    // @ManyToOne
    // @JoinColumn(name = "idPedido", referencedColumnName = "id")
    private Long pedido;

    public LibroPedido() {
    }

    public LibroPedido(Long libro, Long pedido) {
        this.libro = libro;
        this.pedido = pedido;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public Long getLibro() {
        return libro;
    }

    public void setLibro(Long idLibro) {
        this.libro = idLibro;
    }

    public Long getPedido() {
        return pedido;
    }

    public void setPedido(Long idPedido) {
        this.pedido = idPedido;
    }

    @Override
    public String toString() {
        return "LibroPedido [id=" + id + ", libro=" + libro + ", pedido=" + pedido + "]";
    }
}
