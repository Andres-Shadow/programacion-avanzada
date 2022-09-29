package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.Repo.FuncionRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FuncionTest {
    @Autowired
    private FuncionRepo funcionRepo;

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
    public void obtenerPeliculaFuncion(){
        String nombrePelicula = funcionRepo.obtenerNombrePelicula(1);
        Assertions.assertEquals("el resplandor",nombrePelicula);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerVariosDatosFuncion(){
        List<Object[]> funciones = funcionRepo.obtenerFuncionesPelicula(1);

        funciones.forEach( o ->
                   System.out.println(o[0] +","+o[1]+","+o[2]+","+o[3] )
        );

    }
}
