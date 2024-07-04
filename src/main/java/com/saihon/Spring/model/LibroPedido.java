package com.saihon.Spring.model;

public class LibroPedido {
    private static int idLibroPedido;
    private int idLibro;
    private int idPedido;

    public LibroPedido(int idLibro, int idPedido) {
        idLibroPedido++;
        this.idLibro = idLibro;
        this.idPedido = idPedido;
    }


    // Getters y Setters
    public int getId() {
        return idLibroPedido;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }


    // Método toString
    @Override
    public String toString() {
        return "LibroPedido{" +
                "idLibroPedido=" + idLibroPedido +
                ", idLibro=" + idLibro +
                ", idPedido=" + idPedido +
                '}';
    }

}
