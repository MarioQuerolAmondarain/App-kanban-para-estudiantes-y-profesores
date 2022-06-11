package com.todotask.tareas;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*Esta clase es un servicio que se conecta a TareaRepositorio y agrupa su funcionalidad.*/

@Service
public class TareaServicio {

	@Autowired
	private TareaRepositorio repo;
	
	public Tarea create(Tarea tarea) {
		return repo.save(tarea);	
	}
	
	public List<Tarea> listTareas(){
		return (List<Tarea>) repo.findAll();
	}
	
	//Optional está diseñado para almacenar un valor o estar «vacío» si el valor no existe
	public Optional<Tarea> getById(Long id) {
		return repo.findById(id);
	}
	
	public boolean deleteById(Long id) {
		try {
			repo.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
