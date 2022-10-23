package co.edu.uniquindio.unicine.serviciosTest;

import co.edu.uniquindio.unicine.Entidades.*;
import co.edu.uniquindio.unicine.Servicios.AdminServicio;
import co.edu.uniquindio.unicine.Servicios.AdminTeatroServicio;
import co.edu.uniquindio.unicine.Tipos.Estado_PElicula;
import co.edu.uniquindio.unicine.Tipos.Genero_Pelicula;
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
public class adminTeatroServicioTest {
    @Autowired
    private AdminTeatroServicio adminTeatroServicio;


    @Test
    @Sql("classpath:dataset.sql")
    public void creaFuncionTest(){
        Funcion funcion = Funcion.builder().pelicula(Pelicula.builder().build()).sala(Sala.builder().build()).build();

        try {
            Funcion nuevo = adminTeatroServicio.crearFuncion(funcion);
            Assertions.assertNotNull(nuevo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarFuncion(){
        try {
            adminTeatroServicio.eliminarFuncion(2);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarFuncion(){
        try {
            Funcion funcion = Funcion.builder().pelicula(Pelicula.builder().build()).sala(Sala.builder().build()).build();
            funcion.setPelicula(Pelicula.builder().build());
            Funcion nuevo = adminTeatroServicio.actualizarFuncion(funcion);
            Assertions.assertNotNull(nuevo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarFuncion(){
        List<Funcion> funcion = adminTeatroServicio.listarFuncion();
        funcion.forEach(System.out::println);
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void crearSalaTest(){
        Sala sala = Sala.builder().sillaDsiponible(20).sillaTotal(30).build();

        try {
            Sala nuevo = adminTeatroServicio.crearSala(sala);
            Assertions.assertNotNull(nuevo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarSala(){
        try {
            adminTeatroServicio.eliminarSala(2);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarSala(){
        try {
            Sala sala =Sala.builder().sillaDsiponible(20).sillaTotal(30).build();
            sala.setSillaDsiponible(7);
            Sala nuevo = adminTeatroServicio.actualizarSala(sala);
            Assertions.assertNotNull(nuevo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarSala(){
        List<Sala> sala = adminTeatroServicio.listarSala();
        sala.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void login() {
        try {
            String correo = "admin3@google.com";
            String contrasenia = "3333";
            Administrativo buscado = adminTeatroServicio.login(correo, contrasenia);
            Assertions.assertNotNull(buscado);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
