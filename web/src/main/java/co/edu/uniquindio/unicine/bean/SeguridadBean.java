package co.edu.uniquindio.unicine.bean;

import co.edu.uniquindio.unicine.Entidades.Administrativo;
import co.edu.uniquindio.unicine.Entidades.Ciudad;
import co.edu.uniquindio.unicine.Entidades.Cliente;
import co.edu.uniquindio.unicine.Servicios.AdminServicio;
import co.edu.uniquindio.unicine.Servicios.ClienteServicio;
import co.edu.uniquindio.unicine.Tipos.Tipo_Admin;
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
    private Administrativo admin;

    @Getter @Setter
    private Ciudad ciudadSeleccionada;

    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    private AdminServicio adminServicio;

    @Getter @Setter
    private String tipoSesion;

    @PostConstruct
    public void init(){
        autenticado = false;
        email = "";
        password = "";
        tipoSesion="";
    }

    public String iniciarSesion(){
        if(!email.isEmpty() && !password.isEmpty()){
            try {
                cliente = clienteServicio.login(email, password);
                if(cliente!=null){
                    tipoSesion="cliente";
                    autenticado = true;
                    return "/index?faces-redirect=true";
                }
                else{
                    admin = adminServicio.loginAdmin(email, password);
                    if(admin!=null){
                        tipoSesion="admin-global";
                        autenticado = true;
                        return "/gestion_unicine?faces-redirect=true";
                    }else{
                        admin = adminServicio.loginAdminTeatro(email, password);
                        if(admin!=null){
                            tipoSesion="admin-teatro";
                            autenticado = true;
                            return "/gestion_unicine?faces-redirect=true";
                        }
                    }
                }


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
