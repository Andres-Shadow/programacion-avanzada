package co.edu.uniquindio.unicine.bean;


import co.edu.uniquindio.unicine.Entidades.Pelicula;
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
public class PeliculaBean {
    @Autowired
    private AdminServicio adminServicio;
    @Getter @Setter
    private Pelicula pelicula;

    @PostConstruct
    public void init(){
        pelicula = new Pelicula();
    }

    public String registrarPelicula(){
        try {
            //adminServicio.crearPelicula(pelicula);
            return "/admin/pelicula_creada?faces-redirect=true";
        }catch (Exception e){
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta",
                    e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", facesMsg);
        }

        return "";
    }

}
