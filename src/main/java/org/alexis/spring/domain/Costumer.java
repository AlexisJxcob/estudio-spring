package org.alexis.spring.domain;

// clase POJO
public class Costumer {
    // atributos
    private Integer id;
    private String name;
    private String username;
    private String password;

    // Constructor
    public Costumer(Integer id, String name, String username, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
    }

}
