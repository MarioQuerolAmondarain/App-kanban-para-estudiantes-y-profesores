package com.proyectoDAM.rest.proyectoapi2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//Cada controlador tiene una URL distinta
@RestController
@RequestMapping("api/tarea/")

public class ApiTarea {

	@Autowired
	private TareaServicio service;
	
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
	
	//ACTUALIZACIÓN DE CÓDIGO
	//Crear una nueva tarea
	@PostMapping("crear-tarea")
	public ResponseEntity<Tarea> crearTarea(@RequestBody Tarea nuevaTarea){	
		int id=nuevaTarea.getId();
		Date fechaCreacion=new Date();
			
		List<Tarea> list=service.listTareas();
		
		for (Tarea tarea : tareas) {
			if (tarea.getId()==id) {
				//return null;//Tarea ya existe
				return null;
			}
		}
			
		nuevaTarea.setFechaCreacion(fechaCreacion.toString());
		nuevaTarea.setId(list.size()+1);
		tareas.add(nuevaTarea);
		//
		Tarea tareaCreada=service.create(nuevaTarea);
		return ResponseEntity.status(HttpStatus.OK).body(tareaCreada);
	}
	
	//Listar todas las tareas
	@GetMapping("listar-tareas")
	public ResponseEntity<List<Tarea>> listaTareas(){	
		List<Tarea> list=service.listTareas();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	//Mostrar una sola tarea
	@GetMapping("obtener-tarea")
	public ResponseEntity<Tarea> obtenerTareaById(@RequestParam int id){	
		Tarea tarea=service.getById(id).get();
		return ResponseEntity.status(HttpStatus.OK).body(tarea);
	}
	
	//Mostrar tarea por estado
	@GetMapping("tareaPorEstado")
	public ResponseEntity<List<Tarea>> obtenerTareaPorEstado(@RequestBody EstadoTarea estado){
		List<Tarea> list=new ArrayList<>();
		for (Tarea tarea : tareas) {
			if (tarea.getEstado()==estado) {
				list.add(tarea);
			}
		}
		list=service.listTareas();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	//Editar una tarea
	@PutMapping("actualizar-tarea")
	public ResponseEntity<Tarea> actualizarTarea(@RequestBody Tarea nuevaTarea) {
		int numId=nuevaTarea.getId();
		
		for (Tarea tarea : tareas) {
			//Buscará en la lista el elemento que tenga ese id
			if(tarea.getId()==numId) {
				tarea.setTitulo(nuevaTarea.getTitulo());
				tarea.setDescripcion(nuevaTarea.getDescripcion());	
				tarea.setFechaCreacion(nuevaTarea.getFechaCreacion());
				tarea.setFechaLimite(nuevaTarea.getFechaLimite());
				tarea.setEstado(nuevaTarea.getEstado());
				
				tarea=service.getById(numId).get();
				return ResponseEntity.status(HttpStatus.OK).body(tarea);
			}
		}
		return null;		
	}
	
	//Eliminar tarea
	@DeleteMapping("eliminar-tarea")
	public ResponseEntity<String> borrarTarea(@RequestParam int id){
		boolean success=service.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Se ha ejecutado la operación\nResultado : "+success);
	}
}
