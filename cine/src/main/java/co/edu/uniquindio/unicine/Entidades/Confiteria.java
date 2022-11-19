package co.edu.uniquindio.unicine.Entidades;

import co.edu.uniquindio.unicine.Intermedia.ComrpaConfiteria;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Confiteria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    @EqualsAndHashCode.Include
    private Integer id;
    @Column(unique = true, nullable = false, length = 50)
    @ToString.Include
    private String nombre;
    @PositiveOrZero
    @ToString.Include
    @Column(length = 50, nullable = false)
    private Float precio;
    @Column(nullable = false)
    @ToString.Include
    private String imagen;
    @Column(unique = true)
    @ToString.Include
    private Integer valorPuntos;

    //------------ RELACIONES -----------
    @OneToMany(mappedBy = "confiteria")
    private List<ComrpaConfiteria> listaCompraConfiterias;


    @Builder
    public Confiteria (String nombre, Float precio, String imagen, Integer puntos){
        this.nombre=nombre;
        this.precio = precio;
        this.imagen= imagen;
        this.valorPuntos = puntos;
    }
}
