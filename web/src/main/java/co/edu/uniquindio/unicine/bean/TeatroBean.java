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
import java.util.ArrayList;
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

    public boolean editar;
    @PostConstruct
    public void init(){
        teatro = new Teatro();
        editar = false;
        ciudades = adminServicio.listarCiudad();
        teatros = adminServicio.listarTeatro();
        teatrosSeleccionados = new ArrayList<>();
    }

    public void registrarTeatro(){

        try {
            if(!editar){
                //ESTO SE DEBE BORRAR DESPUES MI SOCIO
                Administrativo admin = adminServicio.obtenerAdminTeatro(1, Tipo_Admin.ADMINISTRADOR_TEATRO);
                teatro.setAdmin(admin);

                Teatro teatroNuevo = adminServicio.crearTeatro(teatro);
                teatros.add(teatroNuevo);

                teatro = new Teatro();
                FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta",
                        "Registro exitoso");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", facesMsg);
            }else{
                adminServicio.actualizarTeatro(teatro);
            }
        } catch (Exception e) {
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", facesMsg);

        }
    }

    public void elimiarTeatros(){
        teatrosSeleccionados.forEach( t -> {
            try {
                adminServicio.eliminarTeatro(t.getId());
                teatros.remove(t);

            } catch (Exception e) {
                FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", facesMsg);
            }
        });

        teatrosSeleccionados.clear();
    }

    public String getTextroBtnBorrar(){
        if(teatrosSeleccionados.size()==0){
            return "Borrar";
        }else{
            return teatrosSeleccionados.size()==1 ? "Borrar 1 elemento" : "Borrar "+teatrosSeleccionados.size()+" elementos";
        }
    }

    public String getTextoActualizar(){
        return editar ? "Actualizar" : "Crear";
    }

    public void seleccionarTeatro(Teatro teatroSeleccionado){
        editar = true;
        this.teatro = teatroSeleccionado;

    }

    public void crearTeatroDialogo(){
        this.teatro = new Teatro();
        this.editar = false;
    }
}
