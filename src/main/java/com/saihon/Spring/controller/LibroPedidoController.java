package com.saihon.Spring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saihon.Spring.model.LibroPedido;
import com.saihon.Spring.service.LibroPedidoService;

@RestController
@RequestMapping("api/libropedido")
public class LibroPedidoController {
    private final LibroPedidoService libroPedidoService;
    
    //Constructor
    @Autowired
    public LibroPedidoController (LibroPedidoService libroPedidoService) {
        this.libroPedidoService = libroPedidoService;
    }

    //Métodos

    //Dar la lista de pedidos
    @GetMapping
    public ArrayList<LibroPedido> getLibroPedido(){
        return libroPedidoService.getAllLibroPedido();
    }

    //Dar la lista de libros Pedidos por id
    @GetMapping(path = "{LibroPedidoId}")
    public LibroPedido getLibroPedidoById(@PathVariable("LibroPedidoId") Long id){
        return libroPedidoService.getLibroPedidoById(id);
        
    }

    // Eliminar un libro pedido por id
    @DeleteMapping(path = "{LibroPedidoId}")
    public LibroPedido deleteLibroPedido(@PathVariable("LibroPedidoId") Long id){
        return libroPedidoService.deleteLibroPedido(id);
    }

    // Crear un libro pedido
    @PostMapping
    public LibroPedido createLibroPedido(@RequestBody LibroPedido libroPedido){
        return libroPedidoService.createLibroPedido(libroPedido);
    }

    // Actualizar un libro pedido
    @PutMapping
    public LibroPedido updateLibroPedido(@RequestBody LibroPedido libroPedido){
        return libroPedidoService.updateLibroPedido(libroPedido);
    }

}
