package com.todotask.usuarios;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todotask.tareas.Tarea;
import com.todotask.usuarios.Usuarios;
import com.todotask.usuarios.UsuariosRepositorio;

/*Esta clase es un servicio que se conecta a UsuariosRepositorio y agrupa su funcionalidad.*/

@Service
public class UsuarioServicioI{
	
	// llamamos al repositorio y creamos un automwired para implementar
	@Autowired
	private UsuariosRepositorio usuarioRepo;
	


	public Usuarios crear(Usuarios usuario) {

//		Usuarios usuario= new Usuarios(registroDTO.getNombre(),registroDTO.getApellido(),
//				registroDTO.getEmail(),registroDTO.getContraseña());
		
		return usuarioRepo.save(usuario);
		
	}
	
	public List<Usuarios>listaUsuarios(){
		
		
		return  (List<Usuarios>) usuarioRepo.findAll();
		
		
	}
	
	public Optional<Usuarios> getById(String email) {
		return usuarioRepo.findById(email);
		
		
		
	}
	

	
	
	


	

}
