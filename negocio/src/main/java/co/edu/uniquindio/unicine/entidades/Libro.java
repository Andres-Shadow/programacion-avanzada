package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;

import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Getter //ahorra espacio para no poner ni los get ni los set
@Setter
@NoArgsConstructor //constructor vacio
@AllArgsConstructor //constructor con todo
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Libro implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    private Integer isbn;
    @Column(nullable = false)
    private String nombre;
    @PositiveOrZero
    private Integer unidades;
    private Integer anioPublicacion;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genero genero;

    @ManyToMany(mappedBy = "libros")
    private List<Prestamo> prestamos;

    @ManyToMany
    private List<Autor> autores;
}
