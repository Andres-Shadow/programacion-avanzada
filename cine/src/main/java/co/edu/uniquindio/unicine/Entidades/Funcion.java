package co.edu.uniquindio.unicine.Entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Funcion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    private Integer id;


    // ----------- RELACIONES -------------
    @ManyToOne
    @ToString.Exclude
    private Pelicula pelicula;

    @OneToMany(mappedBy = "funcion")
    @ToString.Exclude
    private List<Entrada> entradas;


    @ManyToOne
    @ToString.Exclude
    private Horario horario;

    @ManyToOne
    @ToString.Exclude
    private Sala sala;

    @Builder
    public Funcion( Pelicula pelicula, Sala sala) {
        this.pelicula = pelicula;
        this.sala = sala;
    }
}
