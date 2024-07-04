package com.saihon.Spring.model;

public class Libros {
	private String nombreLibro;
	private Double precio;
	private String descripcion;
	private Integer cantidadStock;
	private String portada;
	private String autor;
	private Integer year;
	private String categoria;
	private int idLibros;
	private static int total=0;
	

	public Libros(String nombreLibro, Double precio, String descripcion, Integer cantidadStock, String portada,
			String autor, Integer year, String categoria) {
		this.nombreLibro = nombreLibro;
		this.precio = precio;
		this.descripcion = descripcion;
		this.cantidadStock = cantidadStock;
		this.portada = portada;
		this.autor = autor;
		this.year = year;
		this.categoria = categoria;
		Libros.total++;
		this.idLibros=total;
	}

	public Integer getYear() {
		return year;
	} //getYear

	public void setYear(Integer year) {
		this.year = year;
	} //setYear

	public Libros() {
		Libros.total++;
		this.idLibros=total;
	} //Constructor Vacío

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

	public String getCategoria() {
		return categoria;
	} //getCategoria

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	} //setCategoria
	
	public int getId() {
		return idLibros;
	} //getId

	@Override
	public String toString() {
		return "Libros [nombreLibro=" + nombreLibro + ", precio=" + precio + ", descripcion=" + descripcion
				+ ", cantidadStock=" + cantidadStock + ", portada=" + portada + ", autor=" + autor + ", year=" + year
				+ ", categoria=" + categoria + ", idLibros=" + idLibros + "]";
	}




} //CLASS LIBROS
