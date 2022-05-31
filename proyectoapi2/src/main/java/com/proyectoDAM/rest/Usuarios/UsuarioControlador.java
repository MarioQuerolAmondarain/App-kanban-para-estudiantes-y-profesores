package com.proyectoDAM.rest.Usuarios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoDAM.rest.proyectoapi2.Tarea;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioControlador {
	@Autowired
	private UsuarioServicioI service;
	
	@PostMapping("crear-usuario")
	public ResponseEntity<String>crearUsuario(@RequestBody Usuarios nuevo){
		
		String email=nuevo.getEmail();
		List<Usuarios>list=service.listaUsuarios();
		if(!list.isEmpty()) {
			for (Usuarios usuarios : list) {
			
				if(usuarios.getEmail().equals(email)) {
					
					return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El usuario " + email + " ya existe");
				}
				
			}
		}
		
		
		String contrasenaEncriptada=nuevo.getSHA256(nuevo.getContraseña());
		nuevo.setContraseña(contrasenaEncriptada);
		
		Usuarios nuevoUsuario=service.crear(nuevo);
		
		return ResponseEntity.status(HttpStatus.OK).body("Se ha creado el Usuario \n" + nuevoUsuario);
	}
	
	
	@GetMapping("login-usuario")
	public ResponseEntity<String> logarUsuario(@RequestBody AuthUser userAuth){
		
		
		Usuarios usuario=service.getById(userAuth.getEmail()).get();
		String contrasenaEncriptada=Usuarios.getSHA256(userAuth.getContraseña());
		
			
				
				if (usuario.getContraseña().equals(contrasenaEncriptada)){
					return ResponseEntity.status(HttpStatus.OK).body("El login es correcto " );	
					
				}
					
		
					
			return ResponseEntity.status(HttpStatus.OK).body("El login es incorrecto \n"  );
	}	

}