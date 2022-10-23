package co.edu.uniquindio.unicine.Dto;

import co.edu.uniquindio.unicine.Entidades.Horario;
import co.edu.uniquindio.unicine.Entidades.Sala;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HorarioSalaDTIO {
    private List<Horario> horarios;
    private Sala sala;
}
