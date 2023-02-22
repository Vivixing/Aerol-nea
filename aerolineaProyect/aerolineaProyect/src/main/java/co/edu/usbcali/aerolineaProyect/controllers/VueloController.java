package co.edu.usbcali.aerolineaProyect.controllers;

import co.edu.usbcali.aerolineaProyect.dtos.MensajeDTO;
import co.edu.usbcali.aerolineaProyect.dtos.vueloDTO;
import co.edu.usbcali.aerolineaProyect.services.VueloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vuelo") //Mandar al Servicio desde Browser
public class VueloController {

    /*
    @GetMapping("/verVuelos")
    public List<String> verVuelosString(){
        return Arrays.asList("Hola", "Vuelo", "XD");
    }
    */

    //Implementamos VueloServices
    private VueloService vueloService;

    //VueloController hereda de VueloService
    public VueloController(VueloService vueloService) {

        this.vueloService = vueloService;
    }


    //Método Get de un Vuelo
    @GetMapping("/obtenerVuelo")
    public ResponseEntity<vueloDTO> obtenerVuelo(){
        /*El ResponseEntity es lo que responderá, después de ir al Servicio*/
        return  new ResponseEntity(vueloService.obtenerVuelo(), HttpStatus.OK);
    }

    //Método Get de una lista de Vuelos
    @GetMapping("/obtenerVuelos")
    public ResponseEntity<List<vueloDTO>> obtenerVuelos(){
        return new ResponseEntity(vueloService.obtenerVuelos(),HttpStatus.OK)  ;
    }

    //Método Post
    @PostMapping(path = "/guardarVuelo",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity guardarVuelo(@RequestBody vueloDTO vueloDTO1){
        /*Este método recibe como parámetro un vuelo para devolver un mensaje*/
        try {
            return new ResponseEntity(vueloService.guardarVuelo(vueloDTO1), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }
}
