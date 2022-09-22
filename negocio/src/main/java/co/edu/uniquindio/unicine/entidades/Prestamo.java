package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter //ahorra espacio para no poner ni los get ni los set
@Setter
@NoArgsConstructor //constructor vacio
@AllArgsConstructor //constructor con todo
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Prestamo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;
    @Column(nullable = false)
    private LocalDateTime fechaPrestamo; //necesito el momento exacto de la devolucion
    @Column(nullable = false)
    private LocalDate fechaDevolucion; //no me interesa a la hora que lo regresen
    @ManyToOne
    private Cliente cliente;

    @ManyToMany
    private List<Libro> libros;

}
