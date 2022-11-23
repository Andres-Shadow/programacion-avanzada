package co.edu.uniquindio.unicine.bean;

import co.edu.uniquindio.unicine.Servicios.ClienteServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
public class ActivaciónCuentaBean implements Serializable {

    @Value("#{param['p1']}")
    private String parametro1;

    @Autowired
    private ClienteServicio clienteServicio;

    @Getter @Setter
    private String mensaje = "Verificando la sesión";

    @PostConstruct
    public void init(){
        if(parametro1!=null && !parametro1.isEmpty()){
            try {
                clienteServicio.activarCliente(parametro1);
                mensaje = "Cuenta activada";
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
