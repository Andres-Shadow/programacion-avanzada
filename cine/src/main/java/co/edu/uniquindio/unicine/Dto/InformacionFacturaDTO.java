package co.edu.uniquindio.unicine.Dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InformacionFacturaDTO {

    private Float precioTotal;
    private LocalDateTime fecha;
    private Integer precioEntrada;
    private Integer precioConfiteria;

}
