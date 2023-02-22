package co.edu.usbcali.aerolineaProyect.services;

import co.edu.usbcali.aerolineaProyect.dtos.vueloDTO;

import java.util.List;

public interface VueloService {

    vueloDTO guardarVuelo(vueloDTO vueloDTO1)throws Exception;
    vueloDTO obtenerVuelo();
    List<vueloDTO> obtenerVuelos();
}
