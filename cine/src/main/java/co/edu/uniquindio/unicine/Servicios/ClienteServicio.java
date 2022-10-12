package co.edu.uniquindio.unicine.Servicios;

import co.edu.uniquindio.unicine.Entidades.Cliente;

import java.util.List;

public interface ClienteServicio {

    //TODAS LAS FUNCIONES ASOCIADAS AL CLIENTE
    Cliente login(String correo, String contrasenia) throws Exception;

    // ------------ CRUD CLIENTE ------------ //

    Cliente registrarCliente(Cliente cliente) throws Exception;

    Cliente actualizarCliente(Cliente cliente) throws Exception;

    void eliminarCliente(Integer idCliente) throws Exception;

    List<Cliente> listarClientes();

    Cliente obtenerClientePorCodigo(Integer id) throws Exception;
}
