package co.edu.uniquindio.unicine.bean;

import co.edu.uniquindio.unicine.Entidades.Sala;
import co.edu.uniquindio.unicine.Repo.AdministrativoRepo;
import co.edu.uniquindio.unicine.Servicios.AdminServicio;
import co.edu.uniquindio.unicine.Servicios.AdminTeatroServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

@Component
@ViewScoped
public class SalaBean {
    @Autowired
    private AdminTeatroServicio adminServicio;
    @Getter @Setter
    private Sala sala;
    @PostConstruct
    public void init(){
        sala = new Sala();
    }

    public void registrarSala(){
        try {
            adminServicio.crearSala(sala);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
