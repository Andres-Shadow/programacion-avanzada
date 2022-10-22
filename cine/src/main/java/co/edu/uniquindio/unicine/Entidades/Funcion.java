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
public class Funcion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    // ----------- RELACIONES -------------
    @ManyToOne
    private Pelicula pelicula;
    @OneToMany(mappedBy = "funcion")
    private List<Entrada> entradas;
    @ManyToMany
    private List<Horario> horarios;
    @ManyToOne
    private Sala sala;
    //AGREGAR LA ID DE LA SALA PARA LA FUNCION


}
