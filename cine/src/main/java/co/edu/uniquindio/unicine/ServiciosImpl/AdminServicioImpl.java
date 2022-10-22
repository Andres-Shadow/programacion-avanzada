package co.edu.uniquindio.unicine.ServiciosImpl;

import co.edu.uniquindio.unicine.Entidades.*;
import co.edu.uniquindio.unicine.Repo.*;
import co.edu.uniquindio.unicine.Servicios.AdminServicio;
import co.edu.uniquindio.unicine.Tipos.Tipo_Admin;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServicioImpl implements AdminServicio {

    //repositorios para las funciones del admin
    private AdministrativoRepo administrativoRepo;
    private CiudadRepo ciudadRepo;
    private CuponRepo cuponRepo;
    private ConfiteriaRepo confiteriaRepo;
    private PeliculaRepo peliculaRepo;
    private TeatroRepo teatroRepo;



    public AdminServicioImpl(AdministrativoRepo administrativoRepo) {

        this.administrativoRepo = administrativoRepo;
    }

    @Override
    public Administrativo login(String cedula) throws Exception {
        Administrativo admin = administrativoRepo.obtenerPorCedula(cedula);
        if(admin == null || !admin.getTipo().equals(Tipo_Admin.ADMINISTRADOR_GLOBAL))
        {
            throw new Exception("Los datos de autenticacion son incorrectos");
        }
        return admin;
    }

    @Override
    public Ciudad crearCiudad(Ciudad ciudad)throws Exception {

        return ciudadRepo.save(ciudad);
    }

    public void eliminarCiudad(Integer idCiudad)throws Exception{
        Optional<Ciudad> guardado = ciudadRepo.findById(idCiudad);

        if(guardado.isEmpty()){
            throw new Exception("La ciudad que desea eliminar no existe");
        }
        ciudadRepo.delete(guardado.get());

    }

    public Ciudad actualizarCiudad(Ciudad ciudad) throws Exception{

        Optional<Ciudad> guardado = ciudadRepo.findById(ciudad.getId());

        if(guardado.isEmpty()) {
            throw new Exception("La ciudad que desea actualizar no existe");
        }
        return ciudadRepo.save(ciudad);
    }
    public List<Ciudad> listarCiudad() {

        return administrativoRepo.ListarCiudad();
    }
    //Gestionar teatro
    @Override
    public Teatro crearTeatro(Teatro teatro) throws Exception {
        return teatroRepo.save(teatro);
    }

    @Override
    public void eliminarTeatro(Integer idTeatro) throws Exception {
        //buscamos por medio de la id y lo borramos
        Optional<Teatro> guardado = teatroRepo.findById(idTeatro);

        if(guardado.isEmpty()){
            throw new Exception("El teatro que desea eliminar no existe");
        }
        teatroRepo.delete(guardado.get());

    }

    @Override
    public Teatro actualizarTeatro(Teatro teatro) throws Exception {
        //buscamos en la lista de teatros por medio de la id
        Optional<Teatro> guardado = teatroRepo.findById(teatro.getId());

        if(guardado.isEmpty()) {
            throw new Exception("El teatro que desea actualizar no existe");
        }
        return teatroRepo.save(teatro);
    }

    @Override
    public List<Teatro> listarTeatro() {
        return administrativoRepo.ListarTeatros();
    }

    @Override
    public Cupon crearCupon(Cupon cupon) throws Exception {
        return cuponRepo.save(cupon);
    }

    @Override
    public void eliminarCupon(Integer idCupon) throws Exception {
        Optional<Cupon> guardado = cuponRepo.findById(idCupon);

        if(guardado.isEmpty()){
            throw new Exception("El cupon que desea eliminar no existe");
        }
        cuponRepo.delete(guardado.get());

    }

    @Override
    public Cupon actualizarCupon(Cupon cupon) throws Exception {
        Optional<Cupon> guardado = cuponRepo.findById(cupon.getId());

        if(guardado.isEmpty()) {
            throw new Exception("El cupon que desea actualizar no existe");
        }
        return cuponRepo.save(cupon);
    }

    @Override
    public List<Cupon> listarCupon() {
        return administrativoRepo.ListarCupones();
    }

    @Override
    public Confiteria crearConfiteria(Confiteria confiteria) throws Exception {
        return confiteriaRepo.save(confiteria);
    }

    @Override
    public void eliminarConfiteria(Integer idConfiteria) throws Exception {
        Optional<Confiteria> guardado = confiteriaRepo.findById(idConfiteria);

        if(guardado.isEmpty()){
            throw new Exception("La confiteria que desea eliminar no existe");
        }
        confiteriaRepo.delete(guardado.get());

    }

    @Override
    public Confiteria actualizarConfiteria(Confiteria confiteria) throws Exception {
        Optional<Confiteria> guardado = confiteriaRepo.findById(confiteria.getId());

        if(guardado.isEmpty()) {
            throw new Exception("La confiteria que desea actualizar no existe");
        }
        return confiteriaRepo.save(confiteria);
    }

    @Override
    public List<Confiteria> listarConfiteria() {
        return administrativoRepo.ListarConfiteria();
    }

    @Override
    public Pelicula crearPelicula(Pelicula pelicula) throws Exception {
        return peliculaRepo.save(pelicula);
    }

    @Override
    public void eliminarPelicula(Integer idPelicula) throws Exception {
        Optional<Pelicula> guardado = peliculaRepo.findById(idPelicula);

        if(guardado.isEmpty()){
            throw new Exception("La pelicula que desea eliminar no existe");
        }
        peliculaRepo.delete(guardado.get());

    }

    @Override
    public Pelicula actualizarPelicula(Pelicula pelicula) throws Exception {
        Optional<Pelicula> guardado = peliculaRepo.findById(pelicula.getId());

        if(guardado.isEmpty()) {
            throw new Exception("La pelicula que desea actualizar no existe");
        }
        return peliculaRepo.save(pelicula);
    }

    @Override
    public List<Pelicula> listarPelicula() {
        return administrativoRepo.ListarPeliculas();
    }

    @Override
    public Administrativo crearAdminTeatro(Administrativo adminTeatro) throws Exception {
        return administrativoRepo.save(adminTeatro);
    }

    @Override
    public void eliminarAdminTeatro(String numCedula, Integer idAdmin) throws Exception {
        Optional<Administrativo> guardado = administrativoRepo.findById(idAdmin);

        if(guardado.isEmpty()){
            throw new Exception("El administrador que desea eliminar no existe");
        }
        administrativoRepo.delete(guardado.get());

    }

    @Override
    public Administrativo actualizarAdminTeatro(Administrativo adminTeatro) throws Exception {
        Optional<Administrativo> guardado = administrativoRepo.findById(adminTeatro.getId());

        if(guardado.isEmpty()) {
            throw new Exception("El Administrador de teatro que desea actualizar no existe");
        }
        return administrativoRepo.save(adminTeatro);
    }

    @Override
    public List<Administrativo> listarAdminTeatro() {
        return administrativoRepo.ListarAdminsTeatro();
    }
}
