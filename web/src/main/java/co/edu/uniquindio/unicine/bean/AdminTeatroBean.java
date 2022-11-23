package co.edu.uniquindio.unicine.bean;

import co.edu.uniquindio.unicine.Entidades.Administrativo;
import co.edu.uniquindio.unicine.Servicios.AdminServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class AdminTeatroBean {
    @Getter @Setter
    private Administrativo administrador;
    @Autowired
    private AdminServicio adminServicio;

    @Getter @Setter
    private List<Administrativo> administradores;

    @Getter @Setter
    private List<Administrativo> administradoresSeleccionados;


    private boolean editar;

    @PostConstruct
    public void init(){
        editar = false;
        administrador = new Administrativo();
        administradores = adminServicio.listarAdminTeatro();
        administradoresSeleccionados = new ArrayList<>();
    }

    public void crearAdministrador(){

        try {
            if(!editar){
                Administrativo registro = adminServicio.crearAdminTeatro(administrador);
                administradores.add(registro);
                administrador = new Administrativo();

                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Admin creado correctamente");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
            }else{
                adminServicio.actualizarAdminTeatro(administrador);
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Admin actualizado correctamente");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
            }
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
        }


    }

    public void eliminarAdministradores()
    {

        administradoresSeleccionados.forEach(c -> {
            try {
                adminServicio.eliminarAdminTeatro(c.getId());
                administradores.remove(c);
            } catch (Exception e) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
            }
        });
        administradoresSeleccionados.clear();
    }

    public String getMensajeCrear(){
        if(editar){
            return "Editar Admin";
        }else {
            return "Crear Admin";
        }
    }

    public String getMensajeBorrar(){
        if(administradoresSeleccionados.isEmpty()){
            return "Borrar";
        }else if(administradoresSeleccionados.size()==1) {
            return "Borrar " +administradoresSeleccionados.size() + " elemento";
        }else{
            return "Borrar " +administradoresSeleccionados.size() + " elementos";
        }
    }

    public void seleccionarAdministrador(Administrativo adminSeleccionado){
        this.administrador = adminSeleccionado;
        editar = true;
    }

    public void crearAdministradorDialogo(){
        this.administrador = new Administrativo();
        editar = false;
    }

}