package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Entity
@Getter //ahorra espacio para no poner ni los get ni los set
@Setter
@NoArgsConstructor //constructor vacio
@AllArgsConstructor //constructor con todo
@ToString
public class Cliente extends Persona implements Serializable {


    @Column(length = 150, nullable = false, unique = true)
    @Email
    private String email;
    @ElementCollection
    private Map<String, String> telefono;
    @ManyToOne
    private Ciudad ciudad;
    @OneToMany(mappedBy = "cliente")
    private List<Prestamo> prestamos;

}
