package co.edu.uniquindio.unicine.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.faces.view.ViewScoped;
import java.io.Serializable;

@ViewScoped
@Component
public class InicioBean implements Serializable {
    @Getter @Setter
    private String mensaje = "MAJO GOD <3";
    @Getter @Setter
    private String dato1, dato2;

    public void cambiarValores(){
        String aux = dato1;
        dato1 = dato2;
        dato2 = aux;
    }
}
