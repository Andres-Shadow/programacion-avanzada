package co.edu.uniquindio.unicine.ServiciosImpl;

import co.edu.uniquindio.unicine.Entidades.Funcion;
import co.edu.uniquindio.unicine.Entidades.Sala;
import co.edu.uniquindio.unicine.Repo.AdministrativoRepo;
import co.edu.uniquindio.unicine.Servicios.AdminTeatroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminTeatroImpl implements AdminTeatroServicio {
    @Autowired
    private AdministrativoRepo administrativoRepo;

    public AdminTeatroImpl(AdministrativoRepo administrativoRepo) {
        this.administrativoRepo = administrativoRepo;
    }


    @Override
    public Funcion crearFuncion(Funcion funcion) {
        return null;
    }

    @Override
    public Funcion eliminarFuncion(Integer idFuncion) {
        return null;
    }

    @Override
    public Funcion actualizarFuncion(Funcion funcion) {
        return null;
    }

    @Override
    public List<Funcion> listarFuncion() {
        return null;
    }

    @Override
    public Sala crearSala(Sala sala) {
        return null;
    }

    @Override
    public void eliminarSala(Integer idSala) {

    }

    @Override
    public Sala actualizarSala(Sala sala) {
        return null;
    }

    @Override
    public List<Sala> listarSala() {
        return null;
    }
}
