package co.edu.uniquindio.unicine.Entidades;

import co.edu.uniquindio.unicine.Intermedia.CuponCliente;
import co.edu.uniquindio.unicine.Tipos.Tipo_Cupon;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cupon implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @ToString.Include
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @ToString.Include
    private Tipo_Cupon tipo;
    @Column(nullable = false, length = 10)
    @ToString.Include
    private Float valorDescuento;
    @DateTimeFormat
    @ToString.Include
    private LocalDateTime fechaVencimiento;
    @Column(nullable = false, length = 250)
    @ToString.Include
    private String descripcion;
    @Column(nullable = false)
    @ToString.Include
    private Boolean estado;

    //--------- RELACIONES -----------
    @OneToMany(mappedBy = "cupon")
    @ToString.Exclude
    private List<CuponCliente> clientes;
    @ManyToOne
    @ToString.Exclude
    private Compra compra;
    @Builder
    public Cupon(Tipo_Cupon tipo, Float valor, LocalDateTime fecha, String descripcion, Boolean estado){
            this.tipo = tipo;
            this.valorDescuento = valor;
            this.fechaVencimiento = fecha;
            this.descripcion = descripcion;
            this.estado = estado;
    }
}
