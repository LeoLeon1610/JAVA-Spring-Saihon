package com.saihon.Spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="usuario_id", unique=true, nullable=false)
	private Long id;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private String nombre;
	@Column(nullable=false)
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
