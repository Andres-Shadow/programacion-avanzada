package co.edu.uniquindio.unicine.ServiciosImpl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryServicioImpl {

    private Cloudinary cloudinary;
    private Map<String, String> config;

    public CloudinaryServicioImpl(){
        config = new HashMap<>();
        config.put("cloud_name","dpqdgyicu");
        config.put("api_key","853894814229695");
        config.put("api_secret","FMECeEayTWnOp8vrkcLnsyVrbzc");

        cloudinary = new Cloudinary(config);
    }

    public Map subirImagen(File file, String carpeta){
        Map respuesta = null;
        try {
            respuesta = cloudinary.uploader().upload(file, ObjectUtils.asMap("folder",carpeta));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return respuesta;
    }

    public Map eliminarImagen(String idImagen){
        Map respuesta = null;
        try {
            respuesta = cloudinary.uploader().destroy(idImagen, ObjectUtils.emptyMap());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return respuesta;
    }
}
