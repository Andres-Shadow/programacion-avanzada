package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.Repo.TeatroRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TeatroTest {
    @Autowired
    private TeatroRepo teatroRepo;

    @Test
    public void registrar(){

    }

    @Test
    public void eliminar(){

    }

    @Test
    public void actualizar(){

    }

    @Test
    public void listar(){

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerCiudadTeatro(){
        String ciudad = teatroRepo.obtenerCiudadTeatro(1);
        Assertions.assertEquals("Armenia",ciudad);
        System.out.println(ciudad);
    }
}
