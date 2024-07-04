package com.saihon.Spring.model;

public class LibroPedido {
    private Long id;
    private Long idLibro;
    private Long idPedido;

    public LibroPedido(Long idLibro, Long idPedido){
        this.idLibro = idLibro;
        this.idPedido = idPedido;
    }


    // Getters y Setters
    public Long getId() {
        return id;
    }

    public Long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Long idLibro) {
        this.idLibro = idLibro;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }


    // Método toString
    @Override
    public String toString() {
        return "LibroPedido{" +
                "id=" + id +
                ", idLibro=" + idLibro +
                ", idPedido=" + idPedido +
                '}';
    }

}
