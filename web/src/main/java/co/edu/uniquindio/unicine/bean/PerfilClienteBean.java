package co.edu.uniquindio.unicine.bean;

import co.edu.uniquindio.unicine.Entidades.Cliente;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

@Component
@ViewScoped
public class PerfilClienteBean {

    @Getter @Setter
    @Value(value = "#{seguridadBean.cliente}")
    private Cliente clienteSesion;

    @PostConstruct
    public void init(){

    }



}
