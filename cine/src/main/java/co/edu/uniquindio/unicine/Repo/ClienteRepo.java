package co.edu.uniquindio.unicine.Repo;

import co.edu.uniquindio.unicine.Entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, Integer> {

    @Query("select c from Cliente c where c.email = :email")
    Cliente obtener(String email);
    @Query("select c from Cliente c where c.email = :email and c.contrasenia= :contrasenia")
    Cliente comprobarAutenticacion(String email, String contrasenia);

}
