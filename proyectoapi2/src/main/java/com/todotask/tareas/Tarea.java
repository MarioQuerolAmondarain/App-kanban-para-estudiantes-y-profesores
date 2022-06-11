package com.todotask.tareas;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tareas")
public class Tarea {

	@Id
	
	//Indica una columna con incremento automático, entonces la BD genera un nuevo valor con cada inserción.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String descripcion;
	private Date fechaLimite;
	private EstadoTarea estado;
	private PrioridadTareas prioridad;
	
	//Constructor sin parámetros
	public Tarea() {
		super();
	}

	//Constructor con parámetros
	public Tarea(Long id, String titulo, String descripcion, Date fechaLimite, EstadoTarea estado, PrioridadTareas prioridad) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaLimite = fechaLimite;
		this.estado = estado;
		this.prioridad = prioridad;
	}

	//Getters and Setters
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public EstadoTarea getEstado() {
		return estado;
	}
	public void setEstado(EstadoTarea estado) {
		this.estado = estado;
	}
	public PrioridadTareas getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(PrioridadTareas prioridad) {
		this.prioridad = prioridad;
	}
}
