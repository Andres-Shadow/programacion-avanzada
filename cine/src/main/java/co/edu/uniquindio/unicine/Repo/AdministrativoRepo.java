package co.edu.uniquindio.unicine.Repo;

import co.edu.uniquindio.unicine.Entidades.Administrativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministrativoRepo extends JpaRepository<Administrativo, Integer> {
}
