package co.edu.uniquindio.unicine.Repo;

import co.edu.uniquindio.unicine.Entidades.Teatro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeatroRepo extends JpaRepository<Teatro, Integer> {

}
