package com.saihon.Spring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	
	
	
	
	
	
	
}//classPedidoController
