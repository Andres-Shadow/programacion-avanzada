package co.edu.uniquindio.unicine.Entidades;

import co.edu.uniquindio.unicine.Intermedia.TeatroSala;
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
public class Teatro implements Serializable {
    @Id
    private Integer id;
    private String nombre;
    private String direccion;
    @ManyToOne
    private Ciudad ciudad;
    @ManyToOne
    private Administrativo admin;
    @OneToMany(mappedBy = "teatro")
    private List<TeatroSala> teatroSala;

}
