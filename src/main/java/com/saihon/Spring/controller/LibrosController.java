package com.saihon.Spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saihon.Spring.model.Libros;
import com.saihon.Spring.service.LibrosService;

@RestController
@RequestMapping(path="/api/libros")
public class LibrosController {
	public final LibrosService librosService;
	
	public LibrosService (LibrosService librosService) {
		this.librosService=librosService;
	}
	
	
	@GetMapping
	public List<Libros> getLibros() {
		return ;
	} //getLibro
	
}
