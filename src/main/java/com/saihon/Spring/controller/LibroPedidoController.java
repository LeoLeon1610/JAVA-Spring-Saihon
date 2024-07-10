package com.saihon.Spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.saihon.Spring.model.LibroPedido;
import com.saihon.Spring.service.LibroPedidoService;

import java.util.List;

@RestController
@RequestMapping(path="/api/libroPedido/")
public class LibroPedidoController {
	private LibroPedidoService libroPedidoService;
    
//    @Autowired
//    private LibroPedidoService libroPedidoService;
	@Autowired
    public LibroPedidoController(LibroPedidoService libroPedidoService) {
    	this.libroPedidoService = libroPedidoService;
    }
    @GetMapping
    public List<LibroPedido> getAllLibroPedido() {
        return libroPedidoService.getAllLibroPedido();
    }//GET ALL LibroPedido

    
//    public ResponseEntity<LibroPedido> getLibroPedidoById(@PathVariable Long LibroPedidoId) {
//        return libroPedidoService.getLibroPedidoById(LibroPedidoId)
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
	@GetMapping(path="{LibroPedidoId}")
	public LibroPedido getLibroPedido(@PathVariable("LibroPedidoId") Long LibroPedidoId){
		return libroPedidoService.getLibroPedidoById(LibroPedidoId);
    }//GET LibroPedido

    @PostMapping
    public LibroPedido addLibroPedido(@RequestBody LibroPedido nuevolibroPedido) {
        return libroPedidoService.addLibroPedido(nuevolibroPedido);
    }//POST LibroPedido

//    @DeleteMapping(path="{LibroPedidoId}")
//    public ResponseEntity<Void> deleteLibroPedido(@PathVariable Long LibroPedidoId) {
//        LibroPedido libroPedido = libroPedidoService.deleteLibroPedido(id);
//        if(libroPedido != null) {
//            return ResponseEntity.ok().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }//DELETE LibroPedido
    @DeleteMapping(path="{LibroPedidoId}")
	public LibroPedido deleteLibroPedido(@PathVariable("LibroPedidoId") Long LibroPedidoId) {
		return libroPedidoService.deleteLibroPedido(LibroPedidoId);
	}//deleteLibro

//    @PutMapping("{LibroPedidoId}")
//    public ResponseEntity<LibroPedido> updateLibroPedido(@PathVariable Long LibroPedidoId, 
//    		@RequestParam(required = false) Long idLibro, 
//    		@RequestParam(required = false) Long idPedido) {
//		        LibroPedido libroPedido = libroPedidoService.updateLibroPedido(LibroPedidoId, idLibro, idPedido);
//		        if(libroPedido != null) {
//		            return ResponseEntity.ok(libroPedido);
//		        } else {
//		            return ResponseEntity.notFound().build();
//		        }
//    }//PUT LibroPedido
    
    @PutMapping(path="{LibroPedidoId}") // http://localhost:8080/api/productos/1
	public LibroPedido updateLibroPedido(@PathVariable Long LibroPedidoId, 
    		@RequestParam(required = false) Long idLibro, 
    		@RequestParam(required = false) Long idPedido) {
    	return libroPedidoService.updateLibroPedido(LibroPedidoId, idLibro, idPedido);
	}//updateLibroPedido
}

