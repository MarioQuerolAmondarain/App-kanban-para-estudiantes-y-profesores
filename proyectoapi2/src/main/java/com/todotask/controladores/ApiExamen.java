package com.todotask.controladores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todotask.modelo.Examen;

@RestController
@RequestMapping("api/examen/")

/*ApiExamen se desarrolló al principio, pero luego se decidió no utilizarla*/
public class ApiExamen {

	private static Collection<Examen> examenes=Collections.synchronizedCollection(new ArrayList<>());//Usar Collection para sincronizar
	
	//Listar todos los examenes
	@GetMapping("lista-examenes")
	public Collection<Examen> listarExamenes(){	
		return examenes;
	}
	
	//Mostrar un solo examen
	@GetMapping("mostrar-examen")
	public Examen mostrarExamen(@RequestParam int id) {
		for (Examen examen : examenes) {
			//Buscará en la lista el elemento que tenga ese identificador
			if(examen.getId()==id) {
				return examen;
			}
		}
		return null;
	}
	
	//Crear un nuevo examen
	@PostMapping("nuevo-examen")
	public Collection<Examen> nuevoExamen(@RequestBody Examen nuevoExamen){
		int id=nuevoExamen.getId();
		
		for (Examen examen : examenes) {
			if (examen.getId()==id) {
				return null;//Examen ya existe
			}
		}
		
		nuevoExamen.setId(examenes.size()+1);
		examenes.add(nuevoExamen);
		return examenes;
	}
	
	//Modificar un examen
	@PatchMapping("modificar-examen") //Modifica al que indica según su id
	public Examen modificarExamen(@RequestBody Examen nuevoExamen) {
		int numId=nuevoExamen.getId();
		
		for (Examen examen : examenes) {
			//Buscará en la lista el elemento que tenga ese número
			if(examen.getId()==numId) {
				examen.setTitulo(nuevoExamen.getTitulo());
				examen.setDescripcion(nuevoExamen.getDescripcion());	
				examen.setFechaCreacion(nuevoExamen.getFechaCreacion());
				examen.setFechaExamen(nuevoExamen.getFechaExamen());
				examen.setNumEvaluacion(nuevoExamen.getNumEvaluacion());
				
				return examen;
			}
		}
		return null;		
	}
	
	//Eliminar un examen
	@PostMapping("eliminar-examen")
	public Collection<Examen> eliminarExamen(@RequestParam int id){
		for (Examen examen : examenes) {
			//Buscará en la lista el elemento que tenga ese identificador
			if(examen.getId()==id) {
				examenes.remove(examen);
				return examenes;
			}
		}
		return null;
	}
}
