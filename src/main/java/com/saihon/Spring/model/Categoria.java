package com.saihon.Spring.model;

public class Categoria {
	private static int total =0;
	private int id;
	private String nombre;
	
	
	public Categoria(String nombre) {
		Categoria.total++;
		this.id = total;
		this.nombre = nombre;
	}//constructor


	public Categoria() {
		Categoria.total++;
		this.id = total;
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
