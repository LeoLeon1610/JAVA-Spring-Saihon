package com.saihon.Spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saihon.Spring.model.LibroPedido;
import com.saihon.Spring.repository.LibroPedidoRepository;

@Service
public class LibroPedidoService {

    @Autowired
    private LibroPedidoRepository libroPedidoRepository;

    public List<LibroPedido> getAllLibroPedido() {
        return libroPedidoRepository.findAll();
    }

    public Optional<LibroPedido> getLibroPedidoById(int id) {
        return libroPedidoRepository.findById((long) id).map(Optional::ofNullable).orElseThrow(() -> new IllegalArgumentException("El producto no existe" + id));
    }

    public LibroPedido deleteLibroPedido(int id) {
        Optional<LibroPedido> libroPedido = libroPedidoRepository.findById((long) id);
        if(libroPedido.isPresent()) {
            libroPedidoRepository.deleteById((long) id);
            return libroPedido.get();
        }else {
            return null;
        }
    }

    public LibroPedido addLibroPedido(LibroPedido nuevolibroPedido) {
        if (libroPedidoRepository.existsById(nuevolibroPedido.getId())) {
            return libroPedidoRepository.save(nuevolibroPedido);
        }else{  
            return null;
        }
    }

    public LibroPedido updateLibroPedido(Integer id, Integer idLibro, Integer idPedido) {
        LibroPedido libroPedido = libroPedidoRepository.findById((long) id)
                .orElseThrow(() -> new IllegalArgumentException("El producto no existe: " + id));
        
        if (idLibro != null) libroPedido.setLibro((long) idLibro);
        if (idPedido != null) libroPedido.setPedido((long)idPedido);
        
        return libroPedidoRepository.save(libroPedido);
    }
}

