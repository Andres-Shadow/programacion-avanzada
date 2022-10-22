package co.edu.uniquindio.unicine.serviciosTest;

import co.edu.uniquindio.unicine.Entidades.Cliente;
import co.edu.uniquindio.unicine.Entidades.Compra;
import co.edu.uniquindio.unicine.Servicios.ClienteServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteServicioTest {

    @Autowired
    private ClienteServicio clienteServ;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarCliente(){
        Cliente cliente = Cliente.builder().nombre("pepe").contra("1234").email("pepe1234@gmail.com").puntos(0).imagen("foto").build();

        try {
            Cliente nuevo = clienteServ.registrarCliente(cliente);
            Assertions.assertNotNull(nuevo);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarCliente(){
        try {
            Cliente cliente = clienteServ.obtenerClientePorCodigo(1);
            cliente.setEmail("nuevoemail@gmail.com");
            Cliente nuevo = clienteServ.actualizarCliente(cliente);
            Assertions.assertNotNull(nuevo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarCliente(){
        try {
            clienteServ.eliminarCliente(1);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
        try {
            Cliente cliente = clienteServ.obtenerClientePorCodigo(1);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarClientes(){
        List<Cliente> cliente = clienteServ.listarClientes();
        cliente.forEach(System.out::println);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarHistorialCompras(){
        try {
            List<Compra> listaComrpas = clienteServ.listarCompras(50);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }
}
