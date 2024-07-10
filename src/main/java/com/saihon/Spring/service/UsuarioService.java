package com.saihon.Spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.saihon.Spring.dto.ChangePassword;
import com.saihon.Spring.model.Usuario;
import com.saihon.Spring.repository.UsuariosRepository;

@Service
public class UsuarioService {
	private final UsuariosRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	
	@Autowired
	public UsuarioService(UsuariosRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public List<Usuario> getUsers() {
		return usuarioRepository.findAll();
	}//GET Users
	
	public Usuario getUser(Long id) {
		return usuarioRepository.findById(id).orElseThrow(()->new IllegalArgumentException("El usuario con el id ["
				+ id +"] no existe"));
	}//GET User
	
	public Usuario removeUser(Long id) {
		Usuario tmpUser = null;
		if(usuarioRepository.existsById(id)) {
			tmpUser=usuarioRepository.findById(id).get(); // El get lo saca del Optional
			usuarioRepository.deleteById(id);
		};
		return tmpUser;
	}//DELETE User
	
	public Usuario addUser(Usuario newUser) {
		Optional<Usuario> tmpUser = 
				usuarioRepository.findByEmail(newUser.getEmail());
		if (tmpUser.isEmpty()) {
			newUser.setPassword(encoder.encode(newUser.getPassword()));
			return usuarioRepository.save(newUser);
		} else {
			System.out.println("El usuario con el nombre ["
					+ newUser.getEmail() + "] ya existe");
			return null;
		}
	}//POST User
	
	public Usuario updateUser(ChangePassword changePassword,Long id) {
		Usuario tmpUser = null;
		if(usuarioRepository.existsById(id)) {
			tmpUser = usuarioRepository.findById(id).get();
			if(encoder.matches(changePassword.getPassword() , tmpUser.getPassword())) {
				tmpUser.setPassword(encoder.encode(changePassword.getNpassword()));
				usuarioRepository.save(tmpUser);
			} else {
				System.out.println("updateUser- El password del usuario ["
						+ id +"] No coincide");
				tmpUser=null;
			}
		}
		return tmpUser;
	}//PUT User
	
	public boolean validateUser(Usuario usuario) {
		Optional <Usuario> userByEmail = usuarioRepository.findByEmail(usuario.getEmail());
		if(userByEmail.isPresent()) {
			Usuario tmpUser=userByEmail.get();
			if(encoder.matches(usuario.getPassword(), tmpUser.getPassword())) {
				return true;
			}
		}
		return false;
	}
	
}
