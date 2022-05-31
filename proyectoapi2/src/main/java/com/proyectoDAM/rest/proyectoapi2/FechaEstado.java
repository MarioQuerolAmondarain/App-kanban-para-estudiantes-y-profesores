package com.proyectoDAM.rest.proyectoapi2;

import java.util.Date;

public class FechaEstado {
	//Atributos
	private Date fecha;
	private EstadoTarea estado;
	
	//Getters and Setters
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public EstadoTarea getEstado() {
		return estado;
	}
	public void setEstado(EstadoTarea estado) {
		this.estado = estado;
	}
	
	
}
