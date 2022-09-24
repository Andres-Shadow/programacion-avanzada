package co.edu.uniquindio.unicine.Entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Compra implements Serializable {
    @Id
    private Integer id;
    private Float valor;
    @OneToMany(mappedBy = "compra")
    private List<Confiteria> confiterias;
    @ManyToOne
    private Factura factura;
}
