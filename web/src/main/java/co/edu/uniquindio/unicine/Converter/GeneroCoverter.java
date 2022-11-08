package co.edu.uniquindio.unicine.Converter;

import co.edu.uniquindio.unicine.Tipos.Genero_Pelicula;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@Component
public class GeneroCoverter implements Converter<Genero_Pelicula> {

    @Override
    public Genero_Pelicula getAsObject(FacesContext context, UIComponent component, String value) {

        Genero_Pelicula genero = null;
        System.out.println(value);
        genero = Genero_Pelicula.fromId(Integer.parseInt(value));

        return genero;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Genero_Pelicula value) {
        if(value!=null){
            return ""+value;
        }else{
            return "";
        }
    }
}
