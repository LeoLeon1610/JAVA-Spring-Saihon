package com.saihon.Spring.repository;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saihon.Spring.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
//	Optional<Pedido> findById(Long id);
}
