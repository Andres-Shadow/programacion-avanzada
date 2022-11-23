package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.Entidades.Cliente;
import co.edu.uniquindio.unicine.Entidades.Compra;
import co.edu.uniquindio.unicine.Entidades.Cupon;
import co.edu.uniquindio.unicine.Repo.ClienteRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteTest {

    @Autowired
    private ClienteRepo clienteRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar(){
        /*
        Cliente cliente = new Cliente("pepito","foto", "12345",0,"pepe@gmail.com");


        Cliente gaurdado = clienteRepo.save(cliente);
        //Assertions.assertEquals("pepito", gaurdado.getNombre());
        Assertions.assertNotNull(gaurdado);*/

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar(){
        /**
        Cliente cliente = new Cliente("pepito", "3145126","foto", "12345",0,"pepe@gmail.com");
        cliente.setId(1);
        Cliente gaurdado = clienteRepo.save(cliente);
        clienteRepo.delete(gaurdado);
        Optional<Cliente>  buscado = clienteRepo.findById(1);

        Assertions.assertNull(buscado.orElse(null));
        **/
        Cliente buscado = clienteRepo.findById(1).orElse(null);
        clienteRepo.delete(buscado);
        Assertions.assertNull(clienteRepo.findById(1).orElse(null));

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar(){
        /**
        Cliente cliente = new Cliente("pepito", "3145126","foto", "12345",0,"pepe@gmail.com");
        cliente.setId(1);
        Cliente gaurdado = clienteRepo.save(cliente);

        gaurdado.setEmail("pepe_nuevo@gmail.com");

        Cliente nuevo = clienteRepo.save(gaurdado);

        Assertions.assertEquals("pepe_nuevo@gmail.com",nuevo.getEmail());
        **/
        Cliente guardado = clienteRepo.findById(1).orElse(null);
        guardado.setEmail("correotesto@gmail.com");
        Cliente nuevo = clienteRepo.save(guardado);
        Assertions.assertEquals("correotesto@gmail.com",nuevo.getEmail());

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtener(){
        //Cliente cliente = new Cliente("pepito", "3145126","foto", "12345",0,"pepe@gmail.com");
        //cliente.setId(1);
        //Cliente gaurdado = clienteRepo.save(cliente);

        Optional<Cliente> buscado = clienteRepo.findById(1);

        Assertions.assertNotNull(buscado);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){
        //Cliente cliente = new Cliente("pepito", "3145126","foto", "12345",0,"pepe@gmail.com");
        //cliente.setId(1);
        //Cliente gaurdado = clienteRepo.save(cliente);

        List<Cliente> lista = clienteRepo.findAll();
        lista.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerPorCorreo(){
        Cliente cliente = clienteRepo.obtenerPorCorreo("pepe@gmail.com");
        Assertions.assertNotNull(cliente);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void comprobarAutenticacion(){
        Cliente cliente = clienteRepo.comprobarAutenticacion("pepe@gmail.com","1234");
        Assertions.assertNotNull(cliente);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void paginado(){
        List<Cliente> clientes = clienteRepo.findAll(PageRequest.of(0, 2)).toList();
        clientes.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void ordenarRegistros(){
        List<Cliente> clientes = clienteRepo.findAll(Sort.by("nombre"));
        //List<Cliente> clientes2 = clienteRepo.findAll(PageRequest.of(0, 2,Sort.by("nombre"))).toList();
        clientes.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerCompraPorCorreo(){
        List<Compra> lista= clienteRepo.obtenerComrpa("pepe@gmail.com");
        Assertions.assertNotNull(lista);
        lista.forEach(System.out::println);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerCuponPorCorreo(){
        List<Cupon> lista= clienteRepo.obtenerListaCupones("pepe@gmail.com");

        Assertions.assertEquals(1,lista.size());

    }
}
