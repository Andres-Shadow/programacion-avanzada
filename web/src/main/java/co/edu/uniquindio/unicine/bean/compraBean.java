package co.edu.uniquindio.unicine.bean;

import co.edu.uniquindio.unicine.Entidades.*;
import co.edu.uniquindio.unicine.Servicios.ClienteServicio;
import co.edu.uniquindio.unicine.Tipos.Genero_Pelicula;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class compraBean implements Serializable {

    @Value("#{param['compra_id']}")
    private String compraCodigo;

    @Autowired
    private ClienteServicio clienteServicio;

    @Getter @Setter
    private Compra compra;

    @PostConstruct
    public void init(){
        compra = new Compra();
    }

    @Getter @Setter
    private List<Confiteria> confiteria;

    @Getter @Setter
    private int sillas_cant;

    @Getter @Setter
    private Entrada entrada;


    public void registrarCompra(){
        try {
//            clienteServicio.comprar();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }










}
