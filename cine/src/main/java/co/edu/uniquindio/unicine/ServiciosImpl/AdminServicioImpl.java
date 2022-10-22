package co.edu.uniquindio.unicine.ServiciosImpl;

import co.edu.uniquindio.unicine.Entidades.*;
import co.edu.uniquindio.unicine.Repo.*;
import co.edu.uniquindio.unicine.Servicios.AdminServicio;
import org.springframework.beans.factory.annotation.Autowired;
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
        if(admin == null)
        {
            throw new Exception("Los datos de autenticacion son incorrectos");
        }
        return admin;
    }

    @Override
    public Ciudad crearCiudad(Ciudad ciudad) {
        return ciudadRepo.save(ciudad);
    }

    @Override
    public Teatro crearTeatro(Teatro teatro) throws Exception {
        return teatroRepo.save(teatro);
    }

    @Override
    public void eliminarTeatro(Integer idTeatro) throws Exception {
        Optional<Teatro> guardado = teatroRepo.findById(idTeatro);
        teatroRepo.delete(guardado.get());

    }

    @Override
    public Teatro actualizarTeatro(Teatro teatro) throws Exception {
        return null;
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
        cuponRepo.delete(guardado.get());

    }

    @Override
    public Cupon actualizarCupon(Cupon cupon) throws Exception {
        return null;
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
        confiteriaRepo.delete(guardado.get());

    }

    @Override
    public Confiteria actualizarConfiteria(Confiteria confiteria) throws Exception {
        return null;
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
        peliculaRepo.delete(guardado.get());

    }

    @Override
    public Pelicula actualizarPelicula(Pelicula pelicula) throws Exception {
        return null;
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
        administrativoRepo.delete(guardado.get());

    }

    @Override
    public Administrativo actualizarAdminTeatro(Administrativo adminTeatro) throws Exception {
        return null;
    }

    @Override
    public List<Administrativo> listarAdminTeatro() {
        return administrativoRepo.ListarAdminsTeatro();
    }
}
