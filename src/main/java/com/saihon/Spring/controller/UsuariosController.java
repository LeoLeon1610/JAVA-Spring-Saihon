package com.saihon.Spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saihon.Spring.dto.ChangePassword;
import com.saihon.Spring.model.Usuario;
import com.saihon.Spring.service.UsuarioService;

@RestController
@RequestMapping(path="/api/usuarios/")
public class UsuariosController {
	private final UsuarioService userService;
	
	@Autowired
	public UsuariosController(UsuarioService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public List<Usuario> getUsuarios(){
		return userService.getUsers();
	}//GET Users
	
	@GetMapping(path="{userID}")
	public Usuario getUsuario(@PathVariable("userID") Long id) {
		return userService.getUser(id);
	}//GET User
	
	@DeleteMapping(path="{userID}")
	public Usuario deleteUser(@PathVariable("userID") Long id) {
		return userService.removeUser(id);
	}//DELETE User
	
	@PostMapping
	public Usuario postUsuario(@RequestBody Usuario newUser) {
		return userService.addUser(newUser);
	}//POST User
	
	@PutMapping(path="{userID}")
	public Usuario putUser(@RequestBody ChangePassword changePassword,
			@PathVariable("userID") Long id) {
		return userService.updateUser(changePassword, id);
	}//PUT User
}
