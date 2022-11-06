package co.edu.uniquindio.unicine.Repo;

import co.edu.uniquindio.unicine.Dto.HorarioSalaDTIO;
import co.edu.uniquindio.unicine.Entidades.Cliente;
import co.edu.uniquindio.unicine.Entidades.Pelicula;
import co.edu.uniquindio.unicine.Tipos.Genero_Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeliculaRepo extends JpaRepository<Pelicula, Integer> {

    @Query("select p from Pelicula p where p.nombre like concat('%',:cadena,'%')")
    List<Pelicula> obtenerPelicualPorPalabra(String cadena);
    /*@Query("select new co.edu.uniquindio.unicine.Dto.HorarioSalaDTIO(f.horarios, f.sala) from Pelicula p join p.funciones f join f.sala.teatroSala ts where p.id=:idPelicula and ts.teatro.id=:idTeatro ")
    List<HorarioSalaDTIO> listarHorario(Integer idPelicula, Integer idTeatro);*/
    @Query("select p from Pelicula  p where p.genero=:genero order by p.nombre asc")
    List<Pelicula> listarPeliculas(Genero_Pelicula genero);
    @Query("select p from Pelicula p where p.nombre = :nombre")
    Pelicula obtenerPorNombre(String nombre);

}
