package com.proyectoDAM.rest.proyectoapi2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//Cada controlador tiene una URL distinta
@RestController
@RequestMapping("api/tarea/")	//Es la URL (el mapping)

public class ApiTarea {

	private static Collection<Tarea> tareas=Collections.synchronizedCollection(new ArrayList<>());//Usar Collection para sincronizar
	
	//Listar todas las tareas
	@GetMapping("lista-tareas")//Pide algo
	public Collection<Tarea> listarTareas(){	
		return tareas;
	}
	
	//Listar una tarea
	@GetMapping("mostrar-tarea")
	public Tarea mostrarTarea(@RequestParam int id) {
		for (Tarea tarea : tareas) {
			//Buscará en la lista el elemento que tenga ese identificador
			if(tarea.getId()==id) {
				return tarea;
			}
		}
		return null;		
	}
	
	//Crear una nueva tarea
	@PostMapping("nueva-tarea")//Envío de Datos
	public Collection<Tarea> nuevaTarea(@RequestBody Tarea nuevaTarea){
		int id=nuevaTarea.getId();
		Date fechaCreacion=new Date();
		
		for (Tarea tarea : tareas) {
			if (tarea.getId()==id) {
				return null;//Tarea ya existe
			}
		}
		
		nuevaTarea.setFechaCreacion(fechaCreacion.toString());
		nuevaTarea.setId(tareas.size()+1);
		tareas.add(nuevaTarea);
		return tareas;
	}
	
	//Editar una tarea
	@PatchMapping("modificar-tarea") //Modifica al que indica
	public Tarea modificarTarea(@RequestBody Tarea nuevaTarea) {
		int numId=nuevaTarea.getId();
		
		for (Tarea tarea : tareas) {
			//Buscará en la lista el elemento que tenga ese número
			if(tarea.getId()==numId) {
				tarea.setTitulo(nuevaTarea.getTitulo());
				tarea.setDescripcion(nuevaTarea.getDescripcion());	
				tarea.setFechaCreacion(nuevaTarea.getFechaCreacion());
				tarea.setFechaLimite(nuevaTarea.getFechaLimite());
				
				return tarea;
			}
		}
		return null;		
	}
	
	//Eliminar tarea
	@PostMapping("eliminar-tarea")
	public Collection<Tarea> eliminarTarea(@RequestParam int id){
		for (Tarea tarea : tareas) {
			//Buscará en la lista el elemento que tenga ese identificador
			if(tarea.getId()==id) {
				tareas.remove(tarea);
				return tareas;
			}
		}
		return null;
	}
}
