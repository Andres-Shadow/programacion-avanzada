package co.edu.uniquindio.unicine.Repo;

import co.edu.uniquindio.unicine.Entidades.Confiteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfiteriaRepo extends JpaRepository<Confiteria, Integer> {
}
