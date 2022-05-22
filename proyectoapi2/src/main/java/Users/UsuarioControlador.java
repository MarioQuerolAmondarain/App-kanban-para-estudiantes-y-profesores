package Users;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





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
		Usuarios nuevoUsuario=service.crear(nuevo);
		
		return ResponseEntity.status(HttpStatus.OK).body("Se ha creado el Usuario");
	}
	
	
	
	
}