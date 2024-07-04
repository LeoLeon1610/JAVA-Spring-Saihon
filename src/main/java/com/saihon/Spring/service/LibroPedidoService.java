package com.saihon.Spring.service;

import java.util.ArrayList;

import com.saihon.Spring.model.LibroPedido;

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
        for(LibroPedido libroPedido : table){
            if(libroPedido.getId() == id){
                return libroPedido;
            }
        }
        return null;
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
                if(pedido.getIdPedido() == nuevolibroPedido.getIdPedido() && pedido.getIdLibro() == nuevolibroPedido.getIdLibro()){
                    existe = true;
                    break;
                }
            }
            if(! existe) {
                table.add(nuevolibroPedido);
                tmpLibroPedido=nuevolibroPedido;
            }
            return tmpLibroPedido;
    }

    public LibroPedido updateLibroPedido(int id, int idLibro, int idPedido) {
        LibroPedido tmpLibroPedido=null;
        for (LibroPedido libroPedido : table){
            if(libroPedido.getId() == id){

                libroPedido.setIdLibro(idLibro);
                libroPedido.setIdPedido(idPedido);
                tmpLibroPedido=libroPedido;
                break;
            }
            return tmpLibroPedido;
        }
        return null;
    }

}
