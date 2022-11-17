package co.edu.uniquindio.unicine.serviciosTest;

import co.edu.uniquindio.unicine.Entidades.*;
import co.edu.uniquindio.unicine.Servicios.AdminServicio;
import co.edu.uniquindio.unicine.Tipos.Estado_PElicula;
import co.edu.uniquindio.unicine.Tipos.Genero_Pelicula;
import co.edu.uniquindio.unicine.Tipos.Tipo_Admin;
import co.edu.uniquindio.unicine.Tipos.Tipo_Cupon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class adminServicioTest {

    @Autowired
    private AdminServicio adminServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarAdminTest(){
        Administrativo adminTeatro = Administrativo.builder().id(56).nombre("Pedro").tipo(Tipo_Admin.ADMINISTRADOR_TEATRO).cedula("2345678").correo("pedro").contrasenia("pedro2").build();

        adminTeatro.setId(1);
        try {
            Administrativo nuevo = adminServicio.crearAdminTeatro(adminTeatro);
            Assertions.assertNotNull(nuevo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarAdminTeatro(){
        try {
            adminServicio.eliminarAdminTeatro("12345", 1);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarAdminTeatro(){
        try {
            Administrativo admin = Administrativo.builder().nombre("Pedro").tipo(Tipo_Admin.ADMINISTRADOR_TEATRO).cedula("2345678").correo("pedro").contrasenia("pedro2").build();
            admin.setCorreo("nuevoemail@gmail.com");
            admin.setId(1);
            Administrativo nuevo = adminServicio.actualizarAdminTeatro(admin);
            Assertions.assertNotNull(nuevo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarAdmisTeatro(){
        List<Administrativo> admin = adminServicio.listarAdminTeatro();
        admin.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void crearCiudadTest(){
        Ciudad ciudad = Ciudad.builder().nombre("bucaramanga").build();

        try {
            Ciudad nuevo = adminServicio.crearCiudad(ciudad);
            Assertions.assertNotNull(nuevo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarCiudad(){
        try {
            adminServicio.eliminarCiudad(2);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarACiudad(){
        try {
            Ciudad ciudad = Ciudad.builder().nombre("bucaramanga").build();
            ciudad.setNombre("cali");
            ciudad.setId(1);
            Ciudad nuevo = adminServicio.actualizarCiudad(ciudad);
            Assertions.assertNotNull(nuevo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCiudad(){
        List<Ciudad> ciudad = adminServicio.listarCiudad();
        ciudad.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void crearTeatroTest(){
        Teatro teatro = Teatro.builder().nombre("teatro 45").direccion("direccion 45").build();
        try {
            Teatro nuevo = adminServicio.crearTeatro(teatro);
            Assertions.assertNotNull(nuevo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarTeatro(){
        try {
            adminServicio.eliminarTeatro(2);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarTeatro(){
        try {
            Teatro teatro = Teatro.builder().nombre("teatro 2").direccion("centro").build();
            teatro.setNombre("teatro 3");
            teatro.setId(1);
            Teatro nuevo = adminServicio.actualizarTeatro(teatro);
            Assertions.assertNotNull(nuevo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarTeatro(){
        List<Teatro> teatro = adminServicio.listarTeatro();
        teatro.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void crearCuponTest(){
        Cupon cupon = Cupon.builder().tipo(Tipo_Cupon.CUPON_TIPO_1).valor(222F).fecha(LocalDateTime.now()).descripcion("cupon entrada").estado(true).build();
        cupon.setId(56);
        try {
            Cupon nuevo = adminServicio.crearCupon(cupon);
            Assertions.assertNotNull(nuevo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarCupon(){
        try {
            adminServicio.eliminarCupon(1);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarCupon(){
        try {
            Cupon cupon = Cupon.builder().tipo(Tipo_Cupon.CUPON_TIPO_1).valor(222F).fecha(LocalDateTime.now()).descripcion("cupon entrada").estado(true).build();
            cupon.setValorDescuento(333F);
            cupon.setId(1);
            Cupon nuevo = adminServicio.actualizarCupon(cupon);
            Assertions.assertNotNull(nuevo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCupones(){
        List<Cupon> cupon = adminServicio.listarCupon();
        cupon.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void crearConfiteriaTest(){
        Confiteria confiteria = Confiteria.builder().nombre("papas").precio(2242F).imagen("img.png").puntos(0).build();
        try {
            Confiteria nuevo = adminServicio.crearConfiteria(confiteria);
            Assertions.assertNotNull(nuevo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarConfiteria(){
        try {
            adminServicio.eliminarConfiteria(2);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarConfiteria(){
        try {
            Confiteria confiteria = Confiteria.builder().nombre("papas").precio(2242F).imagen("img.png").puntos(5).build();
            confiteria.setNombre("hot dog");
            confiteria.setId(1);
            Confiteria nuevo = adminServicio.actualizarConfiteria(confiteria);
            Assertions.assertNotNull(nuevo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarConfiteria(){
        List<Confiteria> confiteria = adminServicio.listarConfiteria();
        confiteria.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void crearPeliculasTest(){
        Pelicula pelicula = Pelicula.builder().nombre("pelicula").trailler("www.youtube.com").imagen("img.png").sinopsis("pelicula de terror").reparto("actor").genero(Genero_Pelicula.TERROR).estado(Estado_PElicula.PREVENTA).build();

        try {
            Pelicula nuevo = adminServicio.crearPelicula(pelicula);
            Assertions.assertNotNull(nuevo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarPelicula(){
        try {
            adminServicio.eliminarPelicula(2);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarPelicula(){
        try {
            Pelicula pelicula = Pelicula.builder().nombre("pelicula").trailler("www.youtube.com").imagen("img.png").sinopsis("pelicula de terror").reparto("actor").genero(Genero_Pelicula.TERROR).estado(Estado_PElicula.PREVENTA).build();
            pelicula.setNombre("pelicula 2");
            pelicula.setId(1);
            Pelicula nuevo = adminServicio.actualizarPelicula(pelicula);
            Assertions.assertNotNull(nuevo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPeliculas(){
        List<Pelicula> pelicula = adminServicio.listarPelicula();
        pelicula.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void login(){
        try {
            String correo = "correo1@gmail.com";
            String contrasenia = "password";
            Administrativo buscado = adminServicio.login(correo, contrasenia);
            Assertions.assertNotNull(buscado);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
