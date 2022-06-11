package com.todotask.usuarios;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario") /* Crea la tabla en la bd con el */

public class Usuarios {

	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellido")
	private String apellido;
	// esta anotacion indica que el usuario id es el unico para todos los usuarios
	// que cremos en la BD
	@Id
	private String email;
	private String contrasena;
	// constructor vacío

	public Usuarios() {
		super();
	}

	// constructor con parametros
	public Usuarios(String nombre, String apellido, String email, String contrasena) {
		super();

		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.contrasena = contrasena;
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

	/*
	 * Metodo getSha256 se encarga de realizar un Hash de las contraseñas antes de
	 * almacenar en BD
	 */
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

}
