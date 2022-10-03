package co.edu.uniquindio.unicine.Repo;

import co.edu.uniquindio.unicine.Entidades.Funcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionRepo extends JpaRepository<Funcion, Integer> {
    @Query("select f.pelicula.nombre from Funcion f where f.id = :codigoFuncion")
    String obtenerNombrePelicula(Integer codigoFuncion);

    //agregar un join para poder hacer la consulta hacía una lista
    @Query("select f.pelicula.nombre, f.pelicula.estado, f.pelicula.imagen,t.teatro.nombre, t.teatro.ciudad.nombre,h.dia  from Funcion f left join f.sala.teatroSala t left join f.horarios  h where f.pelicula.id =:codigoPelicula")
    List<Object[]> obtenerFuncionesPelicula(Integer codigoPelicula);
}
