package co.edu.uniquindio.unicine.Entidades;

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
public class Ciudad implements Serializable {
    @Id
    private Integer id;
    private String nombre;
    @OneToMany(mappedBy = "ciudad")
    private List<Teatro> teatros;
}
