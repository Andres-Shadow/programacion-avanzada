package co.edu.uniquindio.unicine.ServiciosImpl;

import co.edu.uniquindio.unicine.Entidades.Administrativo;
import co.edu.uniquindio.unicine.Entidades.Ciudad;
import co.edu.uniquindio.unicine.Entidades.Funcion;
import co.edu.uniquindio.unicine.Entidades.Sala;
import co.edu.uniquindio.unicine.Repo.AdministrativoRepo;
import co.edu.uniquindio.unicine.Repo.FuncionRepo;
import co.edu.uniquindio.unicine.Repo.SalaRepo;
import co.edu.uniquindio.unicine.Servicios.AdminTeatroServicio;
import co.edu.uniquindio.unicine.Tipos.Tipo_Admin;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminTeatroImpl implements AdminTeatroServicio {

    //repositorios para las funciones del admin de teatro
    private AdministrativoRepo administrativoRepo;
    private FuncionRepo funcionRepo;
    private SalaRepo salaRepo;



    public AdminTeatroImpl(AdministrativoRepo administrativoRepo) {
        this.administrativoRepo = administrativoRepo;
    }

    @Override
    public Administrativo login(String cedula) throws Exception {
        Administrativo admin = administrativoRepo.obtenerPorCedula(cedula);

        if(admin == null || !admin.getTipo().equals(Tipo_Admin.ADMINISTRADOR_TEATRO))
        {
            throw new Exception("Los datos de autenticacion son incorrectos");
        }

        return admin;

    }

    @Override
    public Funcion crearFuncion(Funcion funcion) throws Exception {
        return funcionRepo.save(funcion);
    }

    @Override
    public void eliminarFuncion(Integer idFuncion) throws Exception {
        Optional<Funcion> guardado = funcionRepo.findById(idFuncion);

        if(guardado.isEmpty()){
            throw new Exception("La Funcion que desea eliminar no existe");
        }
        funcionRepo.delete(guardado.get());
    }

    @Override
    public Funcion actualizarFuncion(Funcion funcion) throws Exception {
        Optional<Funcion> guardado = funcionRepo.findById(funcion.getId());

        if(guardado.isEmpty()) {
            throw new Exception("La funcion que desea actualizar no existe");
        }
        return funcionRepo.save(funcion);
    }

    @Override
    public List<Funcion> listarFuncion() {
        return administrativoRepo.ListarFuncion();
    }

    @Override
    public Sala crearSala(Sala sala) throws Exception {
        return salaRepo.save(sala);
    }

    @Override
    public void eliminarSala(Integer idSala) throws Exception {

        Optional<Sala> guardado = salaRepo.findById(idSala);

        if(guardado.isEmpty()){
            throw new Exception("La sala que desea eliminar no existe");
        }
        salaRepo.delete(guardado.get());
    }

    @Override
    public Sala actualizarSala(Sala sala) throws Exception {
        Optional<Sala> guardado = salaRepo.findById(sala.getId());

        if(guardado.isEmpty()) {
            throw new Exception("La sala que desea actualizar no existe");
        }
        return salaRepo.save(sala);
    }

    @Override
    public List<Sala> listarSala() {
        return administrativoRepo.ListarSala();
    }
}