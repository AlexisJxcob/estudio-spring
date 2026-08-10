package org.alexis.spring.controllers;

import org.alexis.spring.domain.Alumno;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoControllers {
    List<Alumno> alumnos = new ArrayList<>(Arrays.asList(
            new Alumno(1, "Fernando", "Jacob", "ferjacobka@jijiju.com", 18),
            new Alumno(2, "Camila", "Silva", "csilva@gmail.com", 21),
            new Alumno(3, "Mateo", "González", "mgonzalez@hotmail.com", 10),
            new Alumno(4, "Lucía", "Rojas", "lrojas@outlook.com", 19),
            new Alumno(5, "Joaquín", "Pérez", "jperez@yahoo.com", 44),
            new Alumno(6, "Valentina", "Morales", "vmorales@gmail.com", 32),
            new Alumno(7, "Diego", "Muñoz", "dmunoz@outlook.com", 22),
            new Alumno(8, "Sofia", "Contreras", "scontreras@gmail.com", 29),
            new Alumno(9, "Gabriel", "Soto", "gsoto@hotmail.com", 39),
            new Alumno(10, "Martina", "Espinoza", "mespinoza@yahoo.com", 77)
    ));

    @GetMapping
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

@GetMapping("/{id}")
    public Alumno getAlumno(@PathVariable int id) {
        for (Alumno a : alumnos) {
            if (a.getId().equals(id)) {
                return a;
            }
        }
        return null;
    }

    @PostMapping
    public  Alumno createAlumno(@RequestBody Alumno alumno) {
        alumnos.add(alumno);
        return alumno;
    }
}