package co.edu.uniquindio.unicine.Servicios;

import co.edu.uniquindio.unicine.Entidades.Cliente;
import co.edu.uniquindio.unicine.Entidades.Compra;
import co.edu.uniquindio.unicine.Entidades.Confiteria;
import co.edu.uniquindio.unicine.Entidades.Entrada;

import java.util.List;

public interface ClienteServicio {


    Cliente registrarCliente(Cliente idCliente) throws Exception;

    Cliente actualizarCliente(Cliente idCliente) throws Exception;

    void eliminarCliente(Integer idCliente) throws Exception;

    Cliente login(String correo, String contrasenia) throws Exception;

    void comprarEntrada (Entrada entrada, Cliente cliente) throws Exception;

    void comprarConfiteria (Confiteria entrada, Cliente cliente) throws Exception;


    Cliente buscarCliente(Integer idCliente) throws Exception;

    void agregarPuntos(Integer idCliente, Integer puntos) throws Exception;

    List<Compra> listarCompras(Integer idCliente) throws Exception;
    List<Cliente> listarClientes();

}
