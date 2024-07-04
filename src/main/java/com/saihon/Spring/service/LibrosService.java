package com.saihon.Spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saihon.Spring.model.Libros;

@Service
public class LibrosService {
	public final ArrayList<Libros> listaLibros = new ArrayList<Libros>();

	@Autowired
	public LibrosService(){
		listaLibros.add(new Libros("To kill A Mockingbird", 200.50, "A classic novel depicting racial injustice in the American South", 12, "Monckingbird.jpg","Harper Lee", 1960, "Classic"));
		listaLibros.add(new Libros("1984", 200.50, "A dystopian novel portraying a totalitarian society ", 4, "1984.jpg","George Orwell", 1949,  "Classic"));
		listaLibros.add(new Libros("Pride and Prejudice", 200.50, "A classic novel exploring themes of love, marriage, and social norms", 11, "Pride.jpg","Jane Austen", 1813, "Romance"));
	}
	
	public ArrayList<Libros> getAllBooks(){
		return listaLibros;
	}
	
	public Libros getLibro(int id) {
		Libros tmpBook = null;
		for (Libros libros : listaLibros) {
			if(libros.getId()==id) {
				tmpBook=libros;
				break;
			}//if
		}//foreach
		return tmpBook;
	}
	
	public Libros deleteLibro(int id) {
		Libros tmpBook = null;
		for (Libros libros : listaLibros) {
			if(libros.getId()==id) {
				tmpBook=libros;
				listaLibros.remove(listaLibros.indexOf(tmpBook));
				break;
			} //if
		}//foreach
		return tmpBook;
	}
	
	public Libros addLibro(Libros libros){
		Libros tmpBook = null;
		boolean existe=false;
		for (Libros libro : listaLibros) {
			if(libro.getNombreLibro().equals(libros.getNombreLibro())) {
				existe = true;
				break;
			}// if
		}//foreach
		if(! existe) {
			listaLibros.add(libros);
			tmpBook=libros;
		}// if ! existe
		return tmpBook;
	}

	public Libros updateBooks(String nombreLibro, Double precio, String descripcion, Integer cantidadStock, String portada,
			String autor, Integer year, String categoria, int idLibros) {
		Libros tmpBook = null;
		for (Libros libros : listaLibros) {
			if(libros.getId()==idLibros) {
				if(nombreLibro != null) libros.setNombreLibro(nombreLibro);
				if(precio != null) libros.setPrecio(precio);
				if(descripcion != null) libros.setDescripcion(descripcion);
				if(cantidadStock != null) libros.setCantidadStock(cantidadStock);
				if(portada != null) libros.setPortada(portada);
				if(autor != null) libros.setAutor(autor);
				if(year != null) libros.setYear(year);
				if(categoria != null) libros.setCategoria(categoria);
			}//if 
		}//foreach
		
		return tmpBook;
	}

} // class LibroService

