package co.edu.uniquindio.unicine.Entidades;

import co.edu.uniquindio.unicine.Intermedia.TeatroSala;
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
public class Sala implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    @EqualsAndHashCode.Include
    private Integer id;
    @Column(nullable = false)
    @ToString.Include
    private Integer sillaTotal;
    @Column(nullable = false)
    @ToString.Include
    private Integer sillaDsiponible;

    //----------- RELACIONES ------------
    @OneToMany(mappedBy = "sala")
    @ToString.Exclude
    private List<TeatroSala> teatroSala;
    @OneToMany(mappedBy = "sala")
    @ToString.Exclude
    private List<Funcion> funciones;
    @Builder
    public Sala ( Integer sillaTotal, Integer sillaDsiponible){
        this.sillaTotal = sillaTotal;
        this.sillaDsiponible = sillaDsiponible;
    }
}
