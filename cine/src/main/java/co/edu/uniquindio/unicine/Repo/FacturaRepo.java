package co.edu.uniquindio.unicine.Repo;

import co.edu.uniquindio.unicine.Entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepo extends JpaRepository<Factura, Integer> {
}
