package org.alexis.spring.services;

import org.alexis.spring.entity.Cliente;
import org.alexis.spring.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;


import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Page<Cliente> Listar(int pagina, int tamaño) {
        if (pagina < 0)
            pagina = 10;
        if (tamaño < 0)
            tamaño = 10;

        Pageable pg = PageRequest.of(pagina, tamaño);
        return clienteRepository.findAll(pg);
    }

    public Optional<Cliente> FindById(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente Create(Cliente cliente) {
        clienteRepository.findByEmail(cliente.getEmail()).ifPresent(c -> {
            ;
            throw new IllegalArgumentException("El cliente con email " + cliente.getEmail() + " ya existe");
        });
        return clienteRepository.save(cliente);
    }

    public Cliente Update(long ID, Cliente datos) {
        Cliente actual = clienteRepository.findById(ID)
                .orElseThrow(() -> new IllegalArgumentException("El cliente con id " + ID + " no existe"));

        actual.setName(datos.getName());
        actual.setEmail(datos.getEmail());
        return clienteRepository.save(actual);
    }

    public void Delete(long id) {
        if (!clienteRepository.existsById(id)) {
            throw new IllegalArgumentException("El cliente con id " + id + " no existe");
        }
        clienteRepository.deleteById(id);
    }
}
