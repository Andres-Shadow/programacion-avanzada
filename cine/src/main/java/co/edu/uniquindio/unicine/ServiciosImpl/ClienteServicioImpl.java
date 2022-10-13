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
    public Cliente login(String correo, String contrasenia) throws Exception{
        Cliente cliente =  clienteRepo.comprobarAutenticacion(correo, contrasenia);
        if(cliente == null)
            throw new Exception("Los datos de autenticacion son incorrectos");
        else
            return cliente;

    }

    @Override
    public Cliente registrarCliente(Cliente cliente) throws Exception {

        boolean correoExiste = verCorreoRepetido(cliente.getEmail());

        if(correoExiste)
            throw new Exception("El correo ya existe");

        return clienteRepo.save(cliente);
    }

    private boolean verCorreoRepetido(String correo){
        return  clienteRepo.obtenerPorCorreo(correo) != null;
    }
    @Override
    public Cliente actualizarCliente(Cliente cliente) throws Exception{

        Optional<Cliente> guardado = clienteRepo.findById(cliente.getId());

        if(guardado.isEmpty())
            throw new Exception("El cliente no existe");

        return clienteRepo.save(cliente);
    }

    @Override
    public void eliminarCliente(Integer idCliente) throws Exception{
        Optional<Cliente> guardado = clienteRepo.findById(idCliente);

        if(guardado.isEmpty())
           throw new Exception("Cliente no existe en la base de datos");

        clienteRepo.delete(guardado.get());
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepo.findAll();
    }

    @Override
    public Cliente obtenerClientePorCodigo(Integer id) throws Exception {

        Optional<Cliente> guardado = clienteRepo.findById(id);

        if(guardado.isEmpty())
            throw new Exception("Cliente no existe en la base de datos");

        return guardado.get();
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
