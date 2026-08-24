package org.alexis.spring.controllers;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.alexis.spring.services.ClienteService;
import org.alexis.spring.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@PreAuthorize("hasAuthority('APPROLE_Admin')")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<Page<Cliente>> Listar(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "2") int tamaño) {
        Page<Cliente> resultado = clienteService.Listar(pagina, tamaño);
        return ResponseEntity.ok(resultado);
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
    public ResponseEntity<Cliente> update(@Valid @PathVariable Long id, @Valid @RequestBody Cliente datos) {
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
