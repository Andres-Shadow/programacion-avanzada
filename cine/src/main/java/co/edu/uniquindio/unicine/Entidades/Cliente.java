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
    private List<CuponCliente> cupones;
}
