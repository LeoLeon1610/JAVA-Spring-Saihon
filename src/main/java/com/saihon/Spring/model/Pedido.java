package com.saihon.Spring.model;

public class Pedido {
    private String domicilio;
    private String pago;
    private int idPedidos;
    private int idUsuario;
    private static int total = 0;

    public Pedido(String domicilio, String pago, int idUsuario) {
        this.domicilio = domicilio;
        this.pago = pago;
        this.idUsuario = idUsuario;
        Pedido.total++;
        this.idPedidos = total;
    }

    // Constructor vacío
    public Pedido() {
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    public int getIdPedidos() {
        return idPedidos;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    @Override
    public String toString() {
        return "Pedido [domicilio=" + domicilio + ", pago=" + pago + ", idPedidos=" + idPedidos + ", idUsuario="
                + idUsuario + "]";
    }
}
