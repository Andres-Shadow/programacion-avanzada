package co.edu.uniquindio.unicine.ServiciosImpl;

import co.edu.uniquindio.unicine.Entidades.*;
import co.edu.uniquindio.unicine.Intermedia.CuponCliente;
import co.edu.uniquindio.unicine.Repo.*;
import co.edu.uniquindio.unicine.Servicios.ClienteServicio;
import org.jasypt.util.binary.AES256BinaryEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.jasypt.util.text.AES256TextEncryptor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicioImpl implements ClienteServicio {

    private final ConfiteriaRepo confiteriarepo;
    private final PeliculaRepo peliculaRepo;
    private final EntradaRepo entradaRepo;
    private final CompraRepo compraRepo;
    private final CuponRepo cuponRepo;
    private final ClienteRepo clienteRepo;

    private final EmailServicio emailServicio;

    public ClienteServicioImpl(ConfiteriaRepo confiteriarepo, PeliculaRepo peliculaRepo, EntradaRepo entradaRepo, CompraRepo compraRepo, CuponRepo cuponRepo, ClienteRepo clienteRepo, EmailServicio emailServicio) {
        this.confiteriarepo = confiteriarepo;
        this.peliculaRepo = peliculaRepo;
        this.entradaRepo = entradaRepo;
        this.compraRepo = compraRepo;
        this.cuponRepo = cuponRepo;
        this.clienteRepo = clienteRepo;
        this.emailServicio = emailServicio;
    }

    @Override
    public Cliente registrarCliente(Cliente cliente) throws Exception {
        boolean correoExiste = verCorreoRepetido(cliente.getEmail());
        Cliente registro = null;
        if(correoExiste)
            throw new Exception("Excepcion: Correo ya existente");
        else{


            StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
            cliente.setContrasenia(spe.encryptPassword(cliente.getContrasenia()));
            cliente.setEstado(false);
            cliente.setPuntos(0);

            registro = clienteRepo.save(cliente);

            AES256TextEncryptor textEncryptor = new AES256TextEncryptor();

            textEncryptor.setPassword("pectorales");

            String parame1 = textEncryptor.encrypt(registro.getEmail());


            emailServicio.enviarEmail("Unicine Correo:", "Hola, te has registrado en Unicine, debe ir al siguiente enlace para activar la cuenta http://localhost:8081/activar_cuenta.xhtml?p1="+parame1, cliente.getEmail());
            emailServicio.enviarEmail("Unicine Corre0:", "Hola, se le ha enviado cun cupon: " + "(CuponCodigo)", cliente.getEmail());
        }
        return registro;
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
    public Cliente login(String correo, String contra) throws Exception{
        Cliente cliente = clienteRepo.findByEmail(correo);

        if(cliente != null){
            StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
            if(!spe.checkPassword(contra, cliente.getContrasenia())){
                throw new Exception("Contraseña no valida");
            }

            if(!cliente.getEstado()){
                throw new Exception("Cuenta no activada");
            }
        }




        return cliente;

    }

    @Override
    public Pelicula buscarPelicula(String nombrePelicula) throws Exception {
        Optional<Pelicula> pelicula = Optional.ofNullable(peliculaRepo.obtenerPorNombre(nombrePelicula));
        if(pelicula.isEmpty())
            throw new Exception("Excepcion: Pelicula no encontrada");
        return pelicula.get();
    }


    @Override
    public List<Compra> listarCompras(Integer idCliente) throws Exception {
        List<Compra> listaCompras = clienteRepo.listarCompras(idCliente);
        if(listaCompras == null)
            throw new Exception("Excepcion: Cliente sin compras");
        return listaCompras;
    }

    @Override
    public Cliente cambiarContrasenia(Cliente cliente, String nuevaContrasenia) throws Exception{
        Optional<Cliente> buscado = Optional.ofNullable(clienteRepo.obtenerCliente(cliente.getId()));
        if(buscado.isEmpty())
            throw new Exception("Exception: Correo invalido");
        else

            emailServicio.enviarEmail("Unicine Correo:",
                    "Hola, se he cambiado la contraseña de Unicina",
                    cliente.getEmail());
        cliente.setContrasenia(nuevaContrasenia);

        return clienteRepo.save(cliente);

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
    public List<Pelicula> listarPeliculasPorNombre(String nombre) throws Exception {

        List<Pelicula> lista  = peliculaRepo.obtenerPelicualPorPalabra(nombre);

        if(lista.isEmpty())
            throw new Exception("no se encontraron peliculas con ese nombre");
        else
            return lista;
    }

    @Override
    public void activarCliente(String correo) throws Exception {

        correo = correo.replaceAll(" ", "+");
        AES256TextEncryptor textEncryptor = new AES256TextEncryptor();
        textEncryptor.setPassword("pectorales");

        String ncorreo = textEncryptor.decrypt(correo);

        Cliente guardado = clienteRepo.findByEmail(ncorreo);
        if(guardado==null){
            throw new Exception("Cliente no existe");
        }

        guardado.setEstado(true);
        clienteRepo.save(guardado);

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
    public Compra comprar(Entrada entrada, Optional<Confiteria> confiteria, Cliente cliente, Cupon cupon) throws Exception {
        Optional<Entrada> entradaBuscada = entradaRepo.findById(entrada.getId());
        Optional<Confiteria> confiteriabuscada = confiteriarepo.findById(entrada.getId());
        Optional<Cliente> clienteBuscado = clienteRepo.findById(cliente.getId());
        Optional<Cupon> cuponBuscado = buscarCupon(clienteBuscado, cupon.getId());

        Float valorCompra = null;
        boolean flag = true;

        if(entradaBuscada.isEmpty()){
            flag = false;
            throw new Exception("Excepcion: Entrada no registrada");}

        if (confiteriabuscada.isEmpty()){
            flag = false;
            throw new Exception("Excepcion: Confiteria no encontrada");}

        if(clienteBuscado.isEmpty()){
            flag = false;
            throw new Exception("Excepcion: Cliente no encontrado");}

        if(cuponBuscado.isEmpty()){
            flag = false;
            throw new Exception("Excepcion: Cupon no encontrado");}

        if(flag != false)
            System.out.println("||-----------------------------------------------------\n");
        System.out.println(entrada.toString());
        System.out.println(confiteria.toString());
        System.out.println(cupon.toString());
            System.out.println("||-----------------------------------------------------\n");
            valorCompra = calcularCompra(entrada, confiteria, cupon);
        emailServicio.enviarEmail("Unicine Correo:",
                "Hola, se ha registrado una compra: " + valorCompra,
                cliente.getEmail());
        if(valorCompra == null)
            throw new Exception("Excepcion: Valor de la compra no cargado");
        else
            return Compra.builder().valor(valorCompra).build();
    }

    private Optional<Cupon> buscarCupon(Optional<Cliente> cliente, Integer codigo) {

        List<CuponCliente> listaCupones = cliente.get().getCupones();

        for (CuponCliente cupon : listaCupones) {

            if (cupon.getCupon().getId() == codigo) {
                return Optional.ofNullable(cupon.getCupon());
            }
        }
        return null;
    }

    public Float calcularCompra (Entrada entrada, Optional<Confiteria> confiteria, Cupon cupon){
        Float precio = 0F;
        Float descuento = 0F;

        System.out.println("-----------------------------------------------------\n");
        System.out.println(entrada.toString());
        System.out.println(entrada.getValor());
        System.out.println(confiteria.toString());
        System.out.println(cupon.toString());
        System.out.println("-----------------------------------------------------\n");

        precio += entrada.getValor();
        precio += confiteria.get().getPrecio();
        descuento += (precio * cupon.getValorDescuento());
        precio -= descuento;
        return precio;
    }
}
