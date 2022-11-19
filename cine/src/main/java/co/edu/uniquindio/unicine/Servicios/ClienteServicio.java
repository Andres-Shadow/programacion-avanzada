package co.edu.uniquindio.unicine.Servicios;

import co.edu.uniquindio.unicine.Entidades.*;

import java.util.List;
import java.util.Optional;

public interface ClienteServicio {


    Cliente registrarCliente(Cliente idCliente) throws Exception;

    Cliente actualizarCliente(Cliente idCliente) throws Exception;

    void eliminarCliente(Integer idCliente) throws Exception;

    Cliente login(String correo, String contra)throws Exception;

    Pelicula buscarPelicula (String nombre) throws Exception;

    Compra comprar(Entrada entrada, Optional<Confiteria> confiteria, Cliente cliente, Cupon cupon) throws Exception;

    List<Compra> listarCompras(Integer idCliente) throws Exception;

    Cliente cambiarContrasenia(Cliente cliente, String nuevaContrasenia) throws Exception;

    Cliente buscarCliente(Integer idCliente) throws Exception;

    void agregarPuntos(Integer idCliente, Integer puntos) throws Exception;

    List<Cliente> listarClientes();

    List<Pelicula> listarPeliculasPorNombre(String nombre) throws Exception;
}
