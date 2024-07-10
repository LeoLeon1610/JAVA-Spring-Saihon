package com.saihon.Spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saihon.Spring.model.Libros;
import com.saihon.Spring.repository.LibrosRepository;

@Service
public class LibrosService {
	public final LibrosRepository librosRepository;

	@Autowired
	public LibrosService(LibrosRepository librosRepository){
		this.librosRepository = librosRepository;
	}
	
	public List<Libros> getAllBooks(){
		return librosRepository.findAll();
	}//getAllBooks
	
	public Libros getBook(Long id) {
		return librosRepository.findById(id).orElseThrow(
				()-> new IllegalArgumentException("El libro con el id ["+ id + "] no existe"));
	}
	
	public Libros deleteBook(Long id) {
		Libros tmpBook = null;
		if (librosRepository.existsById(id)) {
			tmpBook=librosRepository.findById(id).get();
			librosRepository.deleteById(id);
		}//if
		return tmpBook;
	}//delete
	

    public Libros addBook(Libros libros) {
        Optional<Libros> tmpLibro = librosRepository.findByNombreLibro(libros.getNombreLibro());
        
        if(tmpLibro.isEmpty()) {
        	return librosRepository.save(libros);
        } else {
        	System.out.println("El libros con el nombre [" +
        			libros.getNombreLibro() + "] ya existe");
        	return null;
        }
    }//addProduct

	public Libros updateBook(Long idLibros, String nombreLibro, Double precio, String descripcion, Integer cantidadStock, String portada,
			String autor, String editorial, Integer year, Integer categoria) {
		Libros tmpBook = null;
		if (librosRepository.existsById(idLibros)){
			Libros libros =librosRepository.findById(idLibros).get();
				if(nombreLibro != null) libros.setNombreLibro(nombreLibro);
				if(precio != null) libros.setPrecio(precio);
				if(descripcion != null) libros.setDescripcion(descripcion);
				if(cantidadStock != null) libros.setCantidadStock(cantidadStock);
				if(portada != null) libros.setPortada(portada);
				if(autor != null) libros.setAutor(autor);
				if(editorial != null) libros.setEditorial(editorial);
				if(year != null) libros.setYear(year);
				if(categoria != null) libros.setCategoria(categoria);
				librosRepository.save(libros);
				tmpBook=libros;
			}//if 
		return tmpBook;
	}//updateLibro

} // class LibroService

