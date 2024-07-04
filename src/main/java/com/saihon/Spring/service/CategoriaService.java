package com.saihon.Spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saihon.Spring.model.Categoria;


@Service
public class CategoriaService {
	public final ArrayList<Categoria> lista = new ArrayList<Categoria>();

	@Autowired
	public CategoriaService() {
		lista.add(new Categoria(1, "Terror"));
		lista.add(new Categoria(2, "Romance"));
		lista.add(new Categoria(3, "Suspenso"));
		lista.add(new Categoria(4, "Drama"));
	}// constructor

	
	public ArrayList<Categoria> getAllCategoria(){
		return lista;
	}//getAll

	public Categoria getCategoria(int id) {
		Categoria tmpProd=null;
		for (Categoria categoria : lista) {
			if(categoria.getId()==id) {
				tmpProd= categoria;
				break;
			}//if
		}//foreach
		return tmpProd;
	}//get

	
	public Categoria deleteCategoria(int id) {
		Categoria tmpProd = null;
		for (Categoria categoria : lista) {
			if(categoria.getId()==id) {
				tmpProd= lista.remove(lista.indexOf(categoria));
				break;
			}//if
		}//for each
		return tmpProd;
	}//delete

	public Categoria addCategoria(Categoria categoria) {
		Categoria tmpProd=null;
		boolean existe=false;
		for (Categoria prod : lista) {
			if(prod.getNombre().equals(categoria.getNombre())) {
				existe = true;
				break;
			}// if
		}//foreach
		if(! existe) {
			lista.add(categoria);
			tmpProd=categoria;
		}// if ! existe
		return tmpProd;
	}//add

	public Categoria updateCategoria(int id, String nombre) {
		Categoria tmpProd=null;
		for (Categoria categoria : lista) {
			if(categoria.getId()==id) {
				if (nombre!=null) categoria.setNombre(nombre);
				tmpProd=categoria;
				break;
			}//if
		} //foreach
		return tmpProd;
	}//update

}// class 
