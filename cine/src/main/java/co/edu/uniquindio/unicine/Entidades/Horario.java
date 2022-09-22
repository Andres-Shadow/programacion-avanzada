package co.edu.uniquindio.unicine.Entidades;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Horario implements Serializable {

    @Id
    private Integer id;
    private LocalDate dia;
    private String hora_minutos;

}
