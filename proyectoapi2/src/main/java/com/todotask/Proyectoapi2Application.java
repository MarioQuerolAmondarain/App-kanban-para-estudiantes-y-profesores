package com.todotask;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class Proyectoapi2Application {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(Proyectoapi2Application.class, args);

	}

}
