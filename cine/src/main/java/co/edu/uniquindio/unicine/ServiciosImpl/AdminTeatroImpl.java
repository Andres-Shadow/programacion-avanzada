package co.edu.uniquindio.unicine.ServiciosImpl;

import co.edu.uniquindio.unicine.Entidades.Funcion;
import co.edu.uniquindio.unicine.Entidades.Sala;
import co.edu.uniquindio.unicine.Repo.AdministrativoRepo;
import co.edu.uniquindio.unicine.Servicios.AdminTeatroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminTeatroImpl implements AdminTeatroServicio {
    @Autowired
    private AdministrativoRepo administrativoRepo;

    public AdminTeatroImpl(AdministrativoRepo administrativoRepo) {
        this.administrativoRepo = administrativoRepo;
    }


}
