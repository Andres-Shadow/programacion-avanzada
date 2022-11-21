package co.edu.uniquindio.unicine.bean;


import co.edu.uniquindio.unicine.Entidades.Administrativo;
import co.edu.uniquindio.unicine.Entidades.Ciudad;
import co.edu.uniquindio.unicine.Entidades.Confiteria;
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
public class ConfiteriaBean {
    @Getter @Setter
    private Confiteria confiteria;
    @Autowired
    private AdminServicio adminServicio;

    @Getter @Setter
    private List<Confiteria> confiterias;

    @Getter @Setter
    private List<Confiteria> confiteriasSeleccionadas;


    private boolean editar;

    @PostConstruct
    public void init(){
        editar = false;
        confiteria = new Confiteria();
        confiterias = adminServicio.listarConfiteria();
        confiteriasSeleccionadas = new ArrayList<>();
    }

    public void crearConfiteria(){

        try {
            if(!editar){
                Confiteria registro = adminServicio.crearConfiteria(confiteria);

                confiterias.add(registro);
                confiteria = new Confiteria();

                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Confiteria creada correctamente");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
            }else{
                adminServicio.actualizarConfiteria(confiteria);
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Confiteria actualizada correctamente");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
            }
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
        }


    }

    public void eliminarConfiterias()
    {

        confiteriasSeleccionadas.forEach(c -> {
            try {
                adminServicio.eliminarConfiteria(c.getId());
                confiterias.remove(c);
            } catch (Exception e) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
            }
        });
        confiteriasSeleccionadas.clear();
    }

    public String getMensajeCrear(){
        if(editar){
            return "Editar Confiteria";
        }else {
            return "Crear Confiteria";
        }
    }

    public String getMensajeBorrar(){
        if(confiteriasSeleccionadas.isEmpty()){
            return "Borrar";
        }else if(confiteriasSeleccionadas.size()==1) {
            return "Borrar " +confiteriasSeleccionadas.size() + " elemento";
        }else{
            return "Borrar " +confiteriasSeleccionadas.size() + " elementos";
        }
    }

    public void seleccionarConfiteria(Confiteria confiteriaSeleccionada){
        this.confiteria = confiteriaSeleccionada;
        editar = true;
    }

    public void crearConfiteriaDialogo(){
        this.confiteria = new Confiteria();
        editar = false;
    }

}
