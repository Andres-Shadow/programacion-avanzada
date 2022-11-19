package co.edu.uniquindio.unicine.Entidades;

import co.edu.uniquindio.unicine.Intermedia.CuponCliente;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    @EqualsAndHashCode.Include
    private Integer id;
    @Column(unique = true, nullable = false, length = 50)
    @ToString.Include
    private String nombre;
    @ToString.Include
    private String imagenPerfil;
    @Column(unique = true, nullable = false, length = 200)
    @ToString.Include
    private String contrasenia;
    @Column(unique = false, nullable = false, length = 50)
    @ToString.Include
    private Integer puntos;
    @NotNull
    @Email
    @Column(unique = true, nullable = false, length = 50)
    @ToString.Include
    private String email;



    // ---------------- RELACIONES -----------------

    @OneToMany(mappedBy = "cliente")
    @ToString.Exclude
    private List<Entrada> entradas;
    @OneToMany(mappedBy = "cliente")
    @ToString.Exclude
    private List<Compra> compras;
    @OneToMany(mappedBy = "cliente")
    @ToString.Exclude
    private List<CuponCliente> cupones;

    // ------------- CONSTRUCTOR ---------------------

    @Builder
    public Cliente( String nombre, String imagen, String contra, Integer puntos, String email) {
        this.nombre = nombre;
        this.imagenPerfil = imagen;
        this.contrasenia = contra;
        this.puntos = puntos;
        this.email = email;
    }

}
