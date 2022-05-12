package com.proyectoDAM.rest.proyectoapi2;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public Optional<Tarea> getById(int id) {
		String identificador=String.valueOf(id);
		return repo.findById(identificador);
	}
	
	public boolean deleteById(int id) {
		try {
			String identificador=String.valueOf(id);
			repo.deleteById(identificador);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
