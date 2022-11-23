package co.edu.uniquindio.unicine.bean;


import co.edu.uniquindio.unicine.Entidades.Administrativo;
import co.edu.uniquindio.unicine.Entidades.Ciudad;
import co.edu.uniquindio.unicine.Entidades.Cupon;
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
public class CuponBean {
    @Getter @Setter
    private Cupon cupon;
    @Autowired
    private AdminServicio adminServicio;

    @Getter @Setter
    private List<Cupon> cupones;

    @Getter @Setter
    private List<Cupon> cuponesSeleccionados;


    private boolean editar;

    @PostConstruct
    public void init(){
        editar = false;
        cupon = new Cupon();
        cupones = adminServicio.listarCupon();
        cuponesSeleccionados = new ArrayList<>();
    }

    public void crearCupon(){

        try {
            if(!editar){
                Cupon registro = adminServicio.crearCupon(cupon);

                cupones.add(registro);
                cupon = new Cupon();

                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Cupon creada correctamente");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
            }else{
                adminServicio.actualizarCupon(cupon);
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Cupon actualizada correctamente");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
            }
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
        }


    }

    public void eliminarCupones()
    {

        cuponesSeleccionados.forEach(c -> {
            try {
                adminServicio.eliminarCupon(c.getId());
                cupones.remove(c);
            } catch (Exception e) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
            }
        });
        cuponesSeleccionados.clear();
    }

    public String getMensajeCrear(){
        if(editar){
            return "Editar cupon";
        }else {
            return "Crear cupon";
        }
    }

    public String getMensajeBorrar(){
        if(cuponesSeleccionados.isEmpty()){
            return "Borrar";
        }else if(cuponesSeleccionados.size()==1) {
            return "Borrar " +cuponesSeleccionados.size() + " elemento";
        }else{
            return "Borrar " +cuponesSeleccionados.size() + " elementos";
        }
    }

    public void seleccionarCupon(Cupon cuponSeleccionado){
        this.cupon = cuponSeleccionado;
        editar = true;
    }

    public void crearCuponDialogo(){
        this.cupon = new Cupon();
        editar = false;
    }

}
