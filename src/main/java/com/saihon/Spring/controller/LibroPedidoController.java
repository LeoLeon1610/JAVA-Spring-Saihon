package com.saihon.Spring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.saihon.Spring.model.LibroPedido;
import com.saihon.Spring.service.LibroPedidoService;

@RestController
@RequestMapping("api/libropedido")
public class LibroPedidoController {
    private final LibroPedidoService libroPedidoService;

    // Constructor
    @Autowired
    public LibroPedidoController(LibroPedidoService libroPedidoService) {
        this.libroPedidoService = libroPedidoService;
    }

    // Métodos

    // Dar la lista de pedidos
    @GetMapping
    public ArrayList<LibroPedido> getLibroPedido() {
        return libroPedidoService.getAllLibroPedido();
    }

    // Dar la lista de libros pedidos por id
    @GetMapping(path = "{libroPedidoId}")
    public LibroPedido getLibroPedidoById(@PathVariable("libroPedidoId") int id) {
        return libroPedidoService.getLibroPedidoById(id);
    }

    // Eliminar un libro pedido por id
    @DeleteMapping(path = "{libroPedidoId}")
    public LibroPedido deleteLibroPedido(@PathVariable("libroPedidoId") int id) {
        return libroPedidoService.deleteLibroPedido(id);
    }

    // Crear un libro pedido
    @PostMapping
    public LibroPedido createLibroPedido(@RequestBody LibroPedido libroPedido) {
        return libroPedidoService.addLibroPedido(libroPedido);
    }

    // Actualizar un libro pedido
    @PutMapping(path = "{libroPedidoId}")
    public LibroPedido updateLibroPedido(
        @PathVariable("libroPedidoId") int id, 
        @RequestParam(required = false) Integer idLibro, 
        @RequestParam(required = false) Integer idPedido){
            
        return libroPedidoService.updateLibroPedido(id, idLibro, idPedido);
    }
}

