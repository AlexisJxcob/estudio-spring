package org.alexis.spring.controllers;

import org.alexis.spring.domain.Costumer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clientes") // unificacion de ruta
public class CostumerRestController {
    private List<Costumer> costumers = new ArrayList<>(Arrays.asList(
            new Costumer(1, "fernando", "alexis", "secreto123"),
            new Costumer(2, "debbie", "amor", "secreto123"),
            new Costumer(3, "abi", "chuela", "secreto123"),
            new Costumer(4, "seporah", "avi", "secreto123")
    ));

    @GetMapping()
    public ResponseEntity<List<Costumer>> getCostumers() {
        return ResponseEntity.ok(costumers);
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getCliente(@PathVariable String username) {
        for (Costumer c : costumers) {
            if (c.getUsername().equals(username)) {
                return ResponseEntity.ok(c);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("CLIENTE NO ENCONTRADO CON EL USERNAME: " + username); // mejoran la mala practica de retornar null, devolviendo un status code 404
    }

    @PostMapping()
    public ResponseEntity<?> postCostumer(@RequestBody Costumer c) {
        costumers.add(c);

        URI Location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{username}")
                .buildAndExpand(c.getUsername())
                .toUri();

        // return ResponseEntity.created(Location).build();
        return ResponseEntity.created(Location).body(c);
    }

    @PutMapping()
    public ResponseEntity<?> putCostumer(@RequestBody Costumer c) {
        System.out.println("ID recibido: " + c.getId()); // Verifica que el ID no llegue en null

        for (Costumer costumer : costumers) {
            if (costumer.getId().equals(c.getId())) {
                System.out.println("¡Cliente encontrado! Actualizando...");
                costumer.setName(c.getName());
                costumer.setUsername(c.getUsername());
                costumer.setPassword(c.getPassword());

                return ResponseEntity.noContent().build(); // Devuelve un status code 204 sin cuerpo de respuesta
                //return costumer;
            }
        }
        System.out.println("No se encontró ningún cliente con ese ID.");
        //return null;
        return ResponseEntity.notFound().build(); // Devuelve un status code 204 sin cuerpo de respuesta
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCostumer(@PathVariable int id) {
        for (Costumer c : costumers) {
            if (c.getId().equals(id)) {
                costumers.remove(c);
                return ResponseEntity.noContent().build(); // Devuelve un status code 204 sin cuerpo de respuesta
            }
        }
        return ResponseEntity.notFound().build(); // Devuelve un status code 404 sin cuerpo de respuesta
    }

    @PatchMapping()
    public ResponseEntity<?> patchCostumer(@RequestBody Costumer costumer) {
        for (Costumer c : costumers) {
            if (c.getId().equals(costumer.getId())) {
                if (costumer.getName() != null) {
                    c.setName(costumer.getName());
                }
                if (costumer.getUsername() != null) {
                    c.setUsername(costumer.getUsername());
                }
                if (costumer.getPassword() != null) {
                    c.setPassword(costumer.getPassword());
                }
                return ResponseEntity.ok("Cliente actualizado parcialmente correctamente: " + c.getId());
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("CLIENTE NO ENCONTRADO CON EL ID: " + costumer.getId());
    }

}

/**
 * =========================================================================================
 * 📚 GUÍA CONCEPTUAL Y TEÓRICA DEL CÓDIGO
 * =========================================================================================
 * <p>
 * Para entender este código imagina un servicio de mensajería o un restaurante:
 * - El "Cliente" (Navegador o App) envía una carta/petición.
 * - Tu "Controlador" (esta clase en Java) lee la carta, busca los datos y devuelve una respuesta.
 * <p>
 * -----------------------------------------------------------------------------------------
 * 🌐 MÉTODOS HTTP (¿Qué acción quiere realizar el cliente?)
 * -----------------------------------------------------------------------------------------
 * <p>
 * 1. GET (Consultar): Se usa para solicitar o leer información sin alterar nada en el sistema.
 * -> Ejemplo: Pedir la lista de clientes o consultar los datos de un cliente específico.
 * <p>
 * 2. POST (Crear): Se utiliza para enviar datos nuevos y guardarlos en el sistema.
 * -> Ejemplo: Registrar un cliente nuevo en la lista.
 * <p>
 * 3. PUT (Reemplazar/Actualizar completo): Se usa para modificar un registro existente reescribiendo
 * todos sus datos con la nueva información enviada.
 * -> Ejemplo: Sobrescribir todos los datos del cliente ID 1 (nombre, usuario y contraseña).
 * <p>
 * 4. PATCH (Modificar parcialmente): Se usa para cambiar únicamente algunos campos específicos sin
 * tocar los demás.
 * -> Ejemplo: Cambiar solo la contraseña de un cliente manteniendo su nombre y usuario intactos.
 * <p>
 * 5. DELETE (Eliminar): Se utiliza para remover o borrar un registro existente del sistema.
 * -> Ejemplo: Eliminar al cliente con ID 2.
 * <p>
 * -----------------------------------------------------------------------------------------
 * 🏷️ ANOTACIONES DE SPRING FRAMEWORK (Instrucciones para el servidor)
 * -----------------------------------------------------------------------------------------
 * <p>
 * --- Configuración General de la Clase ---
 * <p>
 * • @RestController: Le avisa a Spring que esta clase procesará peticiones web y responderá
 * directamente con datos (por lo general en formato JSON), en lugar de responder con una página web HTML.
 * <p>
 * • @RequestMapping("/clientes"): Define la "dirección base" de la web. Todas las funciones de
 * esta clase se activarán únicamente si la ruta empieza con "/clientes".
 * <p>
 * --- Mapeo de Métodos HTTP a Funciones de Java ---
 * <p>
 * • @GetMapping: Conecta las peticiones HTTP GET a un método.
 * - `@GetMapping()` responde a la ruta base `/clientes`.
 * - `@GetMapping("/{username}")` responde a `/clientes/unNombreDeUsuario`.
 * <p>
 * • @PostMapping: Conecta las peticiones HTTP POST a un método para crear registros.
 * <p>
 * • @PutMapping: Conecta las peticiones HTTP PUT para actualizaciones completas de información.
 * <p>
 * • @PatchMapping: Conecta las peticiones HTTP PATCH para cambios o retoques parciales.
 * <p>
 * • @DeleteMapping("/{id}"): Conecta las peticiones HTTP DELETE para borrar registros según el ID.
 * <p>
 * --- Recepción y Lectura de Datos ---
 * <p>
 * • @PathVariable: Extrae un dato directamente desde la dirección URL y se lo entrega al método.
 * - Ejemplo: En la ruta `/clientes/fernando`, la anotación captura `"fernando"` y lo guarda en la
 * variable `String username`.
 * <p>
 * • @RequestBody: Toma los datos enviados dentro del "cuerpo" de la petición (un objeto JSON enviado
 * por el cliente) y los transforma automáticamente en un objeto Java manipulable (en este caso, `Costumer`).
 * <p>
 * =========================================================================================
 **/