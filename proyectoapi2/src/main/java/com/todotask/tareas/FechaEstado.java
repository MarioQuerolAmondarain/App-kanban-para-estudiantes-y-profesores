package com.todotask.tareas;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FechaEstado {
	//Atributos
	private Date fecha;
	private EstadoTarea estado;
	
	public boolean mismoDia(Date fechaComprobar) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(this.fecha).equals(sdf.format(fechaComprobar));
	}
	
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
