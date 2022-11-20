package co.edu.uniquindio.unicine.bean;

import co.edu.uniquindio.unicine.Entidades.Ciudad;
import co.edu.uniquindio.unicine.Entidades.Cliente;
import co.edu.uniquindio.unicine.Servicios.ClienteServicio;
import co.edu.uniquindio.unicine.ServiciosImpl.ClienteServicioImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@Component
@Scope("session")
public class SeguridadBean implements Serializable {

    @Getter
    @Setter
    private boolean autenticado;
    @Getter
    @Setter
    private String email, password;

    @Getter @Setter
    private Cliente cliente;

    @Getter @Setter
    private Ciudad ciudadSeleccionada;

    @Autowired
    private ClienteServicio clienteServicio;

    @PostConstruct
    public void init(){
        autenticado = false;
        email = "";
        password = "";
    }

    public String iniciarSesion(){
        if(!email.isEmpty() && !password.isEmpty()){
            try {
                cliente = clienteServicio.login(email, password);
                autenticado = true;
                return "/index?faces-redirect=true";
            } catch (Exception e) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage("login-bean", fm);
            }
        }else{
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", "El correo y contraseña son necesarios");
            FacesContext.getCurrentInstance().addMessage("login-bean", fm);
        }
        return null;
    }

    public String cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index?faces-redirect=true";
    }

    public void elegirCiudad(Ciudad ciudad){
        this.ciudadSeleccionada = ciudad;
    }
}
