package co.edu.uniquindio.unicine.bean;


import co.edu.uniquindio.unicine.Entidades.Pelicula;
import co.edu.uniquindio.unicine.Servicios.AdminServicio;
import co.edu.uniquindio.unicine.ServiciosImpl.CloudinaryServicioImpl;
import co.edu.uniquindio.unicine.Tipos.Genero_Pelicula;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@ViewScoped
public class PeliculaBean {

    @Getter @Setter
    private int indice;
    @Autowired
    private AdminServicio adminServicio;
    @Getter @Setter
    private Pelicula pelicula;

    @Autowired
    private CloudinaryServicioImpl cloudinary;

    @Getter @Setter
    private List<Genero_Pelicula> generos;

    private Map<String, String> imagenes;

    @PostConstruct
    public void init(){
        pelicula = new Pelicula();
        generos = Arrays.asList(Genero_Pelicula.values());
        imagenes = new HashMap<>();
    }

    public String registrarPelicula(){
        try {
            if(!imagenes.isEmpty()){
                pelicula.setImagenes(imagenes);
                adminServicio.crearPelicula(pelicula);

                FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta",
                        "Es necesario subir al menos una imagen ");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", facesMsg);

                return "/admin/pelicula_creada?faces-redirect=true";
            }else{
                FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta",
                        "Es necesario subir al menos una imagen ");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", facesMsg);
            }
        }catch (Exception e){
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta",
                    e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", facesMsg);
        }

        return "";
    }

    public void subirImagen(FileUploadEvent event){
        try {
            UploadedFile imagen = event.getFile();
            File imagenFile = convertirUploadedFile(imagen);
            Map resultado = cloudinary.subirImagen(imagenFile, "peliculas");
            imagenes.put(resultado.get("public_id").toString(), resultado.get("url").toString());

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private File convertirUploadedFile(UploadedFile uploadedFile) throws IOException {
        File file = new File(uploadedFile.getFileName());
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(uploadedFile.getContent());
        fos.close();
        return file;
    }

    public int contador(boolean flag){
        if (flag){
            return indice++;
        }
        else{
            return indice;
        }
    }

}
