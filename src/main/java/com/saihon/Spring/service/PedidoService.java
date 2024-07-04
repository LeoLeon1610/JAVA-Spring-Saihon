package com.saihon.Spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saihon.Spring.model.Pedido;

@Service
public class PedidoService {
	public final ArrayList<Pedido> lista = new ArrayList<Pedido>();
	
	@Autowired
	public PedidoService(){
		lista.add(new Pedido("Villa Bilbao #140 San Sebastian"," Tarjeta de debito ", "AC2996S"));
		lista.add(new Pedido("Adelitas #690 Valleverde"," Tarjeta de debito ", "IG3467D"));
		lista.add(new Pedido("El rosal #2687 Valle de las Flores"," Tarjeta de credito", "PA0610A"));
		lista.add(new Pedido("Inglaterra #285 Europa"," Tarjeta de debito ", "CM3471C"));
	}//listaDePedidos
	
	public ArrayList<Pedido>getAllProducts(){
		return lista;
	}//getAllPorducts
	
	public Pedido getPedido(int idPedidos) {
		Pedido tPedido= null;
		for (Pedido pedido: lista) {
			if(pedido.getIdPedidos()==idPedidos) {
				tPedido = pedido;
				break;
			}//if
		}//forEach
		return tPedido;
	}//getPedido
	
	public Pedido deletePedido(int idPedidos) {
		Pedido tPedido = null;
		for (Pedido pedido : lista) {
			if (pedido.getIdPedidos()==idPedidos) {
				tPedido = lista.remove(lista.indexOf(pedido));
				break;
			}//if
		}//forEach
		return tPedido;
	}//deletePedido
	
	public Pedido addPedido(Pedido pedido) {
		Pedido tPedido = null;
		boolean existe = false;
		for(Pedido prod : lista) {
			//if(prod.getIdPedidos().equals(pedido.getIdPedidos())) {
				if (prod.getIdPedidos() == pedido.getIdPedidos()) {
				existe = true;
				break;
			}//if
		}//forEach
		if(! existe) {
			lista.add(pedido);
			tPedido=pedido;
		}//if ! existe
		return tPedido;
	}//addPedido

	public Pedido updatePedido(int idPedidos, String domicilio, String pago, int idUsuario) {
		Pedido tPedido = null;
		for (Pedido pedido : lista) {
			if(pedido.getIdPedidos()==idPedidos) {
				if(domicilio!=null)pedido.setDomicilio(domicilio);
				if(pago!=null)pedido.setPago(pago);
				tPedido = pedido;
				break;
			}//if
		}//forEach
		return tPedido;
	}//updatePedido
	
	
}//class PedidoService
