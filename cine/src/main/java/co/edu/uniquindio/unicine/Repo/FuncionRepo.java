package co.edu.uniquindio.unicine.Repo;

import co.edu.uniquindio.unicine.Entidades.Funcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FuncionRepo extends JpaRepository<Funcion, Integer> {
    @Query("select f.pelicula.nombre from Funcion f where f.id = :codigoFuncion")
    String obtenerNombrePelicula(Integer codigoFuncion);

    //agregar un join para poder hacer la consulta hacía una lista
    @Query("select f.pelicula.nombre, f.pelicula.estado, f.pelicula.imagen,t.teatro.nombre, t.teatro.ciudad.nombre,h.dia  from Funcion f join f.sala.teatroSala t join f.horarios  h where f.pelicula.id =:codigoPelicula")
    List<Object[]> obtenerFuncionesPelicula(Integer codigoPelicula);
    @Query("select f from Funcion  f join f.sala.teatroSala t  where t.teatro.id =:idTeatro and f.entradas is empty ")
    List<Funcion> obtenerFuncionesSinEntrada(Integer idTeatro);
    @Query("select f from Funcion f join f.sala.teatroSala ts  join f.horarios hs where ts.teatro.id=: idTeatro and hs.inicio <:fin or hs.fin >:inicio")
    List<Funcion> obtenerFuncionesTeatroRangoFecha(Integer idTeatro, LocalDate inicio, LocalDate fin);
}
