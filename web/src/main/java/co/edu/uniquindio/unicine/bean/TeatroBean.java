package co.edu.uniquindio.unicine.bean;

import co.edu.uniquindio.unicine.Entidades.Teatro;
import co.edu.uniquindio.unicine.Servicios.AdminServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

@Component
@ViewScoped
public class TeatroBean {
    @Getter @Setter
    private Teatro teatro;
    @Autowired
    private AdminServicio adminServicio;

    @PostConstruct
    public void init(){
        teatro = new Teatro();
    }

    public void registrarTeatro(){
        try {

            adminServicio.crearTeatro(teatro);
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
