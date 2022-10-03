package co.edu.uniquindio.unicine.Repo;

import co.edu.uniquindio.unicine.Entidades.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepo extends JpaRepository<Ciudad, Integer> {
}
