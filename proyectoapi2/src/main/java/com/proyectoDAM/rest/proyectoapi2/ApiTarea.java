package com.proyectoDAM.rest.proyectoapi2;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.*;
import java.util.ArrayList;
import java.util.Date;
//import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
	//ACTUALIZACIÓN DE CÓDIGO
	
	//Crear una nueva tarea
	@PostMapping("crear-tarea")
	public ResponseEntity<Tarea> crearTarea(@RequestBody Tarea nuevaTarea){	
		Long id=nuevaTarea.getId();
		// Date fechaCreacion=new Date();
			
		List<Tarea> list=service.listTareas();
		if(!list.isEmpty())
		{			
			for (Tarea tarea : list) {
				if (tarea.getId()==id) {
					return null;//Tarea ya existe
					//return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La tarea ya existe");
				}
			}
		}
		
		//De String a LocalDate
//		LocalDate ld = LocalDate.parse(nuevaTarea.getFechaLimite(), formatter);
		
		//De LocalDate a String
//		String ld_str = ld.format(formatter);
		
//		nuevaTarea.setFechaLimite(ld_str);
		
		
//		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//		nuevaTarea.setFechaLimite((Date)formatter.format(nuevaTarea.getFechaLimite()));
		
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
	public ResponseEntity<Tarea> obtenerTareaById(@RequestParam Long id){		
		Tarea tarea=service.getById(id).get();
		return ResponseEntity.status(HttpStatus.OK).body(tarea);
	}
	
	//Mostrar tarea por estado
	@GetMapping("mostrar-por-estado") 
	public ResponseEntity<List<Tarea>> obtenerTareaPorEstado(@RequestParam EstadoTarea estado){
		List<Tarea> list=service.listTareas();
		List<Tarea> listaFiltrada=new ArrayList<>();
		
		for (Tarea tarea : list) {
			if (tarea.getEstado()==estado) {
				listaFiltrada.add(tarea);
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(listaFiltrada);	
	}
	
	//Filtrar por Fecha y Estado
	//Pasar el atributo "fecha" con la hora en la que fue creada, y no con la que aparece en BBBDD que es 2 horas más
	@GetMapping("tareaPorFechaEstado") 
	public ResponseEntity<List<Tarea>> obtenerTareaPorFechaEstado(@RequestBody FechaEstado estadoFecha){
		List<Tarea> list=service.listTareas();
		List<Tarea> listaFiltrada=new ArrayList<>();
		for (Tarea tarea : list) {
			if (tarea.getEstado()==estadoFecha.getEstado() && tarea.getFechaLimite().compareTo(estadoFecha.getFecha())==0) {
				listaFiltrada.add(tarea);
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(listaFiltrada);
	}
	
	//Actualizar una tarea
	@PostMapping("actualizar-tarea")
	public ResponseEntity<Tarea> actualizarTarea(@RequestBody Tarea nuevaTarea) {
		Long numId=nuevaTarea.getId();
		List<Tarea> list=service.listTareas();
		
		for (Tarea tarea : list) {
			if (tarea.getId().equals(numId)) {
				tarea.setTitulo(nuevaTarea.getTitulo());
				tarea.setDescripcion(nuevaTarea.getDescripcion());	
				tarea.setFechaLimite(nuevaTarea.getFechaLimite());
				tarea.setEstado(nuevaTarea.getEstado());
				tarea.setPrioridad(nuevaTarea.getPrioridad());
				
				Tarea tareaCreada=service.create(nuevaTarea);
				return ResponseEntity.status(HttpStatus.OK).body(tareaCreada);
			}
		}
		return null;		
	}
	
	//Eliminar tarea
	@DeleteMapping("eliminar-tarea")
	public ResponseEntity<String> borrarTarea(@RequestParam Long id){
		boolean success=service.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
}
