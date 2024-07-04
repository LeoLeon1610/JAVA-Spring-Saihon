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

import com.saihon.Spring.model.Categoria;
import com.saihon.Spring.service.CategoriaService;

@RestController
@RequestMapping(path="/api/productos/")
public class CategoriaController {
	private final CategoriaService categoriaService;
	
		
		@Autowired
		public CategoriaController(CategoriaService categoriaService) {
		this.categoriaService= categoriaService;
		}// constructor
		
		@GetMapping
		public ArrayList<Categoria> getCategoria(){
			return categoriaService.getAllCategoria();
		}//get
		
		@GetMapping(path="{prodId}") //http://localhost:8080/api/productos/1
		public Categoria getCategoria(@PathVariable("prodId") int id ) {
			return categoriaService.getCategoria(id);
		}//get
		
		//delete
		@DeleteMapping(path="{prodId}") //http://localhost:8080/api/productos/1
		public Categoria deleteCategoria(@PathVariable("prodId")int id) {
			return categoriaService.deleteCategoria(id);
		}//delete
		
		//post
		@PostMapping
		public Categoria addCategoria(@RequestBody Categoria categoria) {
			return categoriaService.addCategoria(categoria);
		}//add
		
		//put
		@PutMapping(path="{prodId}") //http://localhost:8080/api/productos/1
		public Categoria updateCategoria(@PathVariable("prodId")int id,
				@RequestParam(required=false) String nombre) {
			return categoriaService.updateCategoria(id, nombre);
		}//updateProducto
		
	}//class ProductosController
