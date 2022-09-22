package co.edu.uniquindio.unicine.Entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

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
}
