package com.saihon.Spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="libros")
public class Libros {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idLibros", unique=true, nullable=false)
	private Long idLibros;
	
	@Column(name="NombreLibro",nullable=false)
	private String nombreLibro;
	@Column(name="Precio")
	private Double precio;
	@Column(name="Descripcion")
	private String descripcion;
	@Column(name="Cantidad_Stock")
	private Integer cantidadStock;
	@Column(name="Portada")
	private String portada;
	@Column(name="Autor")
	private String autor;
	@Column(name="Editorial")
	private String editorial;
	@Column(name="PublicationYear")
	private Integer year;
	@Column(name="Categoria_idCategoria",nullable=false)
	private Integer categoria;
	
	public Libros(String nombreLibro, Double precio, String descripcion, Integer cantidadStock,
			String portada, String autor, String editorial, Integer year, Integer categoria) {
		this.nombreLibro = nombreLibro;
		this.precio = precio;
		this.descripcion = descripcion;
		this.cantidadStock = cantidadStock;
		this.portada = portada;
		this.autor = autor;
		this.editorial = editorial;
		this.year = year;
		this.categoria = categoria;
	}//Constructor
	
	
	public Libros() {

	} //constructor vacio

	public Integer getYear() {
		return year;
	} //getYear

	public void setYear(Integer year) {
		this.year = year;
	} //setYear

	public String getNombreLibro() {
		return nombreLibro;
	} //getNombreLibro

	public void setNombreLibro(String nombreLibro) {
		this.nombreLibro = nombreLibro;
	} //setNombreLibro

	public Double getPrecio() {
		return precio;
	} //getPrecio

	public void setPrecio(Double precio) {
		this.precio = precio;
	} //setPrecio

	public String getDescripcion() {
		return descripcion;
	} //getDescripcion

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	} //setDescripcion

	public Integer getCantidadStock() {
		return cantidadStock;
	} //getCantidad_Stock

	public void setCantidadStock(Integer cantidadStock) {
		this.cantidadStock = cantidadStock;
	} //setCantidad_Stock

	public String getPortada() {
		return portada;
	} //getPortada

	public void setPortada(String portada) {
		this.portada = portada;
	} //setPortada

	public String getAutor() {
		return autor;
	} //getAutor

	public void setAutor(String autor) {
		this.autor = autor;
	} //setAutor

	public Integer getCategoria() {
		return categoria;
	} //getCategoria

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	} //setCategoria
	
	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}


	public Long getIdLibros() {
		return idLibros;
	}

	@Override
	public String toString() {
		return "Libros [idLibros=" + idLibros + ", nombreLibro=" + nombreLibro + ", precio=" + precio + ", descripcion="
				+ descripcion + ", cantidadStock=" + cantidadStock + ", portada=" + portada + ", autor=" + autor
				+ ", editorial=" + editorial + ", year=" + year + ", categoria=" + categoria + "]";
	}




} //CLASS LIBROS