package co.edu.uniquindio.unicine.Entidades;

import co.edu.uniquindio.unicine.Tipos.Tipo_Admin;
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

public class Administrativo implements Serializable {
    @Id
    private Integer id;
    @Enumerated(EnumType.STRING)
    private Tipo_Admin tipo;
    private String nombre;
    private String cedula;
    @OneToMany(mappedBy = "admin")
    private List<Teatro> teatros;

}
