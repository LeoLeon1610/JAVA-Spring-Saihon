package com.saihon.Spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.saihon.Spring.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Long>{
	Optional<Usuario> findByEmail(String email);
}	
