package com.saihon.Spring.service;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saihon.Spring.model.Pedido;
import com.saihon.Spring.repository.PedidoRepository;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    
    @Autowired
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }//constructor

    public List<Pedido> getAllProducts() {
        return pedidoRepository.findAll();
    }//lista de pedidos

    public Pedido getPedido(Long idPedidos) {
        return pedidoRepository.findById(idPedidos).orElseThrow(
        		()-> new IllegalArgumentException("El pedido con el id [" + idPedidos + "[no existe"));
    }//getPedido

    public Pedido deletePedido(Long idPedidos) {
        Pedido tPedido = null;
        if(pedidoRepository.existsById(idPedidos)) {
        	tPedido = pedidoRepository.findById(idPedidos).get();
        	pedidoRepository.deleteById(idPedidos);
        }
        return tPedido;
    }//deletePedido

    public Pedido addPedido(Pedido pedido) {
        Optional<Pedido> tPedido =
        		pedidoRepository.findById(pedido.getIdPedidos());
        if(tPedido.isEmpty()) {
        	return pedidoRepository.save(pedido);
        }else {
        	System.out.println("El pedido con el nombre [" + pedido.getIdPedidos() +"] ya existe");
        	return null;
        }//else
    }//addPedido

    public Pedido updatePedido(Long idPedidos, String domicilio, String forma_de_pago, String status) {
        Pedido tPedido = null;
        if(pedidoRepository.existsById(idPedidos)){
            Pedido pedido = pedidoRepository.findById(idPedidos).get();
            if(domicilio!=null)pedido.setDomicilio(domicilio);
            if(forma_de_pago!=null)pedido.setForma_de_pago(forma_de_pago); 
            if(status!=null)pedido.setStatus(status);  
            pedidoRepository.save(pedido);
            tPedido = pedido;
            }//if
        return tPedido;
	}

}

