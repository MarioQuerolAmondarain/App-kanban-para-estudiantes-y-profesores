package com.todotask.modelo;

import java.util.Date;

/*Clase Examen se desarrolló al principio, pero luego se decidió no utilizarla*/
public class Examen {
	//Atributos
	private int id;
	private String titulo;
	private String descripcion; //Opcional indicando temario
	private Date fechaExamen;
	private Date fechaCreacion;
	private int numEvaluacion;
	
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
	public int getNumEvaluacion() {
		return numEvaluacion;
	}
	public void setNumEvaluacion(int numEvaluacion) {
		this.numEvaluacion = numEvaluacion;
	}
}
