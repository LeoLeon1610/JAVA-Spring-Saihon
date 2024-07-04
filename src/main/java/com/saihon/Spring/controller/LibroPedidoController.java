package com.saihon.Spring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam; // Add this import statement

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
    public LibroPedido getLibroPedidoById(@PathVariable("LibroPedidoId") int id){
        return libroPedidoService.getLibroPedidoById(id);
        
    }

    // Eliminar un libro pedido por id
    @DeleteMapping(path = "{LibroPedidoId}")
    public LibroPedido deleteLibroPedido(@PathVariable("LibroPedidoId") int id){
        return libroPedidoService.deleteLibroPedido(id);
    }

    // Crear un libro pedido
    @PostMapping
    public LibroPedido createLibroPedido(@RequestBody LibroPedido libroPedido){
        return libroPedidoService.addLibroPedido(libroPedido);
    }

    // Actualizar un libro pedido
    @PutMapping
    public LibroPedido updateLibroPedido(@PathVariable("LibroPedidoId") int id, @RequestParam(required = false) int idLibro, @RequestParam(required = false) int idPedido ){
        return libroPedidoService.updateLibroPedido(id, idLibro, idPedido); 
    }
}
