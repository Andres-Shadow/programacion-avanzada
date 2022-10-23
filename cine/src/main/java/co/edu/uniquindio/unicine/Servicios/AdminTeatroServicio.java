package co.edu.uniquindio.unicine.Servicios;

import co.edu.uniquindio.unicine.Entidades.Administrativo;
import co.edu.uniquindio.unicine.Entidades.Funcion;
import co.edu.uniquindio.unicine.Entidades.Sala;

import java.util.List;

public interface AdminTeatroServicio {

    Administrativo login(String correo, String cedula)throws Exception;

    //Gestionar funciones
    Funcion crearFuncion(Funcion funcion)throws Exception;
    void eliminarFuncion(Integer idFuncion)throws Exception;
    Funcion actualizarFuncion(Funcion funcion)throws Exception;
    List<Funcion> listarFuncion();

    //Gestionar sala
    Sala crearSala(Sala sala)throws Exception;
    void eliminarSala(Integer idSala)throws Exception;
    Sala actualizarSala(Sala sala)throws Exception;
    List<Sala> listarSala();

}
