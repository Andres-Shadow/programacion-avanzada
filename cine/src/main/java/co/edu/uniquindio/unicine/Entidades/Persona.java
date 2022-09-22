package co.edu.uniquindio.unicine.Entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Persona implements Serializable {
    @Id
    private Integer id;

    private String nombre;
}
