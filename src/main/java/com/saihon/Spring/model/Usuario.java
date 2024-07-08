package com.saihon.Spring.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idUsuario", unique=true, nullable=false)
	private Long id;
	@Column(name="CorreoElectronico",nullable=false)
	private String email;
	@Column(name="NombreUsuario",nullable=false)
	private String nombre;
	@Column(name="Password",nullable=false)
	private String password;

	public Usuario(String email, String nombre, String password) {
		this.email = email;
		this.nombre = nombre;
		this.password = password;
	}// Constructor
	
	public Usuario() {
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

	public Long getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Usuario [email=" + email + ", nombre=" + nombre + ", password=" + password + ", id=" + id + "]";
	}
	
}
