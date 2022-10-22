package co.edu.uniquindio.unicine.Intermedia;

import co.edu.uniquindio.unicine.Entidades.Entrada;
import co.edu.uniquindio.unicine.Entidades.Sala;
import co.edu.uniquindio.unicine.Entidades.Teatro;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TeatroSala implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @ToString.Include
    private Integer id;
    @ManyToOne
    @ToString.Exclude
    private Teatro teatro;
    @ManyToOne
    @ToString.Exclude
    private Sala sala;


}
