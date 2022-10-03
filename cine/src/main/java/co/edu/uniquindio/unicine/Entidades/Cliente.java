package co.edu.uniquindio.unicine.Entidades;

import co.edu.uniquindio.unicine.Intermedia.CuponCliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;

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
    private String telefono;
    private String imagenPerfil;
    private String contrasenia;
    private Integer puntos;
    @Email
    private String email;
    @OneToMany(mappedBy = "cliente")
    private List<Entrada> entradas;
    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;
    @OneToMany(mappedBy = "cliente")
    private List<CuponCliente> cupones;


    public Cliente( String nombre, String telefono, String imagen, String contra, Integer puntos, String email){

        this.nombre = nombre;
        this.telefono= telefono;
        this.imagenPerfil = imagen;
        this.contrasenia = contra;
        this.puntos = puntos;
        this.email = email;
    }
}
