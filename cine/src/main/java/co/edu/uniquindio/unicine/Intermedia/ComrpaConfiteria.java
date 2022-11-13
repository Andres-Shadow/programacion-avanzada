package co.edu.uniquindio.unicine.Intermedia;

import co.edu.uniquindio.unicine.Entidades.Compra;
import co.edu.uniquindio.unicine.Entidades.Confiteria;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ComrpaConfiteria implements Serializable {
    @Id
    @ToString.Include
    @EqualsAndHashCode.Include
    private Integer id;
    @ToString.Include
    @Column(nullable = false)
    private Float precio;
    @ToString.Include
    @Column(nullable = false)
    private Integer unidades;

    //---------- relacionese

    @ToString.Exclude
    @ManyToOne
    private Confiteria confiteria;

    @ManyToOne
    @ToString.Exclude
    private Compra compra;

    @Builder
    public ComrpaConfiteria(Float precio, Integer unidades){
        this.precio = precio;
        this.unidades = unidades;
    }

}
