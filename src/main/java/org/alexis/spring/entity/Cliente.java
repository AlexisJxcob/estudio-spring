package org.alexis.spring.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "clientes") // todo lo que hagamos en la clase se mapeara a la tabla clientes en la base de datos
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank()
    @Column(nullable = false, length = 50)
    private String name;

    @Email
    @NotBlank()
    @Column(nullable = false, length = 100)
    private String email;

    public Cliente() {
    }

    public Cliente(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
