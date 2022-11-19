package co.edu.uniquindio.unicine.Repo;

import co.edu.uniquindio.unicine.Entidades.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, Integer> {

    @Query("select c from Cliente c where c.email = :email")
    Cliente obtenerPorCorreo(String email);
    @Query("select c from Cliente c where c.email = :email and c.contrasenia= :contrasenia")
    Cliente comprobarAutenticacion(String email, String contrasenia);
    @Query("select c from Cliente c where c.id = :idCliente")
    Cliente obtenerCliente(Integer idCliente);
    @Query("select comp from Cliente cli, in(cli.compras) comp where cli.email =:correo")
    List<Compra> obtenerComrpa(String correo);
    @Query("select liscup.cupon from Cliente cli join cli.cupones liscup where cli.email= :email")
    List<Cupon> obtenerListaCupones(String email);
    @Query("select c from Compra c where c.cliente.id=:idCliente")
    List<Compra> listarCompras(Integer idCliente);
    @Query("select p from Pelicula p where p.nombre=:nombrePelicula")
    Pelicula buscarPelicula(String nombrePelicula);
    @Query("select e from Entrada e where e.id=:idEntrada")
    Entrada buscarEntrada(Integer idEntrada);
    @Query("select c from Confiteria c where c.id=:idConfiteria")
    Confiteria buscarConfiteria(Integer idConfiteria);
    @Query("select liscup.cupon from Cliente cli join cli.cupones liscup where cli.cupones= :idCupon")
    Cupon obtenerCupon(Integer idCupon);

    @Query("select c from Cliente c where c.email=:email")
    Cliente findByEmail(String email);


}
