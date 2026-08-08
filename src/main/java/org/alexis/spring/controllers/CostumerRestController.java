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

    @PutMapping("/clientes")
    public Costumer putCostumer(@RequestBody Costumer c) {
        System.out.println("ID recibido: " + c.getId()); // Verifica que el ID no llegue en null

        for (Costumer costumer : costumers) {
            if (costumer.getId().equals(c.getId())) {
                System.out.println("¡Cliente encontrado! Actualizando...");
                costumer.setName(c.getName());
                costumer.setUsername(c.getUsername());
                costumer.setPassword(c.getPassword());
                return costumer;
            }
        }
        System.out.println("No se encontró ningún cliente con ese ID.");
        return null;
    }

    public Costumer deleteCostumer(int id) {
        for (Costumer c : costumers) {
            if (c.getId().equals(id)) {
                costumers.remove(c);
                return c;
            }
        }
        return null;
    }
}


/**
 * 1. **@RestController**: Esta anotación indica que la clase es un controlador RESTful. Un controlador RESTful es una clase que contiene
 * métodos HTTP (GET, POST, PUT, DELETE) para manejar solicitudes y respuestas de un servicio web.
 *
 * 2. **GetMapping**: Esta anotación indica que el método es una solicitud GET. El método `getCostumers()` en tu código es un ejemplo de
 * cómo usar esta anotación.
 *
 * 3. **PathVariable**: Esta anotación se utiliza para indicar que un parámetro de la URL debe ser pasado como argumento al método. En tu
 * código, el método `getCliente(@PathVariable String username)` recibe un parámetro llamado `username` y lo usa para buscar un cliente en
 * la lista.
 *
 * 4. **PostMapping**: Esta anotación indica que el método es una solicitud POST. El método `postCostumer(@RequestBody Costumer c)` recibe
 * un objeto JSON como cuerpo de la solicitud y lo utiliza para crear un nuevo cliente en la lista.
 *
 * 5. **PutMapping**: Esta anotación se utiliza para indicar que el método es una solicitud PUT. El método `putCostumer(@PathVariable String
 * username, @RequestBody Costumer c)` recibe un parámetro llamado `username` y otro objeto JSON como cuerpo de la solicitud y lo usa para
 * actualizar un cliente en la lista.
 *
 * 6. **@RequestBody**: Esta anotación se utiliza para indicar que el cuerpo de la solicitud debe ser procesado como un objeto JSON. En tu
 * código, el método `postCostumer(@RequestBody Costumer c)` recibe un objeto JSON como cuerpo de la solicitud y lo usa para crear un
 * nuevo cliente en la lista.
 **/