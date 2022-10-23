package co.edu.uniquindio.unicine.Entidades;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Horario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    @EqualsAndHashCode.Include
    private Integer id;
    @DateTimeFormat
    @ToString.Include
    @Column(nullable = false)
    private LocalDateTime dia;
    @Column(nullable = false)
    @ToString.Include
    private String hora_minutos;
    @DateTimeFormat
    @Column(nullable = false)
    @ToString.Include
    private LocalDate inicio;
    @DateTimeFormat
    @Column(nullable = false)
    @ToString.Include
    private LocalDate fin;

    //------------ RELACIONES ------------
    @ManyToMany(mappedBy = "horarios")
    @ToString.Exclude
    private List<Funcion> funciones;

    @Builder
    public Horario(LocalDateTime dia, String hora_minutos, LocalDate inicio, LocalDate fin){
        this.dia = dia;
        this.hora_minutos = hora_minutos;
        this.inicio = inicio;
        this.fin = fin;
    }

}
