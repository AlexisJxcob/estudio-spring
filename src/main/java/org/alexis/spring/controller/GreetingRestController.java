package org.alexis.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingRestController {

    @GetMapping({"/saludo/{name}", "/hola/{name}"}) // pametros dinamicos {}
    public String greeting(@PathVariable String name) { // este parametro va a venir de la url
        return "Hola " + name;
    }
}
