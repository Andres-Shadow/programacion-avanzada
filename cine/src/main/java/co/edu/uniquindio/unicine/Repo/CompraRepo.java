package co.edu.uniquindio.unicine.Repo;

import co.edu.uniquindio.unicine.Entidades.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepo extends JpaRepository<Compra, Integer> {
}
