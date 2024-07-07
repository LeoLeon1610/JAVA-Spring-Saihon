package com.saihon.Spring.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//POJO - Plain Old Java Object

@Entity
@Table (name="categoria")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idCategoria", unique=true, nullable=false)
	private long id;
	@Column(name="nombre",nullable=false)
	private String nombre;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="Categoria_idCategoria", referencedColumnName = "idCategoria")
	List<Libros> libros_en_categoria = new ArrayList<Libros>();
	
	
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

	
	public List<Libros> getLibros_en_categoria() {
		return libros_en_categoria;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + "]";
	}
	
	//getter and setter
	
} //class
