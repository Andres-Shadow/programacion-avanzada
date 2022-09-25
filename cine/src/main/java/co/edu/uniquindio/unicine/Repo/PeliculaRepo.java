package co.edu.uniquindio.unicine.Repo;

import co.edu.uniquindio.unicine.Entidades.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepo extends JpaRepository<Pelicula, Integer> {
}
