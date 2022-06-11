package com.todotask.usuarios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*CrudRepository es una interfaz de datos Spring, para poder usarla creamos una interfaz que herede de ella. 
 * CrudRepository tiene métodos genéricos para la operación CRUD.*/

@Repository
public interface UsuariosRepositorio extends CrudRepository<Usuarios,String> {

}
