package co.edu.uniquindio.unicine.Entidades;

import co.edu.uniquindio.unicine.Intermedia.TeatroSala;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Entrada implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    @EqualsAndHashCode.Include
    private Integer id;
    @PositiveOrZero
    @ToString.Include
    @Column(unique = true)
    private Float valor;
    @Column(unique = true)
    @ToString.Include
    private Integer fila;
    @Column(unique = true)
    @ToString.Include
    private Integer columna;


    // ------------ RELACIONES -----------
    @ManyToOne
    @ToString.Exclude
    private Cliente cliente;
    @ManyToOne
    @ToString.Exclude
    private Factura factura;
    @ManyToOne
    @ToString.Exclude
    private Funcion funcion;
    @Builder
    public Entrada(Integer id, Float valor, Integer fila, Integer columna){
        this.id = id;
        this.valor = valor;
        this.fila = fila;
        this.columna = columna;
    }
}
