package org.alexis.spring.controllers;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.alexis.spring.services.ClienteService;
import org.alexis.spring.entity.Cliente;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> Listar() {
        return ResponseEntity.ok(clienteService.Listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> FindById(@PathVariable Long id) {
        return clienteService.FindById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@Valid @RequestBody Cliente cliente) {
        Cliente createdCliente = clienteService.Create(cliente);
        return ResponseEntity.created(URI.create("/api/clientes/" + createdCliente.getId())).body(createdCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@Valid @PathVariable Long id,@Valid @RequestBody Cliente datos) {
        try {
            Cliente updatedCliente = clienteService.Update(id, datos);
            return ResponseEntity.ok(updatedCliente);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        try {
            clienteService.Delete(id);
            return ResponseEntity.noContent().build(); // 204
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build(); // 404
        }
    }


}
