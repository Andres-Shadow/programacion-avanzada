package co.edu.uniquindio.unicine.Entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Funcion implements Serializable {
    @Id
    private Integer id;
    @ManyToOne
    private Pelicula pelicula;
    @OneToMany(mappedBy = "funcion")
    private List<Entrada> entradas;

}
