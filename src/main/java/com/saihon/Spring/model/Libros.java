package com.saihon.Spring.model;

public class Libros {
	private String nombreLibro;
	private Double precio;
	private String descripcion;
	private int cantidad_Stock;
	private String portada;
	private String autor;
	private String categoría;
	private int idLibros;
	private static int total=0;
	
	public Libros(int idLibros, String nombreLibro, Double precio, String descripcion, int cantidad_Stock,
			String portada, String autor, String categoría) {

		this.nombreLibro = nombreLibro;
		this.precio = precio;
		this.descripcion = descripcion;
		this.cantidad_Stock = cantidad_Stock;
		this.portada = portada;
		this.autor = autor;
		this.categoría = categoría;
		Libros.total++;
		this.idLibros=total;
	} //Constructor

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

	public int getCantidad_Stock() {
		return cantidad_Stock;
	} //getCantidad_Stock

	public void setCantidad_Stock(int cantidad_Stock) {
		this.cantidad_Stock = cantidad_Stock;
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

	public String getCategoría() {
		return categoría;
	} //getCategoria

	public void setCategoría(String categoría) {
		this.categoría = categoría;
	} //setCategoria
	
	public int getId() {
		return idLibros;
	} //getId

	@Override
	public String toString() {
		return "Libros [nombreLibro=" + nombreLibro + ", precio=" + precio + ", descripcion=" + descripcion
				+ ", cantidad_Stock=" + cantidad_Stock + ", portada=" + portada + ", autor=" + autor + ", categoría="
				+ categoría + ", idLibros=" + idLibros + "]";
	}


} //CLASS LIBROS
