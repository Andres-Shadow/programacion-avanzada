package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.Entidades.Cliente;
import co.edu.uniquindio.unicine.Repo.ClienteRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteTest {

    @Autowired
    private ClienteRepo clienteRepo;

    @Test
    public void registrar(){

        Cliente cliente = new Cliente("pepito", "3145126","foto", "12345",0,"pepe@gmail.com");


        Cliente gaurdado = clienteRepo.save(cliente);
        //Assertions.assertEquals("pepito", gaurdado.getNombre());
        Assertions.assertNotNull(gaurdado);

    }
    @Test
    public void eliminar(){
        Cliente cliente = new Cliente("pepito", "3145126","foto", "12345",0,"pepe@gmail.com");
        cliente.setId(1);
        Cliente gaurdado = clienteRepo.save(cliente);
        clienteRepo.delete(gaurdado);
        Optional<Cliente>  buscado = clienteRepo.findById(1);

        Assertions.assertNull(buscado.orElse(null));


    }
    @Test
    public void actualizar(){
        Cliente cliente = new Cliente("pepito", "3145126","foto", "12345",0,"pepe@gmail.com");
        cliente.setId(1);
        Cliente gaurdado = clienteRepo.save(cliente);

        gaurdado.setEmail("pepe_nuevo@gmail.com");

        Cliente nuevo = clienteRepo.save(gaurdado);

        Assertions.assertEquals("pepe_nuevo@gmail.com",nuevo.getEmail());

    }
    @Test
    public void obtener(){
        Cliente cliente = new Cliente("pepito", "3145126","foto", "12345",0,"pepe@gmail.com");
        cliente.setId(1);
        Cliente gaurdado = clienteRepo.save(cliente);

        Optional<Cliente> buscado = clienteRepo.findById(1);

        Assertions.assertNotNull(buscado);
    }
    @Test
    public void listar(){
        Cliente cliente = new Cliente("pepito", "3145126","foto", "12345",0,"pepe@gmail.com");
        cliente.setId(1);
        Cliente gaurdado = clienteRepo.save(cliente);
        List<Cliente> lista = clienteRepo.findAll();
        System.out.println(lista);
    }

}
