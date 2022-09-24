package co.edu.uniquindio.unicine.Entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pelicula implements Serializable {
    @Id
    private Integer id;
    private String nombre;
    private String trailler;
    private String imagen;
    private String sinopsis;
    private String reparto;
    @Enumerated(EnumType.STRING)
    private Genero_Pelicula genero;
    @Enumerated(EnumType.STRING)
    private Estado_PElicula estado;
    @OneToMany(mappedBy = "pelicula")
    private List<Funcion> funciones;
}
