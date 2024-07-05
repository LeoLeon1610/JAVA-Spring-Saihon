package com.saihon.Spring.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.saihon.Spring.model.Libros;


//import org.springframewotk.data.jpa.repository.JpaRepository;

@Repository//cuando se levante la app se va a vincular la base de datos
public interface LibrosRepository extends org.springframework.data.jpa.repository.JpaRepository<Libros, Long>{
	Optional<Libros> findByNombreLibro(String nombreLibro); 



}//interface ProductoRepository