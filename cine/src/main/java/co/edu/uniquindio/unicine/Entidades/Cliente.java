package co.edu.uniquindio.unicine.Entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
}
