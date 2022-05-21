package Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/usuarios")
public class UsuarioControlador {
	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@ModelAttribute("usuario")// devuelve el usuario nuevo
	public UsuarioRegistroDTO devuelveUsuarioNuevo() {
		return new UsuarioRegistroDTO();
		
	}
	@GetMapping // muestra el formulario de registro
	
	public String mostrarFormularioRegistro() {
		
		return "registro";
		
	}
	@PostMapping // registra el usuario y lo guarda
	public String registrarUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO) {
		usuarioServicio.guardar(registroDTO);
		return "redirect:/registro exito";
		
	}
	


}
