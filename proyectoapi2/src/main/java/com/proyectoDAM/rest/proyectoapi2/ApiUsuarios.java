package com.proyectoDAM.rest.proyectoapi2;

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
	
	private Usuarios service;
	
	
	
	@GetMapping ("test")
	
	public ResponseEntity<String> Testget(){
		
		return ResponseEntity.status(HttpStatus.OK).body("TestGet ejecutado");
		
	}
	
	@PostMapping ("test")
	
	public ResponseEntity<String> TestPost(){
		
		return ResponseEntity.status(HttpStatus.OK).body("TestPost ejecutado");
		
	}
	
	@PostMapping ("test")
	
	public ResponseEntity<String> CreateUsers(@RequestBody Usuarios user){
		
		
		
		return ResponseEntity.status(HttpStatus.OK).body("TestPost ejecutado");
		
	}
	
	
	
}
