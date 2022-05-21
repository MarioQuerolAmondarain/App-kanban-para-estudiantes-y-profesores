package clasesDistintas;
import java.util.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.proyectoDAM.rest.proyectoapi2.Proyectoapi2Application;
@RestController 
@RequestMapping("api/todoList/")



public class TodoListRest {
	
	private static Collection<TodoList> elemento= Collections.synchronizedCollection(new ArrayList<>());	

	/**
	 * Incluir todas las tareas
	 * @param nuevo
	 * @return
	 */
	@PostMapping("crear-lista")
	public Collection<TodoList> incluirTareas(@RequestBody TodoList nuevo ){
		nuevo.setNumero(elemento.size()+1);
		elemento.add(nuevo);
		return elemento;
	}	
	
	/**
	 * Metodo que devuelve todas las tareas
	 * @return
	 */
	@GetMapping("Mostrar-lista")
	public Collection<TodoList> listarTodasTareas(){	
		return elemento;
	}
	/**
	 * Devolver tarea por identificador numero de la clase TodoList
	 */
	@GetMapping("Mostrar-item")
	public TodoList listarItem(@RequestParam int n){
		
		for (TodoList todoList : elemento) {
			
			if(todoList.getNumero()==n) {
				
				return todoList;
			}

		}
		
		return null;	
	}
	/**
	 * Realiza la modificacion o Update de una de las tareas de la lista. Localiza la tarea a modificar por el numero de la lista
	 * @param UpdateItem
	 * @return
	 */
	@PatchMapping("Actualizar-item") 
	public TodoList ActualizaItem(@RequestBody TodoList nuevoItem) {
		int numItem=nuevoItem.getNumero();
		
		for (TodoList todoList : elemento) {
			//Buscará en la lista el elemento que tenga ese número
			if(todoList.getNumero()==numItem) {
				
				//todoList.setNumero(nuevoItem.getNumero());
				todoList.setNombre(nuevoItem.getNombre());
				todoList.setDescripcion(nuevoItem.getDescripcion());
				todoList.setEstadoCompletado(nuevoItem.isEstadoCompletado());
				return todoList;
				
			}
		}
			return null;		
	}
	/**
	 * Realiza la modificacion o Update del estado de una de las tareas de la lista. Localiza la tarea a modificar por el numero de la lista
	 * @param estadoCompletado 
	 * @param UpdateEstado
	 * @return
	 */
	@PatchMapping("Actualizar-estado")
	public TodoList ActualizaEstado(@RequestParam int n) {
		
		for (TodoList todoList : elemento) {
			
			if(todoList.getNumero()==n) {
				
				boolean completado=todoList.isEstadoCompletado();
				todoList.setEstadoCompletado(!completado);
				return todoList;
			}
		}
			
			return null;
	}
	/**
	 * Elimina de la lista el elemento por id que se desea eliminar
	 * @param estadoCompletado 
	 * @param DeleteEstado
	 * @return
	 */
	
	@GetMapping("eliminar-item")
	public Collection<TodoList> DeleteEstado(@RequestParam int n){	
		for (TodoList todoList : elemento) {
			if(todoList.getNumero()==n) {
				
				elemento.remove(todoList);
				return elemento;
				
			}
		}
				
		return null;	
	}
}
