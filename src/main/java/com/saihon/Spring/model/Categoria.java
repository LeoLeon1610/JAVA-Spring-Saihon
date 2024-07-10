package com.saihon.Spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO - Plain Old Java Object

@Entity
@Table (name="categoria")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idCategoria", unique=true, nullable=false)
	private Long id;
	@Column(name="nombre",nullable=false)
	private String nombre;
	
	public Categoria(String nombre) {
		this.nombre = nombre;
	}//constructor


	public Categoria() {
	}//constructorVacio


	public Long getId() {
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
