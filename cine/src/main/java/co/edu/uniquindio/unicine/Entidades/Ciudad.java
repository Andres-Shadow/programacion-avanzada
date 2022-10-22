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
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ciudad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @ToString.Include
    private Integer id;
    @Column(unique = true, nullable = false, length = 50)
    @ToString.Include
    private String nombre;


    //--------- RELACIONES -----------//
    @ToString.Exclude
    @OneToMany(mappedBy = "ciudad")
    private List<Teatro> teatros;
    @Builder
    public Ciudad(String nombre){
        this.nombre = nombre;
    }
}
