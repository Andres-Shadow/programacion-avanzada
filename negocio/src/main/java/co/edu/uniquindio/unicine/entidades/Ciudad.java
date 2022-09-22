package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter //ahorra espacio para no poner ni los get ni los set
@Setter
@NoArgsConstructor //constructor vacio
@AllArgsConstructor //constructor con todo
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Ciudad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    private String nombre;

    @OneToMany(mappedBy = "ciudad")
    private List<Cliente> clientes;
}
