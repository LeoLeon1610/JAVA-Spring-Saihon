package com.saihon.Spring.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.saihon.Spring.model.Pedido;

@Service
public class PedidoService {
    private final ArrayList<Pedido> lista = new ArrayList<>();

    public PedidoService() {
        lista.add(new Pedido("Villa Bilbao #140 San Sebastian", "Tarjeta de debito", 2996));
        lista.add(new Pedido("Adelitas #690 Valleverde", "Tarjeta de debito", 3467));
        lista.add(new Pedido("El rosal #2687 Valle de las Flores", "Tarjeta de credito", 610));
        lista.add(new Pedido("Inglaterra #285 Europa", "Tarjeta de debito", 3471));
    }

    public ArrayList<Pedido> getAllProducts() {
        return lista;
    }

    public Pedido getPedido(int idPedidos) {
        for (Pedido pedido : lista) {
            if (pedido.getIdPedidos() == idPedidos) {
                return pedido;
            }
        }
        return null;
    }

    public Pedido deletePedido(int idPedidos) {
        Pedido tPedido = null;
        for (Pedido pedido : lista) {
            if (pedido.getIdPedidos() == idPedidos) {
                tPedido = lista.remove(lista.indexOf(pedido));
                break;
            }
        }
        return tPedido;
    }

    public Pedido addPedido(Pedido pedido) {
        for (Pedido prod : lista) {
            if (prod.getIdPedidos() == pedido.getIdPedidos()) {
                return null; // Pedido ya existe
            }
        }
        lista.add(pedido);
        return pedido;
    }

    public Pedido updatePedido(int idPedidos, String domicilio, String pago) {
        for (Pedido pedido : lista) {
            if (pedido.getIdPedidos() == idPedidos) {
                if (domicilio != null) pedido.setDomicilio(domicilio);
                if (pago != null) pedido.setPago(pago);
                return pedido;
            }
        }
        return null;
    }
}
