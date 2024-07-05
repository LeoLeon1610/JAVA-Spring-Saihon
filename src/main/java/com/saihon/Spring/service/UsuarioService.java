package com.saihon.Spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saihon.Spring.dto.ChangePassword;
import com.saihon.Spring.model.Usuario;

@Service
public class UsuarioService {
	public final ArrayList<Usuario> lista = new ArrayList<Usuario>();
	
	@Autowired
	public UsuarioService() {
		Usuario usuario1 = new Usuario("Braulio Israel", "bralioiac@gmail.com", "Abc123@!");
		Usuario usuario2 = new Usuario("Leonardo León", "leonardol20@gmail.com", "Abc123@!");
		Usuario usuario3 = new Usuario("Andrea Castellanos", "andrea_cas@gmail.com", "Abc123@!");
		lista.add(usuario1);
		lista.add(usuario2);
		lista.add(usuario3);
	}
	
	public ArrayList<Usuario> getUsers() {
		return lista;
	}//GET Users
	
	public Usuario getUser(int id) {
		Usuario tmpUser = null;
		for (Usuario u : lista) {
			if(u.getId() == id) {
				tmpUser = u;
				break;
			}
		}
		return tmpUser;
	}//GET User
	
	public Usuario removeUser(int id) {
		Usuario tmpUser = null;
		for (Usuario usuario : lista) {
			if(usuario.getId()==id) {
				tmpUser=lista.remove(lista.indexOf(usuario));
				break;
			}
		}
		return tmpUser;
	}//DELETE User
	
	public Usuario addUser(Usuario newUser) {
		boolean existe=false;
		for (Usuario usuario : lista) {
			if(usuario.getEmail().equals(newUser.getEmail())) {
				existe=true;
				break;
			}
		}
		if(! existe) {
			lista.add(newUser);
			return newUser;
		} else {
			return null;
		}
	}//POST User
	
	public Usuario updateUser(ChangePassword changePassword,int id) {
		Usuario tmpUser = null;
		for (Usuario usuario : lista) {
			if(usuario.getId()==id) {
				if(changePassword.getPassword().equals(usuario.getPassword())) {
					usuario.setPassword(changePassword.getNpassword());
					tmpUser=usuario;
					
				} else {
					System.out.println("updateUser- El password del usuario ["
							+ id +" No coincide]");
					tmpUser=null;
				}
				break;
			}
		}
		
		return tmpUser;
	}//PUT User
	
}
