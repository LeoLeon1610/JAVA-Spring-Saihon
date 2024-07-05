package com.saihon.Spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.saihon.Spring.model.LibroPedido;
import com.saihon.Spring.service.LibroPedidoService;

import java.util.List;

@RestController
@RequestMapping("/libroPedido")
public class LibroPedidoController {

    @Autowired
    private LibroPedidoService libroPedidoService;

    @GetMapping
    public List<LibroPedido> getAllLibroPedido() {
        return libroPedidoService.getAllLibroPedido();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroPedido> getLibroPedidoById(@PathVariable int id) {
        return libroPedidoService.getLibroPedidoById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public LibroPedido addLibroPedido(@RequestBody LibroPedido nuevolibroPedido) {
        return libroPedidoService.addLibroPedido(nuevolibroPedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibroPedido(@PathVariable int id) {
        LibroPedido libroPedido = libroPedidoService.deleteLibroPedido(id);
        if(libroPedido != null) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibroPedido> updateLibroPedido(@PathVariable Integer id, @RequestParam(required = false) Integer idLibro, @RequestParam(required = false) Integer idPedido) {
        LibroPedido libroPedido = libroPedidoService.updateLibroPedido(id, idLibro, idPedido);
        if(libroPedido != null) {
            return ResponseEntity.ok(libroPedido);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

