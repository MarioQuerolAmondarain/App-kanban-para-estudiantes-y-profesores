package Users;

public class UsuarioRegistroDTO {
	private Long id;
	private String nombre;
	private String apellido;
	private String email;
	private String contraseña;

	public UsuarioRegistroDTO() {
		super();

	}

	public UsuarioRegistroDTO(String email) {
		super();
		this.email = email;
	}

	public UsuarioRegistroDTO(String nombre, String apellido, String email, String contraseña) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.contraseña = contraseña;
	}

	public UsuarioRegistroDTO(Long id, String nombre, String apellido, String email, String contraseña) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.contraseña = contraseña;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

}
