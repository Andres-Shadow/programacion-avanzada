package co.edu.uniquindio.unicine.Entidades;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Horario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate dia;
    private String hora_minutos;

    //------------ RELACIONES ------------
    @ManyToMany(mappedBy = "horarios")
    private List<Funcion> funciones;

}
