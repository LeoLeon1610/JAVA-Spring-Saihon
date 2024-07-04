package com.saihon.Spring.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import com.saihon.Spring.model.LibroPedido;

@Service
public class LibroPedidoService {

    public final ArrayList<LibroPedido> table = new ArrayList<LibroPedido>();

    public LibroPedidoService(){
        table.add(new LibroPedido(1, 1));
        table.add(new LibroPedido(2, 2));
        table.add(new LibroPedido(3, 3));
    }

    public ArrayList<LibroPedido> getAllLibroPedido() {
        return table;
    }

    public LibroPedido getLibroPedidoById(int id) {
        LibroPedido tmLibroPedido=null;
        for(LibroPedido libroPedido : table){
            if(libroPedido.getId() == id){
                tmLibroPedido = libroPedido;
                break;
            }
        }
        return tmLibroPedido;
    }

    public LibroPedido deleteLibroPedido(int id) {
        for(LibroPedido libroPedido : table){
            if(libroPedido.getId() == id){
                table.remove(libroPedido);
                return libroPedido;
            }
        }
        return null;
    }

    public LibroPedido addLibroPedido(LibroPedido nuevolibroPedido) {
            LibroPedido tmpLibroPedido=null;
            boolean existe=false;
            for (LibroPedido pedido : table) {
                if(pedido.getIdPedido() == nuevolibroPedido.getIdPedido()){
                    existe = true;
                    break;
                }
            }
            if(!existe) {
                tmpLibroPedido=nuevolibroPedido;
                table.add(tmpLibroPedido);
                return tmpLibroPedido;
            }
            return tmpLibroPedido;
    }

    public LibroPedido updateLibroPedido(Integer id, Integer idLibro, Integer idPedido) {
            LibroPedido tmpLibroPedido=null;
            for (LibroPedido libroPedido : table){
                if(libroPedido.getId() == id){
        
                    if(idLibro != null)libroPedido.setIdLibro(idLibro);
                    if(idPedido != null)libroPedido.setIdPedido(idPedido);
                    tmpLibroPedido=libroPedido;
                    break;
                }
            }
            return tmpLibroPedido;
        }
    }

