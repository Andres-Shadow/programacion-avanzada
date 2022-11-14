package co.edu.uniquindio.unicine.bean;

import co.edu.uniquindio.unicine.Entidades.Pelicula;
import co.edu.uniquindio.unicine.Servicios.AdminServicio;
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
public class DetallePeliculaBean implements Serializable {

    @Value("#{param['pelicula_id']}")
    private String peliculaCodigo;

    @Autowired
    private AdminServicio adminServicio;

    @Getter @Setter
    private Pelicula pelicula;

    @PostConstruct
    public void init(){
        try {
            if(peliculaCodigo!=null && !peliculaCodigo.isEmpty())
                pelicula = adminServicio.obtnerPeliculaPorSuId(Integer.parseInt(peliculaCodigo));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String redireccionar(Pelicula pelicula){
        return "/admin_teatro/detalle_pelicula?faces-redirect=true";
    }

}
