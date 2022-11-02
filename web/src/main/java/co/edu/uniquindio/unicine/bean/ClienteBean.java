package co.edu.uniquindio.unicine.bean;

import co.edu.uniquindio.unicine.Entidades.Cliente;
import co.edu.uniquindio.unicine.Servicios.ClienteServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
public class ClienteBean  implements Serializable {
    @Getter @Setter
    private Cliente cliente;
    @Setter @Getter
    private String confirmacionContra;

    @Autowired
    private ClienteServicio clienteServicio;

    @PostConstruct
    public void init(){
        cliente = new Cliente();
    }
    public void registrarCliente(){
        try {
            if(cliente.getContrasenia().equals(confirmacionContra)){
                clienteServicio.registrarCliente(cliente);
                FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta",
                        "Registro exitoso");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", facesMsg);
            }else {
                FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta",
                        "Registro fallido contraseñas no coinciden");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", facesMsg);
            }
        } catch (Exception e) {
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta",
                    e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", facesMsg);
            throw new RuntimeException(e);
        }
    }

}
