package com.proyectoDAM.rest.proyectoapi2;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.proyectoDAM.rest.Usuarios.*;

@SpringBootApplication
public class Proyectoapi2Application {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(Proyectoapi2Application.class, args);
		SpringApplication.run(ProyectoApiUsuarios.class, args);
		
	}
	


}
