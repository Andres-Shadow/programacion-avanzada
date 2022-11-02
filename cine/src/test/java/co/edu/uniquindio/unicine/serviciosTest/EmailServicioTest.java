package co.edu.uniquindio.unicine.serviciosTest;


import co.edu.uniquindio.unicine.ServiciosImpl.EmailServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmailServicioTest {

    @Autowired
    private EmailServicio emailServicio;

    @Test
//    @Sql("classpath:dataset.sql")
    public void enviarCorreoTest(){
        emailServicio.enviarEmail("Prueba Email:", "Correo sirviendo", "juandada79@gmail.com");
    }

}
