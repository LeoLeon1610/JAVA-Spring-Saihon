package com.saihon.Spring.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.saihon.Spring.model.Categoria;

@Repository
public interface CategoriaRepository  extends JpaRepository< Categoria, Long> {
	Optional<Categoria> findByNombre(String nombre);
}