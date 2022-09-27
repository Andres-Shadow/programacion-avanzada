package co.edu.uniquindio.unicine.RepoIntermedias;

import co.edu.uniquindio.unicine.Intermedia.TeatroSala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeatroSalaRepo extends JpaRepository<TeatroSala, Integer> {
}
