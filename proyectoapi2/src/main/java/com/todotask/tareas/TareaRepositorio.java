package com.todotask.tareas;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepositorio extends CrudRepository<Tarea,Long> {

}
