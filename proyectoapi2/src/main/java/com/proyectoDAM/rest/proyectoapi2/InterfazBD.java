package com.proyectoDAM.rest.proyectoapi2;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InterfazBD extends CrudRepository<Usuarios,String>{

}
