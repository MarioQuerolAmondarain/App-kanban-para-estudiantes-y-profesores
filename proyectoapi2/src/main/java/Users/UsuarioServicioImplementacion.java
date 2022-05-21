package Users;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicioImplementacion implements UsuarioServicio{
	
	// llamamos al repositorio y creamos un automwired para implementar
	@Autowired
	private UsuariosRepositorio usuarioRepositorio;
	

//	public UsuarioServicioImplementacion(UsuariosRepositorio usuarioRepositorio) {
//		super();
//		this.usuarioRepositorio = usuarioRepositorio;
//	}



	public Usuarios guardar(UsuarioRegistroDTO registroDTO) {

		Usuarios usuario= new Usuarios(registroDTO.getNombre(),registroDTO.getApellido(),
				registroDTO.getEmail(),registroDTO.getContraseña(),Arrays.asList(new Rol("ROLE_USER")));
		
		return usuarioRepositorio.save(usuario);
		
	}
	

}
