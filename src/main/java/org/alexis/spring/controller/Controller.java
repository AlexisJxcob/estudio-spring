package org.alexis.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/hola") // cuando pongamos en la url /hola llamara al endpoint
    public String holaMundo() {
        return "Hola mundo desde Spring";
    }
}
