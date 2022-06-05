package com.proyectoDAM.rest.Usuarios;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(name = "usuario"/*, uniqueConstraints = @UniqueConstraint(columnNames = "email")*/) // Crea la tabla en la bd con el
																						// nombre indicado y la
																						// constraint
public class Usuarios {
	// esta anotacion indica que el usuario id es el unico para todos los usuarios
		// que creemos en la BD
	@GeneratedValue(strategy = GenerationType.IDENTITY) // es un incrementable el ID por eso tiene estrategia

	private Long id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellido")
	private String apellido;
	@Id
	private String email;
	private String contrasena;
	/*
	 * se va a relacionar el id del usuario con el id de rol por una tabla
	 * intermedia, un usuario puede tener varios roles.
	 */
//	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id"))

//	private Collection<Rol> roles;
	// constructor completo



	// constructor vacío

	public Usuarios() {
		super();
	}

	public Usuarios(Long id, String nombre, String apellido, String email, String contrasena) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.contrasena = contrasena;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		
		
		return contrasena;
	}

	public void setContraseña(String contrasena) {
	
		this.contrasena = contrasena;
	}
	
	public static String getSHA256(String contrasena) {

		try {
			MessageDigest md = MessageDigest.getInstance("SHA3-256");
			byte[] messageDigest = md.digest(contrasena.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);

			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

//	public Collection<Rol> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(Collection<Rol> roles) {
//		this.roles = roles;
//	}

}
