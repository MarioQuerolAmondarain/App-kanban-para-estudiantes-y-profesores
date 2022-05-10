package Users;
import com.proyectoDAM.rest.proyectoapi2.InterfazBD;

import com.proyectoDAM.rest.proyectoapi2.Proyectoapi2Application;

import clasesDistintas.TodoList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/usuarios/")
public class ApiUsuarios {
	@Autowired
	
	private static Collection<Usuarios> usuario= Collections.synchronizedCollection(new ArrayList<>());
	
	
	@GetMapping ("test")
	
	public ResponseEntity<String> Testget(){
		
		return ResponseEntity.status(HttpStatus.OK).body("TestGet ejecutado");
		
	}
	
	@PostMapping ("test")
	
	public ResponseEntity<String> TestPost(){
		
		return ResponseEntity.status(HttpStatus.OK).body("TestPost ejecutado");
		
	}
	
	@PostMapping
	public ResponseEntity<Usuarios> crearUsuario(@RequestBody Usuarios nuevoUsuario){
		
		Usuarios createdUser.createdUser
		return null;
		
		
	}
	
}
