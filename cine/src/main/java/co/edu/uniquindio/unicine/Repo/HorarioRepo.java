package co.edu.uniquindio.unicine.Repo;

import co.edu.uniquindio.unicine.Entidades.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepo extends JpaRepository<Horario, Integer> {
}
