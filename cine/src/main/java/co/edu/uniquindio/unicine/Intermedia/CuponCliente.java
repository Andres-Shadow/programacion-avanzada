package co.edu.uniquindio.unicine.Intermedia;

import co.edu.uniquindio.unicine.Entidades.Cliente;
import co.edu.uniquindio.unicine.Entidades.Compra;
import co.edu.uniquindio.unicine.Entidades.Cupon;
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
public class CuponCliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @ToString.Include
    private Integer id;
    @PositiveOrZero
    @Column(nullable = false)
    @ToString.Include
    private Integer cantidad;

    //----------- RELACIONES ---------------
    @ManyToOne
    @ToString.Exclude
    private Cliente cliente;
    @ManyToOne
    @ToString.Exclude
    private Cupon cupon;
    @OneToOne(mappedBy = "cupon")
    @ToString.Exclude
    private Compra compra;

    @Builder
    public CuponCliente(Integer cantidad){
        this.cantidad = cantidad;
    }

}
