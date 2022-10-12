package co.edu.uniquindio.unicine.Intermedia;

import co.edu.uniquindio.unicine.Entidades.Entrada;
import co.edu.uniquindio.unicine.Entidades.Sala;
import co.edu.uniquindio.unicine.Entidades.Teatro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TeatroSala implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Teatro teatro;
    @ManyToOne
    private Sala sala;


}
