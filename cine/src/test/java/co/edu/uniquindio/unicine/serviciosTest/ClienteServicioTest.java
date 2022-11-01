package co.edu.uniquindio.unicine.serviciosTest;

import co.edu.uniquindio.unicine.Entidades.*;
import co.edu.uniquindio.unicine.Repo.ConfiteriaRepo;
import co.edu.uniquindio.unicine.Servicios.ClienteServicio;
import co.edu.uniquindio.unicine.ServiciosImpl.EmailServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteServicioTest {

    @Autowired
    private ClienteServicio clienteServicio;
    @Autowired
    private EmailServicio emailServicio;
    @Autowired
    private ConfiteriaRepo confiteriaRepo;





    @Test
    public void enviarCorreoTest(){
        emailServicio.enviarEmail("Prueba Email:", "Correo sirviendo", "juandada79@gmail.com");
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarCliente(){
        Cliente cliente = Cliente.builder().nombre("pepe").contra("1234").email("pepe1234@gmail.com").puntos(0).imagen("foto").build();

        try {
            Cliente nuevo = clienteServicio.registrarCliente(cliente);
            Assertions.assertNotNull(nuevo);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarCliente(){
        try {
            Cliente cliente = clienteServicio.buscarCliente(1);
            cliente.setEmail("nuevoemail@gmail.com");
            Cliente nuevo = clienteServicio.actualizarCliente(cliente);
            Assertions.assertNotNull(nuevo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarCliente(){
        try {
            clienteServicio.eliminarCliente(1);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
        try {
            Cliente cliente = clienteServicio.buscarCliente(1);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarClientes(){
        List<Cliente> cliente = clienteServicio.listarClientes();
        cliente.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void login(){
        try {
            String correo = "gagearaya5239@google.com";
            String contrasenia = "XOA627";
            Cliente buscado = clienteServicio.login(correo, contrasenia);
            Assertions.assertNotNull(buscado);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void buscarPelicula(){
        String nombrePelicula = "black phone";
        try {
            Pelicula pelicula = clienteServicio.buscarPelicula(nombrePelicula);
            Assertions.assertNotNull(pelicula);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void comprar(){
        try {
        Entrada entrada = Entrada.builder().valor(18.500F).columna(1).fila(1).build();
        Cliente cliente = clienteServicio.buscarCliente(1);
        Optional<Confiteria> confiteria = confiteriaRepo.findById(1);

        entrada.setId(1);

        Compra compra = clienteServicio.comprar(entrada, confiteria, cliente, null);
        Assertions.assertNotNull(compra);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void cambiarContrasenia(){
        try {
            Cliente cliente = clienteServicio.buscarCliente(1);
            String nuevaContrasenia = "1234";
            Cliente nuevo = clienteServicio.cambiarContrasenia(cliente, nuevaContrasenia);
            Assertions.assertNotNull(nuevo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }




}
