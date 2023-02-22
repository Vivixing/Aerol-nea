package co.edu.usbcali.aerolineaProyect.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

/*Comunicar Si Hay Errores*/
public class MensajeDTO {
    private String mensaje;
}
