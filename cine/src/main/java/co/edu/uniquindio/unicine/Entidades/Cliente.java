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
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String imagenPerfil;
    private String contrasenia;
    private Integer puntos;
    @NotNull
    @Email
    @Column(unique = true)
    private String email;



    // ---------------- RELACIONES -----------------

    @OneToMany(mappedBy = "cliente")
    private List<Entrada> entradas;
    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;
    @OneToMany(mappedBy = "cliente")
    private List<CuponCliente> cupones;
    @ElementCollection
    private Map<String, String> telefono;

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
