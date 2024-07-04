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
	}//constructor
	
	@GetMapping
	public ArrayList<Pedido>getAllProducts(){
		return pedidoService.getAllProducts();
	}//getProductos
	
	@GetMapping(path="{prodId}") //http://localhost:8080/api/pedidos/1
	public Pedido getPedido(@PathVariable("prodId") int idPedidos) {
		return pedidoService.getPedido(idPedidos);
	}//getProducto
	
	@DeleteMapping(path="{prodId}") //http://localhost:8080/api/pedidos/1
	public Pedido deletePedido(@PathVariable("prodId") int idPedidos) {
		return pedidoService.deletePedido(idPedidos);
	}//deletePedido
	
	@PostMapping
	public Pedido addPedido(@RequestBody Pedido pedido) {
		return pedidoService.addPedido(pedido);
	}
	
	@PutMapping
	public Pedido updatePedido(@PathVariable ("prodId") int idPedidos,
		@RequestParam(required = false) String domicilio,
		@RequestParam(required = false) String pago,
		@RequestParam(required = false) int idUsuario){
			return pedidoService.updatePedido(idPedidos, domicilio, pago, idUsuario);
		}//Updtate
	
}//classPedidoController
