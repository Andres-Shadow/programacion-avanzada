package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.Repo.AdministrativoRepo;
import co.edu.uniquindio.unicine.Repo.ClienteRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AdminTest {
    @Autowired
    private AdministrativoRepo adminRepo;
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

}
