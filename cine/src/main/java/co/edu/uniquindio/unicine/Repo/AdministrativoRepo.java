package co.edu.uniquindio.unicine.Repo;

import co.edu.uniquindio.unicine.Entidades.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministrativoRepo extends JpaRepository<Administrativo, Integer> {

    @Query("select a from Administrativo a where a.cedula = :cedula")
    Administrativo obtenerPorCedula(String cedula);

    @Query("select t from Teatro t")
    List<Teatro> ListarTeatros();

    @Query("select c from Cupon c")
    List<Cupon> ListarCupones();

    @Query("select c from Confiteria c")
    List<Confiteria> ListarConfiteria();

    @Query("select p from Pelicula p")
    List<Pelicula> ListarPeliculas();

    @Query("select a from Administrativo a")
    List<Administrativo> ListarAdminsTeatro();
}
