package com.todotask.usuarios;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*Esta clase es un servicio que se conecta a UsuariosRepositorio y agrupa su funcionalidad.*/

@Service
public class UsuarioServicioI {

	/* llamamos al repositorio y creamos un automwired para implementar */
	@Autowired
	private UsuariosRepositorio usuarioRepo;
	
	
	public Usuarios crear(Usuarios usuario) {

		return usuarioRepo.save(usuario);

	}

	public List<Usuarios> listaUsuarios() {

		return (List<Usuarios>) usuarioRepo.findAll();

	}
	
	//Optional está diseñado para almacenar un valor o estar «vacío» si el valor no existe
	public Optional<Usuarios> getById(String email) {
		return usuarioRepo.findById(email);

	}

}
