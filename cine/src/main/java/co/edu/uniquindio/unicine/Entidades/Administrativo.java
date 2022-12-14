package co.edu.uniquindio.unicine.Entidades;

import co.edu.uniquindio.unicine.Tipos.Tipo_Admin;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Administrativo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    @EqualsAndHashCode.Include
    private Integer id;
    @Enumerated(EnumType.STRING)
    @ToString.Include
    private Tipo_Admin tipo;
    @Column(nullable = false, length = 50, unique = true)
    @ToString.Include
    private String nombre;
    @Column(nullable = false, length = 50, unique = true)
    @ToString.Include
    @Positive
    private String cedula;

    @ToString.Include
    @Column(nullable = false, length = 50, unique = true)
    @Email
    private String correo;
    @ToString.Include
    @Column(nullable = false, length = 200)
    private String contrasenia;

    //---------- RELACIONES -----------
    @ToString.Exclude
    @OneToMany(mappedBy = "admin")
    private List<Teatro> teatros;
    @OneToMany(mappedBy = "supervisor")
    @ToString.Exclude
    private List<Administrativo> supervisados;
    @ManyToOne
    @ToString.Exclude
    private Administrativo supervisor;
    @Builder
    public Administrativo(Integer id, Tipo_Admin tipo, String nombre, String cedula, String correo, String contrasenia){
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.contrasenia= contrasenia;
    }

}
