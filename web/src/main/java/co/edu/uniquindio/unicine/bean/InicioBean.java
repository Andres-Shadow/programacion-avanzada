package co.edu.uniquindio.unicine.bean;

import co.edu.uniquindio.unicine.Entidades.Ciudad;
import co.edu.uniquindio.unicine.Entidades.Pelicula;
import co.edu.uniquindio.unicine.Servicios.AdminServicio;
import co.edu.uniquindio.unicine.Tipos.Estado_PElicula;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ViewScoped
@Component
public class InicioBean implements Serializable {

    @Autowired
    private AdminServicio adminServicio;

    @Getter @Setter
    private List<Pelicula> cartelera;

    @Getter @Setter
    private List<Pelicula> preventa;

    @Getter @Setter
    private List<Ciudad> ciudades;

    @Getter @Setter
    private Ciudad ciudadSeleccionada;

    @Getter @Setter
    private List<String> imagenes;

    @PostConstruct
    public void init(){

        try {
            imagenes = new ArrayList<>();
            imagenes.add("");
            imagenes.add("");
            imagenes.add("");
            cartelera = adminServicio.listarPeliculaPorEstadoIndependiente(Estado_PElicula.EMISION);
            preventa =  adminServicio.listarPeliculaPorEstadoIndependiente(Estado_PElicula.PREVENTA);
            ciudades = adminServicio.listarCiudad();
        } catch (Exception e ) {
            throw new RuntimeException(e);
        }

    }

    public void elegirCiudad(){
        try {
            if(ciudadSeleccionada!=null){
                cartelera = adminServicio.listarPeliculaPorEstado(Estado_PElicula.EMISION, ciudadSeleccionada.getNombre());
                preventa = adminServicio.listarPeliculaPorEstado(Estado_PElicula.PREVENTA, ciudadSeleccionada.getNombre());
            }
        } catch (Exception e) {
         throw new RuntimeException(e);
         }
    }

}
