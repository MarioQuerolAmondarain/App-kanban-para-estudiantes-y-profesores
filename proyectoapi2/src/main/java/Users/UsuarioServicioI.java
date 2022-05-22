package Users;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicioI{
	
	// llamamos al repositorio y creamos un automwired para implementar
	@Autowired
	private UsuariosRepositorio usuarioRepo;
	


	public Usuarios crear(Usuarios usuario) {

//		Usuarios usuario= new Usuarios(registroDTO.getNombre(),registroDTO.getApellido(),
//				registroDTO.getEmail(),registroDTO.getContraseña());
		
		return usuarioRepo.save(usuario);
		
	}
	
	public List<Usuarios>listaUsuarios(){
		
		
		return  (List<Usuarios>) usuarioRepo.findAll();
		
		
	}
	
	
	


	

}
