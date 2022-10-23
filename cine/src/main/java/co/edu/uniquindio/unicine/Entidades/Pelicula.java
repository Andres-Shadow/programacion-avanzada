package co.edu.uniquindio.unicine.Entidades;

import co.edu.uniquindio.unicine.Tipos.Estado_PElicula;
import co.edu.uniquindio.unicine.Tipos.Genero_Pelicula;
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
public class Pelicula implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @ToString.Include
    private Integer id;
    @Column(nullable = false, unique = true, length = 50)
    @ToString.Include
    private String nombre;
    @Column(nullable = false, unique = true)
    @ToString.Include
    private String trailler;
    @Column(nullable = false)
    @ToString.Include
    private String imagen;
    @Column(nullable = false)
    @ToString.Include
    private String sinopsis;
    @Column(nullable = false)
    @ToString.Include
    private String reparto;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @ToString.Include
    private Genero_Pelicula genero;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @ToString.Include
    private Estado_PElicula estado;

    //---------- RELACIONES ----------

    @OneToMany(mappedBy = "pelicula")
    @ToString.Exclude
    private List<Funcion> funciones;

    @Builder
    public Pelicula(String nombre, String trailler, String imagen, String sinopsis, String reparto, Genero_Pelicula genero, Estado_PElicula estado){
        this.nombre = nombre;
        this.trailler = trailler;
        this.imagen = imagen;
        this.sinopsis = sinopsis;
        this.reparto = reparto;
        this.genero = genero;
        this.estado = estado;
    }
}
