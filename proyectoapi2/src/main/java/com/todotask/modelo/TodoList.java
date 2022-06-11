package com.todotask.modelo;

/*Clase Examen se desarrolló al principio, pero luego se decidió no utilizarla*/
public class TodoList {
	
	private int numero; 
	private String nombre;
	private boolean estadoCompletado;
	private String descripcion;
	
	public TodoList() {	
		super();
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isEstadoCompletado() {
		return estadoCompletado;
	}
	public void setEstadoCompletado(boolean estadoCompletado) {
		this.estadoCompletado = estadoCompletado;
	}

}
