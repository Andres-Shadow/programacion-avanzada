package co.edu.uniquindio.unicine.Servicios;

import co.edu.uniquindio.unicine.Entidades.Funcion;
import co.edu.uniquindio.unicine.Entidades.Sala;

import java.util.List;

public interface AdminTeatroServicio {

    //Gestionar funciones
    Funcion crearFuncion(Funcion funcion);
    Funcion eliminarFuncion(Integer idFuncion);
    Funcion actualizarFuncion(Funcion funcion);
    List<Funcion> listarFuncion();

    //Gestionar sala
    Sala crearSala(Sala sala);
    void eliminarSala(Integer idSala);
    Sala actualizarSala(Sala sala);
    List<Sala> listarSala();

}
