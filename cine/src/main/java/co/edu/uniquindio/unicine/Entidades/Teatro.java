package co.edu.uniquindio.unicine.Entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Teatro implements Serializable {
    @Id
    private Integer id;
    private String nombre;
    private String direccion;
    @ManyToOne
    private Ciudad ciudad;
    @ManyToOne
    private Administrativo admin;

}
