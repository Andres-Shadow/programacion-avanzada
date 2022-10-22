package co.edu.uniquindio.unicine.ServiciosImpl;

import co.edu.uniquindio.unicine.Entidades.Cliente;
import co.edu.uniquindio.unicine.Entidades.Compra;
import co.edu.uniquindio.unicine.Repo.ClienteRepo;
import co.edu.uniquindio.unicine.Servicios.ClienteServicio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicioImpl implements ClienteServicio {


    private ClienteRepo clienteRepo;

    public ClienteServicioImpl(ClienteRepo clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    @Override
    public Cliente registrarCliente(Cliente cliente) throws Exception {
        boolean correoExiste = verCorreoRepetido(cliente.getEmail());
        if(correoExiste)
            throw new Exception("Excepcion: Correo ya existente");
        return clienteRepo.save(cliente);
    }

    private boolean verCorreoRepetido(String correo){
        return  clienteRepo.obtenerPorCorreo(correo) != null;
    }
    @Override
    public Cliente actualizarCliente(Cliente cliente) throws Exception{
        Optional<Cliente> guardado = clienteRepo.findById(cliente.getId());
        if(guardado.isEmpty())
            throw new Exception("Excepcion: Cliente no encontrado");
        return clienteRepo.save(cliente);
    }
    @Override
    public void eliminarCliente(Integer idCliente) throws Exception{
        Optional<Cliente> guardado = clienteRepo.findById(idCliente);
        if(guardado.isEmpty())
            throw new Exception("Excepcion: Cliente no encontrado");
        clienteRepo.delete(guardado.get());
    }

    @Override
    public Cliente login(String correo, String contrasenia) throws Exception{
        Cliente cliente =  clienteRepo.comprobarAutenticacion(correo, contrasenia);
        if(cliente == null)
            throw new Exception("Excepcion: Datos de ingreso invalidos");
        else
            return cliente;
    }

    @Override
    public Cliente buscarCliente(Integer idCliente) throws Exception {
        Optional<Cliente> buscado = clienteRepo.findById(idCliente);
        if(buscado.isEmpty())
            throw new Exception("Excepcion: Cliente no encontrado");
        else
            return buscado.get();
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepo.findAll();
    }

    @Override
    public void agregarPuntos(Integer idCliente, Integer puntos) throws Exception {
        Optional<Cliente> buscado = clienteRepo.findById(idCliente);
        Integer puntosActual;
        if(buscado.isEmpty())
            throw new Exception("Excepcion: Cliente no encontrado");
        else {
            puntosActual = buscado.get().getPuntos();
            puntosActual = puntosActual + puntos;
            buscado.get().setPuntos(puntosActual);
            clienteRepo.save(buscado.get());
        }
    }

    @Override
    public List<Compra> listarCompras(Integer idCliente) throws Exception {
        List<Compra> listaCompras = clienteRepo.listarCompras(idCliente);

        if(listaCompras == null)
            throw new Exception("Cliente no tiene compras");

        return listaCompras;
    }

    //TODO
    //HacerCompra
    //RedimirCupon
}
