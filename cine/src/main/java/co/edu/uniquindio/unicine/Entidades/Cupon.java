package co.edu.uniquindio.unicine.Entidades;

import co.edu.uniquindio.unicine.Intermedia.CuponCliente;
import co.edu.uniquindio.unicine.Tipos.Tipo_Cupon;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cupon implements Serializable {
    @Id
    private Integer id;
    @Enumerated(EnumType.STRING)
    private Tipo_Cupon tipo;
    private Float valorDescuento;
    private LocalDateTime fechaVencimiento;
    private String descripcion;

    //--------- RELACIONES -----------
    @OneToMany(mappedBy = "cupon")
    private List<CuponCliente> clientes;
}
