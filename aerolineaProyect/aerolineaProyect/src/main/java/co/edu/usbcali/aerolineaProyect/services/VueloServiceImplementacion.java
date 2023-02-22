package co.edu.usbcali.aerolineaProyect.services;

import co.edu.usbcali.aerolineaProyect.dtos.vueloDTO;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class VueloServiceImplementacion implements VueloService{

    @Override
    public vueloDTO guardarVuelo(vueloDTO vueloDTO1) throws Exception {
        if(vueloDTO1 == null) {
            throw new Exception("El Vuelo viene con datos nulos");
        }
        if(vueloDTO1.getId()== null || vueloDTO1.getId().trim().equals("")) {
            throw new Exception("Id nulo");
        }
        if(vueloDTO1.getOrigen()== null || vueloDTO1.getOrigen().trim().equals("")) {
            throw new Exception("Origen nulo");
        }
        if(vueloDTO1.getDestino()== null || vueloDTO1.getDestino().trim().equals("")) {
            throw new Exception("Destino nulo");
        }
        if(vueloDTO1.getIdAvion()== null || vueloDTO1.getIdAvion().trim().equals("")) {
            throw new Exception("IdAvion nulo");
        }

        //Se llama a Repositorio
        return vueloDTO1;
    }

    @Override
    public vueloDTO obtenerVuelo() {
        return vueloDTO.builder()
                .origen("Cali")
                .destino("España")
                .fechaHoraSalida(new Date(112,5,25))
                .fechaHoraLlegada(new Date(112,6,30))
                .id("1234").idAvion("56789").build();
        //El .biuld() se utiliza en el patrón de diseño builder y se encarga de crear y devolver el objeo tipo vueloDTO
    }

    @Override
    public List<vueloDTO> obtenerVuelos() {
        return Arrays.asList(
                vueloDTO.builder()
                        .origen("Cali")
                        .destino("Buenaventura")
                        .fechaHoraSalida(new Date(110,4,26))
                        .fechaHoraLlegada(new Date(110,7,15))
                        .id("12345").idAvion("54321").build(),
                new vueloDTO("Buenaventura",
                        "Cali",
                        new Date(112,6,4 ),
                        new Date(112, 8,23),
                        "101234",
                        "101234"
                ),
                new vueloDTO("Medellin",
                        "Cali",
                        new Date(108,3,2),
                        new Date(108,8,29),
                        "201234",
                        "201234"
                )
        );

    }
}
