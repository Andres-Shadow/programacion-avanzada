package co.edu.uniquindio.unicine.Repo;

import co.edu.uniquindio.unicine.Entidades.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EntradaRepo extends JpaRepository<Entrada, Integer> {
}
