package org.alexis.spring.controllers;

import org.alexis.spring.domain.Costumer;
import org.springframework.web.bind.annotation.*;

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

@GetMapping("/clientes/{username}")
    public Costumer getCliente(@PathVariable String username) {
        for (Costumer c : costumers) {
            if (c.getUsername().equals(username)) {
                return c;
            }
        }
        return null; // mala practica
    }

    @PostMapping("/clientes")
    public Costumer postCostumer(@RequestBody Costumer c) {
        costumers.add(c);
        return c;
    }

    public Costumer putCostumer(Costumer c) {
        for (Costumer costumer : costumers) {
            if (costumer.getId() == c.getId()) {
                c.setName(costumer.getName());
                c.setUsername(costumer.getUsername());
                c.setPassword(costumer.getPassword());

                return costumer;
            }
        }
        return null;
    }

}
