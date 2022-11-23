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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public String obtenerFecha(int dia){
        String[] semana =new String[] {"LUN", "MAR", "MIE", "JUE", "VIE", "SAB", "DOM"};
        String fecha = "";
        DateFormat df = new SimpleDateFormat("dd/MM/yy");
        Date fechaActual = new Date();
        int dias = (24 * 60 * 60 * 1000) * dia;
        Date fechaFinal = new Date(fechaActual.getTime() + dias);
        fecha = df.format(fechaFinal);
        fecha = semana[fechaFinal.getDay()] + "\n" + fecha;
        return fecha;
    }


    public String redireccionar(Pelicula pelicula){
        return "/admin_teatro/detalle_pelicula?faces-redirect=true";
    }

}
