package org.alexis.spring.controllers;

import org.alexis.spring.domain.Costumer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CostumerRestController {
    private List<Costumer> costumers = new ArrayList<>(Arrays.asList(
            new Costumer(1, "fernando", "alexis", "secreto123"),
            new Costumer(2, "debbie", "amor", "secreto123"),
            new Costumer(3, "abi", "chuela", "secreto123"),
            new Costumer(4, "seporah", "avi", "secreto123")
    ));

    @GetMapping("/clientes")
    public List<Costumer> getCostumers() {
        return costumers;
    }


    public Costumer getCliente(String username) {
        for (Costumer c : costumers) {
            if (c.getUsername().equals(username)) {
                return c;
            }
        }
        return null; // mala practica
    }
}
