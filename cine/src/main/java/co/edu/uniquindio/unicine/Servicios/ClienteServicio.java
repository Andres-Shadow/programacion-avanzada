package co.edu.uniquindio.unicine.Servicios;

import co.edu.uniquindio.unicine.Entidades.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface ClienteServicio {


    Cliente registrarCliente(Cliente idCliente) throws Exception;

    Cliente actualizarCliente(Cliente idCliente) throws Exception;

    void eliminarCliente(Integer idCliente) throws Exception;

    Cliente login(String correo, String contrasenia) throws Exception;

    Pelicula buscarPelicula (String nombre) throws Exception;


    Compra comprar (Entrada entrada, Confiteria confiteria, Cliente cliente, Cupon cupon) throws Exception;


    List<Compra> listarCompras(Integer idCliente) throws Exception;

    Cliente cambiarContrasenia(Cliente cliente, String nuevaContrasenia) throws Exception;

    Cliente buscarCliente(Integer idCliente) throws Exception;

    void agregarPuntos(Integer idCliente, Integer puntos) throws Exception;


    List<Cliente> listarClientes();

}
