package co.edu.uniquindio.unicine.Servicios;

import co.edu.uniquindio.unicine.Entidades.*;

import java.util.List;

public interface AdminServicio {

    Administrativo login(String cedula)throws Exception;

    //Gestionar Ciudad
    Ciudad crearCiudad(Ciudad ciudad)throws Exception;
    void eliminarCiudad(Integer idCiudad)throws Exception;
    Ciudad actualizarCiudad(Ciudad ciudad)throws Exception;
    List<Ciudad> listarCiudad();

    //Gestionar teatro
    Teatro crearTeatro(Teatro teatro)throws Exception;
    void eliminarTeatro(Integer idTeatro)throws Exception;
    Teatro actualizarTeatro(Teatro teatro)throws Exception;
    List<Teatro> listarTeatro();

    //Gestionar cupon
    Cupon crearCupon(Cupon cupon)throws Exception;
    void eliminarCupon(Integer idCupon)throws Exception;
    Cupon actualizarCupon(Cupon cupon)throws Exception;
    List<Cupon> listarCupon();

    //Gestionar confiteria
    Confiteria crearConfiteria(Confiteria confiteria)throws Exception;
    void eliminarConfiteria(Integer idConfiteria)throws Exception;
    Confiteria actualizarConfiteria(Confiteria confiteria)throws Exception;
    List<Confiteria> listarConfiteria();

    //Gestionar peliculas
    Pelicula crearPelicula(Pelicula pelicula)throws Exception;
    void eliminarPelicula(Integer idPelicula)throws Exception;
    Pelicula actualizarPelicula(Pelicula pelicula)throws Exception;
    List<Pelicula> listarPelicula();

    Administrativo crearAdminTeatro(Administrativo adminTeatro)throws Exception;
    void eliminarAdminTeatro(String numCedula, Integer idAdmin)throws Exception;
    Administrativo actualizarAdminTeatro(Administrativo adminTeatro)throws Exception;
    List<Administrativo> listarAdminTeatro();

}