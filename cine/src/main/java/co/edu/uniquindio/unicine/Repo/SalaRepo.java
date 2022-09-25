package co.edu.uniquindio.unicine.Repo;

import co.edu.uniquindio.unicine.Entidades.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepo extends JpaRepository<Sala, Integer> {
}
