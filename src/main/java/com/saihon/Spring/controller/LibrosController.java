package com.saihon.Spring.controller;


import java.util.List;

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

import com.saihon.Spring.model.Libros;
import com.saihon.Spring.service.LibrosService;

@RestController
@RequestMapping(path="/api/libros/")
public class LibrosController {
	private final LibrosService libroService;
	@Autowired
	public LibrosController(LibrosService libroService) {
		this.libroService=libroService;
	}//constructor
	
	@GetMapping
	public List<Libros> getLibros(){
		return libroService.getAllBooks();
	}//getLibros
	
	@GetMapping(path="{libroID}")// http://localhost:8080/api/productos/1
	public Libros getLibro(@PathVariable("libroID") Long id){
		return libroService.getBook(id);
	}//getLibro
	
	@DeleteMapping(path="{libroID}") // http://localhost:8080/api/productos/1
	public Libros deleteLibro(@PathVariable("libroID") Long id) {
		return libroService.deleteBook(id);
	}//deleteLibro
	
	@PostMapping // http://localhost:8080/api/productos/
	public Libros addLibro(@RequestBody Libros libro) {
		return libroService.addBook(libro);
	}//addBook
	
	@PutMapping(path="{libroID}") // http://localhost:8080/api/productos/1
	public Libros updateLibro(@PathVariable("libroID") Long idLibros,
		@RequestParam(required=false) String nombreLibro,
		@RequestParam(required=false) Double precio,
		@RequestParam(required=false) String descripcion,
		@RequestParam(required=false) Integer cantidadStock,
		@RequestParam(required=false) String portada,
		@RequestParam(required=false) String autor,
		@RequestParam(required=false) String editorial,
		@RequestParam(required=false) Integer year,
		@RequestParam(required=false) Integer categoria) {
		
		return libroService.updateBook(idLibros, nombreLibro, precio, descripcion, cantidadStock, portada,
				autor, editorial, year, categoria);
	}//updateLibro
}//LibrosController