package com.saihon.Spring.controller;

import java.util.ArrayList;

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
    }

    @GetMapping
    public ArrayList<Pedido> getAllProducts() {
        return pedidoService.getAllProducts();
    }

    @GetMapping(path="{prodId}")
    public Pedido getPedido(@PathVariable("prodId") int idPedidos) {
        return pedidoService.getPedido(idPedidos);
    }

    @DeleteMapping(path="{prodId}")
    public Pedido deletePedido(@PathVariable("prodId") int idPedidos) {
        return pedidoService.deletePedido(idPedidos);
    }

    @PostMapping
    public Pedido addPedido(@RequestBody Pedido pedido) {
        return pedidoService.addPedido(pedido);
    }

    @PutMapping(path="{prodId}")
    public Pedido updatePedido(@PathVariable("prodId") int idPedidos,
                               @RequestParam(required = false) String domicilio,
                               @RequestParam(required = false) String pago,
                               @RequestParam(required = false) int idUsuario) {
        return pedidoService.updatePedido(idPedidos, domicilio, pago);
    }
}
