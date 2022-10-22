package co.edu.uniquindio.unicine.Entidades;

import co.edu.uniquindio.unicine.Intermedia.CuponCliente;
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
public class Compra implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    @EqualsAndHashCode.Include
    private Integer id;
    @Column(length = 50)
    @ToString.Include
    @PositiveOrZero
    private Float valor;

    // --------- RELACIONES -------------
    @ManyToMany
    @ToString.Exclude
    private List<Confiteria> confiterias;
    @ManyToOne
    @ToString.Exclude
    private Factura factura;
    @ManyToOne
    @ToString.Exclude
    private Cliente cliente;

    @OneToOne
    @ToString.Exclude
    private Cupon cupon;
    @Builder
    public Compra(Float valor){
        this.valor=valor;
    }
}
