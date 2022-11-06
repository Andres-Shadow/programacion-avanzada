package co.edu.uniquindio.unicine.bean;

import co.edu.uniquindio.unicine.Entidades.Administrativo;
import co.edu.uniquindio.unicine.Entidades.Ciudad;
import co.edu.uniquindio.unicine.Entidades.Teatro;
import co.edu.uniquindio.unicine.Repo.AdministrativoRepo;
import co.edu.uniquindio.unicine.Servicios.AdminServicio;
import co.edu.uniquindio.unicine.Tipos.Tipo_Admin;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.util.List;

@Component
@ViewScoped
public class TeatroBean {
    @Getter @Setter
    private Teatro teatro;
    @Autowired
    private AdminServicio adminServicio;

    @Getter @Setter
    private List<Ciudad> ciudades;
    @Getter @Setter
    private List<Teatro> teatros;
    @Getter @Setter
    private List<Teatro> teatrosSeleccionados;

    @PostConstruct
    public void init(){
        teatro = new Teatro();
        ciudades = adminServicio.listarCiudad();
        teatros = adminServicio.listarTeatro();
    }

    public void registrarTeatro(){

        try {
            //ESTO SE DEBE BORRAR DESPUES MI SOCIO
            Administrativo admin = adminServicio.obtenerAdminTeatro(1, Tipo_Admin.ADMINISTRADOR_TEATRO);
            teatro.setAdmin(admin);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        try {

            Teatro teatroNuevo = adminServicio.crearTeatro(teatro);
            teatros.add(teatroNuevo);
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta",
                    "Registro exitoso");
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta",
                    e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", facesMsg);
            throw new RuntimeException(e);
        }
    }
}
