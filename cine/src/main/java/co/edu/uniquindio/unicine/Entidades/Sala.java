package co.edu.uniquindio.unicine.Entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Sala implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    @Column(nullable = false)
    @ToString.Include
    private Integer sillaTotal;
    @Column(nullable = false)
    @ToString.Include
    private Integer sillaDsiponible;

    //----------- RELACIONES ------------

    @ManyToOne
    @ToString.Exclude
    private Teatro teatro;

    @OneToMany(mappedBy = "sala")
    @ToString.Exclude
    private List<Funcion> funciones;


    @Builder
    public Sala ( Integer sillaTotal, Integer sillaDsiponible){
        this.sillaTotal = sillaTotal;
        this.sillaDsiponible = sillaDsiponible;
    }

    @Override
    public String toString() {
        return "Sala "+ id;
    }
}
