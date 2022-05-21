package Users;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rol")
public class Rol {

	@Id // esta anotacion indica que el usuario id es el unico para todos los usuarios
		// que creemos en la BD
	@GeneratedValue(strategy = GenerationType.IDENTITY) // es un incrementable el ID por eso tiene estrategia

	private Long id;
	private String nombre;
	
	
	

	public Rol(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Rol() {

	}

	public Rol(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
