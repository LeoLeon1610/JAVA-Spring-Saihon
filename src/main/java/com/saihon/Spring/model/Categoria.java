package com.saihon.Spring.model;

public class Categoria {

	private int id;
	private String nombre;
	
	
	public Categoria(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}//constructor


	public Categoria() {
		
	}//constructorVacio


	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + "]";
	}
	
	//getter and setter
	
	
	
	
} //class
