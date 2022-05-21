package com.proyectoDAM.rest.proyectoapi2;

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
		
	//ACTUALIZACIÓN DE CÓDIGO
	
	//Crear una nueva tarea
	@PostMapping("crear-tarea")
	public ResponseEntity<Tarea> crearTarea(@RequestBody Tarea nuevaTarea){	
		String id=nuevaTarea.getId();
		// Date fechaCreacion=new Date();
			
		List<Tarea> list=service.listTareas();
		if(!list.isEmpty())
		{			
			for (Tarea tarea : list) {
				if (tarea.getId()==id) {
					return null;//Tarea ya existe
				}
			}
		}
		//TODO: Increment automatic of id en BD
		int n;
		if(list.size() > 0) {
			n = Integer.parseInt(list.get(list.size()-1).getId());			
		} else {
			n = 0;
		}
		//int tamañoLista=list.size()+1;	
		//nuevaTarea.setFechaCreacion(fechaCreacion.toString());
		nuevaTarea.setId(String.valueOf(n+1));
		
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
	public ResponseEntity<Tarea> obtenerTareaById(@RequestParam String id){	
		Tarea tarea=service.getById(id).get();
		return ResponseEntity.status(HttpStatus.OK).body(tarea);
	}
	
	//Mostrar tarea por estado
//	@GetMapping("tareaPorEstado")
//	public ResponseEntity<List<Tarea>> obtenerTareaPorEstado(@RequestBody EstadoTarea estado){
//		List<Tarea> list=new ArrayList<>();
//		for (Tarea tarea : tareas) {
//			if (tarea.getEstado()==estado) {
//				list.add(tarea);
//			}
//		}
//		list=service.listTareas();
//		return ResponseEntity.status(HttpStatus.OK).body(list);
//	}
	
	//Actualizar una tarea
	@PatchMapping("actualizar-tarea")
	public ResponseEntity<Tarea> actualizarTarea(@RequestBody Tarea nuevaTarea) {
		String numId=nuevaTarea.getId();
		List<Tarea> list=service.listTareas();
		
		for (Tarea tarea : list) {
			if (tarea.getId().equals(numId)) {
				tarea.setTitulo(nuevaTarea.getTitulo());
				tarea.setDescripcion(nuevaTarea.getDescripcion());	
				//tarea.setFechaCreacion(nuevaTarea.getFechaCreacion());
				tarea.setFechaLimite(nuevaTarea.getFechaLimite());
				tarea.setEstado(nuevaTarea.getEstado());
							
//				Tarea tareaActualizada=service.getById(numId).get();
				Tarea tareaCreada=service.create(nuevaTarea);
				return ResponseEntity.status(HttpStatus.OK).body(tareaCreada);
			}
		}
		return null;		
	}
	
	//Eliminar tarea
	@DeleteMapping("eliminar-tarea")
	public ResponseEntity<String> borrarTarea(@RequestParam String id){
		boolean success=service.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Se ha ejecutado la operación\nResultado : "+success);
	}
}
