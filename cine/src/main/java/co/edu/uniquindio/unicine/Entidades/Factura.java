package co.edu.uniquindio.unicine.Entidades;

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
public class Factura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Float valorCompleto;


    // ---------- RELACIONES -------------
    @OneToMany(mappedBy = "factura")
    private List<Compra> compras;
    @OneToMany(mappedBy = "factura")
    private List<Entrada> entrada;
}
