package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
@Entity
@Getter //ahorra espacio para no poner ni los get ni los set
@Setter
@NoArgsConstructor //constructor vacio
@AllArgsConstructor //constructor con todo
@ToString
public class Autor extends Persona implements Serializable {


    @ManyToMany(mappedBy = "autores")
    private List<Libro> libros;
}
