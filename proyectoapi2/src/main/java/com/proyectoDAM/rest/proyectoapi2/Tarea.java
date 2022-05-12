package com.proyectoDAM.rest.proyectoapi2;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tareas") // Crea la tabla en la bd con el nombre indicado
public class Tarea {
	
	//Atributos
	@Id	//indica que es el identificador único para c/tarea que guardemos en la BD
	private int id;
	private String titulo;
	private String descripcion;
	private Date fechaLimite;
//	private Date fechaCreacion;
	private String fechaCreacion;
	private EstadoTarea estado;
	
	//Contructor sin parámetros
	public Tarea() {
		super();
	}
	
	//Constructor con parámetros
	public Tarea(int id, String titulo, String descripcion, Date fechaLimite, Date fechaCreacion, EstadoTarea estado) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaLimite = fechaLimite;
//		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	//Getters y Setters
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFechaLimite() {
		return fechaLimite;
	}
	public void setFechaLimite(Date fechaLimite) {
		this.fechaLimite = fechaLimite;
	}
//	public Date getFechaCreacion() {
//		return fechaCreacion;
//	}
//	public void setFechaCreacion(Date fechaCreacion) {
//		this.fechaCreacion = fechaCreacion;
//	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public EstadoTarea getEstado() {
		return estado;
	}
	public void setEstado(EstadoTarea estado) {
		this.estado = estado;
	}
	
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
}
