package co.edu.uniquindio.unicine.bean;

import co.edu.uniquindio.unicine.Entidades.Pelicula;
import co.edu.uniquindio.unicine.Servicios.AdminTeatroServicio;
import co.edu.uniquindio.unicine.Servicios.ClienteServicio;
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
public class BusquedaBean implements Serializable {
    @Getter @Setter
    private String busqueda;

    @Value("#{param['busqueda']}")
    private String busquedaParam;

    @Getter @Setter
    private List<Pelicula> peliculas;

    @Autowired
    private ClienteServicio clienteServicio;

    @PostConstruct
    public void init(){
       if(busquedaParam!= null && !busquedaParam.isEmpty()){
           try {
               peliculas = clienteServicio.listarPeliculasPorNombre(busquedaParam);
           } catch (Exception e) {
               peliculas = null;
           }
       }
    }

    public String buscar(){
        if(!busqueda.isEmpty()){
            return "resultado_busqueda?faces-redirect=true&amp;busqueda="+busqueda;
        }

        return "";
    }

}
