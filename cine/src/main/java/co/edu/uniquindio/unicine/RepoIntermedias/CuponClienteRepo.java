package co.edu.uniquindio.unicine.RepoIntermedias;

import co.edu.uniquindio.unicine.Intermedia.CuponCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuponClienteRepo extends JpaRepository<CuponCliente, Integer> {
}
