package co.edu.uniquindio.unicine.Entidades;

import co.edu.uniquindio.unicine.Intermedia.TeatroSala;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Entrada implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Float valor;
    private Integer fila;
    private Integer columna;
    @ManyToOne
    private Cliente cliente;
    @OneToMany(mappedBy = "entrada")
    private List<Factura> facturas;
    @ManyToOne
    private Funcion funcion;
    @ManyToOne
    private TeatroSala teatroSala;
}
