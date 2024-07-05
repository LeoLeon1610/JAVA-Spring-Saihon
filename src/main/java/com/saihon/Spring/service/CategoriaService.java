package com.saihon.Spring.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saihon.Spring.model.Categoria;
import com.saihon.Spring.repository.CategoriaRepository;



@Service
public class CategoriaService {
	public final CategoriaRepository categoriaRepository;

    @Autowired  
    public CategoriaService(CategoriaRepository categoriaRepository) {
    	this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> getAllCategoria() {           
        return categoriaRepository.findAll();
    }

    public Categoria getCategoria(Long id) {
		   return categoriaRepository.findById(id).orElseThrow(()
				   -> new IllegalArgumentException("Categoria con el id ["+ 
		   id +"] no existe")
		   );
	}//get

    public Categoria deleteCategoria(long id) {
        Categoria tmpCat = null;
        if (categoriaRepository.existsById(id)) {
        	tmpCat=categoriaRepository.findById(id).get();
        	categoriaRepository.deleteById(id);
        }
        return tmpCat;
    }//delete

    public Categoria addCategoria( Categoria categoria ) {                            
        Optional<Categoria> tmpCat = 
        		categoriaRepository.findByNombre(categoria.getNombre());
        
        if(tmpCat.isEmpty()) {
        	return categoriaRepository.save(categoria);
        } else {
        	System.out.println("Categoria con el nombre [" +
        			categoria.getNombre() + "] ya existe");
        	return null;
        }
    }//add

    public Categoria updateCategoria(Long id, String nombre) {
        Categoria tmpCat = null;
        if (categoriaRepository.existsById(id)) {
           Categoria categoria = categoriaRepository.findById(id).get();
                if (nombre != null) categoria.setNombre(nombre);
                categoriaRepository.save(categoria);
                tmpCat=categoria;
            }//if
        
        return tmpCat;
    }//update

    
}//class

	

