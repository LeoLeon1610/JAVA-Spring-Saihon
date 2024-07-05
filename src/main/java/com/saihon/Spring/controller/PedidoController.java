package com.saihon.Spring.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.saihon.Spring.model.Pedido;
import com.saihon.Spring.service.PedidoService;

@RestController
@RequestMapping(path="/api/pedidos/")
public class PedidoController {
    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }//constructor

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
    public Pedido addPedido(@RequestBody Pedido pedido) {
        return pedidoService.addPedido(pedido);
    }//addPedido

    @PutMapping(path="{prodId}")
    public Pedido updatePedido(@PathVariable("prodId") Long idPedidos,
                               @RequestParam(required = false) String domicilio,
                               @RequestParam(required = false) String pago,
                               @RequestParam(required = false) Integer idUsuario) {
        return pedidoService.updatePedido(idPedidos, domicilio, pago);
    }
}
