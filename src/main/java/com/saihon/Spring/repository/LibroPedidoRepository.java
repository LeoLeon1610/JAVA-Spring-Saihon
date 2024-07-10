package com.saihon.Spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saihon.Spring.model.LibroPedido;

// Interfaz que extiende de JpaRepository, recibe dos parametros, el primero es el modelo y el segundo es el tipo de dato de la llave primaria
public interface LibroPedidoRepository extends JpaRepository<LibroPedido, Long> {
    // metodo de la interfaz que recibe un Long y retorna una lista de LibroPedido, tiene la erencia de los metodos de JpaRepository
//    public List<LibroPedido> findByLibro(Long libro);

}
