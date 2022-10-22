package co.edu.uniquindio.unicine.Entidades;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
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
public class Factura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    @EqualsAndHashCode.Include
    private Integer id;
    @PositiveOrZero
    @ToString.Include
    @Column(nullable = false)
    private Float valorCompleto;
    @DateTimeFormat
    @Column(nullable = false)
    @ToString.Include
    private LocalDateTime fecha;


    // ---------- RELACIONES -------------
    @OneToMany(mappedBy = "factura")
    @ToString.Exclude
    private List<Compra> compras;
    @OneToMany(mappedBy = "factura")
    @ToString.Exclude
    private List<Entrada> entrada;
    @Builder
    public Factura(Float valorCompleto, LocalDateTime fecha){
        this.valorCompleto = valorCompleto;
        this.fecha = fecha;
    }


}
