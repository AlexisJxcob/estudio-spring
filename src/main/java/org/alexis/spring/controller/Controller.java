package org.alexis.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// Un controlador en Spring es, de forma muy sencilla, el recepcionista o el mesero de tu aplicación.

// Es el componente encargado de recibir las peticiones que llegan desde internet (por ejemplo, desde una página web, un celular o Postman), procesarlas o pasarlas a quien corresponda, y devolver una respuesta.
@RestController
@RequestMapping("/apisaludos") // todos los endpoints piden esto adelante por si tenemos distintos controladores
public class Controller {

    @GetMapping("/hola") // cuando pongamos en la url /hola llamara al endpoint
    public String holaMundo() {
        return "Hola mundo desde Spring ";
    }

    @GetMapping("/holanombre/{nombre}/{edad}")
    public String holaMundoNombre(@PathVariable String nombre,@PathVariable int edad) {
        return "Hola mundo desde Spring" + nombre + " tu edad es: " + edad;
    }
}
