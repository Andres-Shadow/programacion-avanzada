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
public class Teatro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @ToString.Include
    private Integer id;
    @Column(nullable = false, unique = true)
    @ToString.Include
    private String nombre;
    @Column(nullable = false, unique = true)
    @ToString.Include
    private String direccion;

    // ----------  RELACIONES ----------- //
    @ManyToOne
    @ToString.Exclude
    private Ciudad ciudad;

    @ManyToOne
    @ToString.Exclude
    private Administrativo admin;


    @OneToMany(mappedBy = "teatro")
    private List<Sala> salas;


    @Builder
    public Teatro(String nombre, String direccion){
        this.nombre = nombre;
        this.direccion = direccion;
    }

}
