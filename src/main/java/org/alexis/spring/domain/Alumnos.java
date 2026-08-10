package org.alexis.spring.domain;

public class Alumnos {
    private Integer id;
    private String nombre;
    private String apellido;
    private String email;

    public Alumnos(Integer id, String nombre, String apellido, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }


}
