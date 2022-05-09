package com.proyectoDAM.rest.proyectoapi2;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")// Crea la tabla en la bd con el nombre indicado
public class Usuarios {
	@Id // esta anotacion indica que el usuario id es el unico para todos los usuarios que creemos en la BD
	private int id;
	private String name;
	private String email;
	//private String pasword;
	public Usuarios() {
		
	}
	
	public Usuarios(int id, String name, String email) {
		
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
