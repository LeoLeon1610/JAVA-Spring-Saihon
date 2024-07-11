package com.saihon.Spring.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saihon.Spring.model.Pedido;
import com.saihon.Spring.service.PedidoService;

@RestController
@RequestMapping(path="/api/pedidos/")
public class PedidoController {
	private final PedidoService pedidoService;
	
	@Autowired
    public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}

	@GetMapping
    public List<Pedido> getAllProducts() {
        return pedidoService.getAllProducts();
    }//obtener la lista

    @GetMapping(path="{prodId}")
    public Pedido getPedido(@PathVariable("prodId") Long idPedidos) {
        return pedidoService.getPedido(idPedidos);
    }//getPedido

    @DeleteMapping(path="{prodId}")
    public Pedido deletePedido(@PathVariable("prodId") Long idPedidos) {
        return pedidoService.deletePedido(idPedidos);
    }//deletePedido
    
    @PostMapping
	public Pedido postPedido(@RequestBody Pedido pedido){
		return pedidoService.addPedido(pedido);
	}// POST METHOD

    @PutMapping(path="{prodId}")
    public Pedido updatePedido(@PathVariable("prodId") Long idPedidos,
                               @RequestParam(required = false) String domicilio,
                               @RequestParam(required = false) String forma_de_pago,
                               @RequestParam(required = false) String status) {
		return pedidoService.updatePedido(idPedidos, domicilio, forma_de_pago, status);
    }
}
