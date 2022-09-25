package co.edu.uniquindio.unicine.Repo;

import co.edu.uniquindio.unicine.Entidades.Funcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionRepo extends JpaRepository<Funcion, Integer> {
}
