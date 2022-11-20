package co.edu.uniquindio.unicine.Repo;

import co.edu.uniquindio.unicine.Entidades.*;
import co.edu.uniquindio.unicine.Tipos.Tipo_Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministrativoRepo extends JpaRepository<Administrativo, Integer> {

    @Query("select a from Administrativo a where a.correo = :correo and a.contrasenia= :contrasenia")
    Administrativo ComprobarAutenticacion(String correo, String contrasenia);

    @Query("select a from Administrativo a where a.cedula = :cedula")
    Administrativo obtenerPorCedula(String cedula);

    //listamos todos los teatros creados
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

    @Query("select c from Ciudad c")
    List<Ciudad> ListarCiudad();

    @Query("select s from Sala s")
    List<Sala> ListarSala();

    @Query("select f from Funcion f")
    List<Funcion> ListarFuncion();

    @Query("select c from Ciudad c where c.id = :idCiudad")
    Ciudad obtenerCiudadPorid(Integer idCiudad);

    @Query("select t from Teatro t where t.id = :idTeatro")
    Teatro obtenerTeatroPorid(Integer idTeatro);

    @Query("select c from Cupon c where c.id = :idCupon")
    Cupon obtenerCuponPorid(Integer idCupon);

    @Query("select c from Confiteria c where c.id = :idConfiteria")
    Confiteria obtenerConfiteriaPorid(Integer idConfiteria);

    @Query("select p from Pelicula p where p.id = :idPelicula")
    Pelicula obtenerPeliculaPorid(Integer idPelicula);

    @Query("select a from Administrativo a where a.correo = :idCorreo")
    Administrativo obtenerAdminPorCorreo(String idCorreo);

    @Query("select f from Funcion f where f.id = :idfuncion")
    Funcion obtenerFuncionPorId(Integer idfuncion);

    @Query("select s from Sala s where s.id = :idsala")
    Sala obtenerSalaPorId(Integer idsala);

    @Query("select a from Administrativo  a where a.id=:id and a.tipo=:tipo")
    Administrativo obtenerAdminTeatroPorId(Integer id, Tipo_Admin tipo);

}
