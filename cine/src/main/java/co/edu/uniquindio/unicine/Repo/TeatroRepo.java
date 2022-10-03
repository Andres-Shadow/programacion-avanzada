package co.edu.uniquindio.unicine.Repo;

import co.edu.uniquindio.unicine.Entidades.Teatro;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeatroRepo extends JpaRepository<Teatro, Integer> {
    @Query("select t.ciudad.nombre from Teatro t where t.id= :id")
    String obtenerCiudadTeatro(Integer id);
}
