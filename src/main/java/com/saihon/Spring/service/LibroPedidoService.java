package com.saihon.Spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saihon.Spring.model.LibroPedido;
import com.saihon.Spring.repository.LibroPedidoRepository;

@Service
public class LibroPedidoService {
	private final LibroPedidoRepository libroPedidoRepository;
	
    @Autowired
    public LibroPedidoService(LibroPedidoRepository libroPedidoRepository) {
    	this.libroPedidoRepository = libroPedidoRepository;
    }
	
    public List<LibroPedido> getAllLibroPedido() {
        return libroPedidoRepository.findAll();
    }// GET ALL LibrosPedidos

                                       // Tenía un int
	public LibroPedido getLibroPedidoById(Long id) {
		return libroPedidoRepository.findById(id).orElseThrow(
				()-> new IllegalArgumentException("Relación con el id ["
						+ id +"] no encontrada"));
//        return libroPedidoRepository.findById((long) id).map(Optional::ofNullable).orElseThrow(() -> new IllegalArgumentException("El producto no existe" + id));
    }//GET LibroPedido

										// Tenía un int
    public LibroPedido deleteLibroPedido(Long id) {
//        Optional<LibroPedido> libroPedido = libroPedidoRepository.findById((long) id);
//        if(libroPedido.isPresent()) {
//            libroPedidoRepository.deleteById((long) id);
//            return libroPedido.get();
//        }else {
//            return null;
//        }
    	LibroPedido tmpLP = null;
		if (libroPedidoRepository.existsById(id)) {
			tmpLP=libroPedidoRepository.findById(id).get();
			libroPedidoRepository.deleteById(id);
		}//if
		return tmpLP;
    	
    }//DELETE LibroPedido 

    public LibroPedido addLibroPedido(LibroPedido nuevolibroPedido) {
//        if (libroPedidoRepository.existsById(nuevolibroPedido.getId())) {
//            return libroPedidoRepository.save(nuevolibroPedido);
//        }else{  
//            return null;
//        }
    	 Optional<LibroPedido> tmpLP = libroPedidoRepository.findById(nuevolibroPedido.getId());
         
         if(tmpLP.isEmpty()) {
         	return libroPedidoRepository.save(nuevolibroPedido);
         } else {
         	System.out.println("El libro-pedido con el id [" +
         			nuevolibroPedido.getId() + "] ya existe");
         	return null;
         }
    }//POST LibroPedido

    public LibroPedido updateLibroPedido(Long id, Long idLibro, Long idPedido) {
//        LibroPedido libroPedido = libroPedidoRepository.findById((long) id)
//                .orElseThrow(() -> new IllegalArgumentException("El producto no existe: " + id));
//        
//        if (idLibro != null) libroPedido.setLibro((long) idLibro);
//        if (idPedido != null) libroPedido.setPedido((long)idPedido);
//        
//        return libroPedidoRepository.save(libroPedido);
    	LibroPedido tmpLP = null;
    	if(libroPedidoRepository.existsById(id)) {
    		LibroPedido libroPedido =libroPedidoRepository.findById(id).get();
    		if (idLibro != null) libroPedido.setLibro(idLibro);
    		if (idPedido != null) libroPedido.setPedido(idPedido);
    		libroPedidoRepository.save(libroPedido);
    		tmpLP=libroPedido;
    	}
    	return tmpLP;
    }//PUT LibroPedido
}

