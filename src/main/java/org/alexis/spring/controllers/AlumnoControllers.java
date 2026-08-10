package org.alexis.spring.controllers;

import org.alexis.spring.domain.Alumno;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlumnoControllers {
    List<Alumno> alumnos = new ArrayList<>(Arrays.asList(
            new Alumno(1, "Fernando", "Jacob", "ferjacobka@jijiju.com"),
            new Alumno(2, "Camila", "Silva", "csilva@gmail.com"),
            new Alumno(3, "Mateo", "González", "mgonzalez@hotmail.com"),
            new Alumno(4, "Lucía", "Rojas", "lrojas@outlook.com"),
            new Alumno(5, "Joaquín", "Pérez", "jperez@yahoo.com"),
            new Alumno(6, "Valentina", "Morales", "vmorales@gmail.com"),
            new Alumno(7, "Diego", "Muñoz", "dmunoz@outlook.com"),
            new Alumno(8, "Sofia", "Contreras", "scontreras@gmail.com"),
            new Alumno(9, "Gabriel", "Soto", "gsoto@hotmail.com"),
            new Alumno(10, "Martina", "Espinoza", "mespinoza@yahoo.com")
    ));
}