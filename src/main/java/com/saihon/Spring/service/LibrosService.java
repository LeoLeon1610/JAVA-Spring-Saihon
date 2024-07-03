package com.saihon.Spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saihon.Spring.model.Libros;

@Service
public class LibrosService {
	public final List<Libros> listaLibros;

	@Autowired
	public LibrosService(){
		listaLibros.add(new Libros("", ""));
	}
	
	public List<Libros> getAllBooks(){
		return listaLibros;
	}


} // class LibroService

