package Users;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoApiUsuarios {

	public static void main(String[] args) throws SQLException {
	
		SpringApplication.run(Users.ProyectoApiUsuarios.class, args);
	
	}
}
