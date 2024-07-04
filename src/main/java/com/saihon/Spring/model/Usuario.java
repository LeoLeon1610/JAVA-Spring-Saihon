package com.saihon.Spring.model;

public class Usuario {
	private String email;
	private String nombre;
	private String password;
	private int id;
	private static int total=0;

	public Usuario(String email, String nombre, String password) {
		this.email = email;
		this.nombre = nombre;
		this.password = password;
		Usuario.total++;
		this.id = total;
	}// Constructor
	
	public Usuario() {
		Usuario.total++;
		this.id=total;
	}//Constructor Vacío

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Usuario [email=" + email + ", nombre=" + nombre + ", password=" + password + ", id=" + id + "]";
	}
	
}
