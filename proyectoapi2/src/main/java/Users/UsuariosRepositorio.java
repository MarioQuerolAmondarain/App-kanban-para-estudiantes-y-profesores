package Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepositorio extends JpaRepository<Usuarios,Long> {

}
