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
public class CiudadBean {
    @Getter @Setter
    private Ciudad ciudad;
    @Autowired
    private AdminServicio adminServicio;

    @Getter @Setter
    private List<Ciudad> ciudades;

    @Getter @Setter
    private List<Ciudad> ciudadesSeleccionadas;


    private boolean editar;

    @PostConstruct
    public void init(){
        editar = false;
        ciudad = new Ciudad();
        ciudades = adminServicio.listarCiudad();
        ciudadesSeleccionadas = new ArrayList<>();
    }

    public void crearCiudad(){

        try {
            if(!editar){
                Ciudad registro = adminServicio.crearCiudad(ciudad);

                ciudades.add(registro);
                ciudad = new Ciudad();

                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Ciudad creada correctamente");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
            }else{
                adminServicio.actualizarCiudad(ciudad);
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Ciudad actualizada correctamente");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
            }
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
        }


    }

    public void eliminarCiudades()
    {

        ciudadesSeleccionadas.forEach(c -> {
            try {
                adminServicio.eliminarCiudad(c.getId());
                ciudades.remove(c);
            } catch (Exception e) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
            }
        });
        ciudadesSeleccionadas.clear();
    }

    public String getMensajeCrear(){
        if(editar){
            return "Editar Ciudad";
        }else {
            return "Crear Ciudad";
        }
    }

    public String getMensajeBorrar(){
        if(ciudadesSeleccionadas.isEmpty()){
            return "Borrar";
        }else if(ciudadesSeleccionadas.size()==1) {
            return "Borrar " +ciudadesSeleccionadas.size() + " elemento";
        }else{
            return "Borrar " +ciudadesSeleccionadas.size() + " elementos";
        }
    }

    public void seleccionarCiudad(Ciudad ciudadSeleccionada){
        this.ciudad = ciudadSeleccionada;
        editar = true;
    }

    public void crearCiudadDialogo(){
        this.ciudad = new Ciudad();
        editar = false;
    }

}
