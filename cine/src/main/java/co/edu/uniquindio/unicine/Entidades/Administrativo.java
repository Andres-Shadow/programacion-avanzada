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

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Administrativo implements Serializable {
    @Id
    private Integer id;
    @Enumerated(EnumType.STRING)
    private Tipo_Admin tipo;
    private String nombre;
    private String cedula;

}
