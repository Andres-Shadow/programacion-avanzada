package co.edu.uniquindio.unicine.Tipos;

import java.util.HashMap;
import java.util.Map;

public enum Genero_Pelicula {
    COMEDIA (1),
    AMOR(2),
    ACCION(3),
    ROMANCE(4),
    TERROR(5),
    DRAMA(6),
    ANIMACION(6),
    AVENTURA(7);

    private int id;
    private static final Map<Integer, Genero_Pelicula> MAP = new HashMap<>();

    private Genero_Pelicula(int id) { this.id = id; }

    public int getId() { return id; }
    public static Genero_Pelicula fromId(int id){
        return MAP.get(id);
    }
    static{
        for(Genero_Pelicula n : values()){
            MAP.put(n.getId(), n);
        }
    }
}
