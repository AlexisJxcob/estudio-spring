package org.alexis.spring.controllers;

import org.alexis.spring.domain.Alumno;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoControllers {
    private List<Alumno> alumnos = new ArrayList<>(Arrays.asList(
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

    // Mostrar todos los alumnos
    @GetMapping
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    // Mostrar un alumno por ID
    @GetMapping("/{id}")
    public Alumno getAlumno(@PathVariable Integer id) {
        for (Alumno a : alumnos) {
            if (a.getId().equals(id)) {
                return a;
            }
        }
        return null;
    }

    // Crear un alumno
    @PostMapping
    public Alumno createAlumno(@RequestBody Alumno alumno) {
        alumnos.add(alumno);
        return alumno;
    }

    // Actualización completa (PUT)
    @PutMapping
    public Alumno updateAlumno(@RequestBody Alumno alumno) {
        for (Alumno a : alumnos) {
            if (a.getId().equals(alumno.getId())) {
                a.setNombre(alumno.getNombre());
                a.setApellido(alumno.getApellido());
                a.setEmail(alumno.getEmail());
                a.setEdad(alumno.getEdad());
                return a;
            }
        }
        return null;
    }

    // Eliminar un alumno (DELETE)
    @DeleteMapping("/{id}")
    public Alumno deleteAlumno(@PathVariable Integer id) {
        for (Alumno a : alumnos) {
            if (a.getId().equals(id)) {
                alumnos.remove(a);
                return a; // Retornamos el objeto eliminado
            }
        }
        return null;
    }

    // Actualización parcial (PATCH)
    @PatchMapping
    public Alumno patchAlumno(@RequestBody Alumno alumno) {
        for (Alumno a : alumnos) {
            if (a.getId().equals(alumno.getId())) {
                if (alumno.getNombre() != null) {
                    a.setNombre(alumno.getNombre());
                }
                if (alumno.getApellido() != null) {
                    a.setApellido(alumno.getApellido());
                }
                if (alumno.getEmail() != null) {
                    a.setEmail(alumno.getEmail());
                }
                if (alumno.getEdad() != null) {
                    a.setEdad(alumno.getEdad());
                }
                return a; // Retornamos el alumno actualizado
            }
        }
        return null;
    }
}