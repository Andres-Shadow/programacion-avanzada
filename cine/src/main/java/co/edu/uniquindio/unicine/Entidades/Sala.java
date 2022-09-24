package co.edu.uniquindio.unicine.Entidades;

import co.edu.uniquindio.unicine.Intermedia.TeatroSala;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Sala implements Serializable {
    @Id
    private Integer id;
    private Integer sillaTotal;
    private Integer sillaDsiponible;
    @OneToMany(mappedBy = "sala")
    private List<TeatroSala> teatroSala;
}
