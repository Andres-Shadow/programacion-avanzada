package co.edu.uniquindio.unicine.Repo;

import co.edu.uniquindio.unicine.Entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, Integer> {




}
