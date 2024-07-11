package com.saihon.Spring.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;

import com.saihon.Spring.config.JwtFilter;
import com.saihon.Spring.dto.Token;
import com.saihon.Spring.model.Usuario;
import com.saihon.Spring.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@CrossOrigin(origins = "http://127.0.0.1:5502/")
@RestController
@RequestMapping(path="/api/login/")
public class LoginController {
	
	private final UsuarioService usuarioService; // Se crea una variable para acceder al servicio que contiene las tablas
	
	@Autowired
	public LoginController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@PostMapping
	public Token loginUsuario(@RequestBody Usuario usuario) throws ServletException {
		if(usuarioService.validateUser(usuario)) {
			System.out.println("Usuario valido " + usuario.getEmail());
			return new Token(generateToken(usuario.getEmail()));
		}
		throw new ServletException("Nombre de usuario o contraseña incorrectos ["
				+ usuario.getEmail() + "]");
	}
	
	private String generateToken(String username) {
		Calendar calendar = Calendar.getInstance();//Fecha hora actual
		calendar.add(Calendar.HOUR, 10); // Pruebas
		//calendar.add(Calendar.MINUTE, 30);// Producción
		return Jwts.builder().setSubject(username).claim("role", "user")
		.setIssuedAt(new Date())
		.setExpiration(calendar.getTime())
		.signWith(SignatureAlgorithm.HS256, JwtFilter.secret)
		.compact();
	}//generateToken


}
