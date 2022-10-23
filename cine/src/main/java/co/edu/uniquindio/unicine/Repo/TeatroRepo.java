package co.edu.uniquindio.unicine.Repo;

import co.edu.uniquindio.unicine.Entidades.Teatro;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeatroRepo extends JpaRepository<Teatro, Integer> {
    @Query("select t.ciudad.nombre from Teatro t where t.id= :id")
    String obtenerCiudadTeatro(Integer id);
    @Query("select c.id, c.nombre, count(t) from Teatro t join t.ciudad c group by c.id")
    List<Object[]> contarTeatros();

    /*
    OTRA FORMA DE HACER LO ANTRIOR
    @Query("select t.ciudad.id, t.ciudad.nombre, count(t) from Teatro t group by t.ciudad")
     */
}
