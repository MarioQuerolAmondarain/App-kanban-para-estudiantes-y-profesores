package com.todotask.controladores;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.todotask.tareas.EstadoTarea;
import com.todotask.tareas.FechaEstado;
import com.todotask.tareas.Tarea;
import com.todotask.tareas.TareaServicio;

@RestController
@RequestMapping("api/tarea/")

public class ApiTarea {

	@Autowired
	private TareaServicio service;

	// Crear una nueva tarea
	@PostMapping("crear-tarea")
	public ResponseEntity<Tarea> crearTarea(@RequestBody Tarea nuevaTarea) {
		Long id = nuevaTarea.getId();

		List<Tarea> list = service.listTareas();
		if (!list.isEmpty()) {
			for (Tarea tarea : list) {
				if (tarea.getId() == id) {
					return null;// Tarea ya existe
				}
			}
		}

		Tarea tareaCreada = service.create(nuevaTarea);
		return ResponseEntity.status(HttpStatus.OK).body(tareaCreada);
	}

	// Listar todas las tareas
	@GetMapping("listar-tareas")
	public ResponseEntity<List<Tarea>> listaTareas() {
		List<Tarea> list = service.listTareas();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}

	// Mostrar una sola tarea por id
	@GetMapping("obtener-tarea")
	public ResponseEntity<Tarea> obtenerTareaById(@RequestParam Long id) {
		Tarea tarea = service.getById(id).get();
		return ResponseEntity.status(HttpStatus.OK).body(tarea);
	}

	// Mostrar tareas según el estado
	@GetMapping("mostrar-por-estado")
	public ResponseEntity<List<Tarea>> obtenerTareaPorEstado(@RequestParam EstadoTarea estado) {
		List<Tarea> list = service.listTareas();
		List<Tarea> listaFiltrada = new ArrayList<>();

		for (Tarea tarea : list) {
			if (tarea.getEstado() == estado) {
				listaFiltrada.add(tarea);
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(listaFiltrada);
	}

	// Filtrar tareas por Fecha y Estado
	@PostMapping("tareaPorFechaEstado")
	public ResponseEntity<List<Tarea>> obtenerTareaPorFechaEstado(@RequestBody FechaEstado estadoFecha) {
		List<Tarea> list = service.listTareas();
		List<Tarea> listaFiltrada = new ArrayList<>();
		for (Tarea tarea : list) {
			if (tarea.getEstado() == estadoFecha.getEstado() && estadoFecha.mismoDia(tarea.getFechaLimite())) {
				listaFiltrada.add(tarea);
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(listaFiltrada);
	}

	// Actualizar una tarea
	@PostMapping("actualizar-tarea")
	public ResponseEntity<Tarea> actualizarTarea(@RequestBody Tarea nuevaTarea) {
		Long numId = nuevaTarea.getId();
		List<Tarea> list = service.listTareas();

		for (Tarea tarea : list) {
			if (tarea.getId().equals(numId)) {
				tarea.setTitulo(nuevaTarea.getTitulo());
				tarea.setDescripcion(nuevaTarea.getDescripcion());
				tarea.setFechaLimite(nuevaTarea.getFechaLimite());
				tarea.setEstado(nuevaTarea.getEstado());
				tarea.setPrioridad(nuevaTarea.getPrioridad());

				Tarea tareaCreada = service.create(nuevaTarea);
				return ResponseEntity.status(HttpStatus.OK).body(tareaCreada);
			}
		}
		return null;
	}

	// Eliminar una tarea por id
	@DeleteMapping("eliminar-tarea")
	public ResponseEntity<String> borrarTarea(@RequestParam Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
}
