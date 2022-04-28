package com.proyectoDAM.rest.proyectoapi2;

import java.util.Date;

public class Examen {
	//Atributos
	private int id;
	private String titulo;
	private String descripcion; //Opcional indicando temario
	private Date fechaExamen;
	private Date fechaCreacion;
	
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
	public Date getFechaExamen() {
		return fechaExamen;
	}
	public void setFechaExamen(Date fecha) {
		this.fechaExamen = fecha;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}