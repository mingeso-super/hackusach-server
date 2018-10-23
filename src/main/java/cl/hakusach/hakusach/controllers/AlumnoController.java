package cl.hakusach.hakusach.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.hakusach.hakusach.models.Alumno;
import cl.hakusach.hakusach.repositories.AlumnoRepository;
import cl.hakusach.hakusach.exceptions.AlumnoNotFound;

@RestController
@RequestMapping("/api/v1/alumnos/")
public class AlumnoController {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @GetMapping("{id}")
    public Alumno getAlumno(@PathVariable long id) throws AlumnoNotFound {

        Optional<Alumno> alumno = alumnoRepository.findById(id);
        
        if (!alumno.isPresent()) {
            throw new AlumnoNotFound(id);
        }

        return alumno.get();
    }

    @PostMapping
    public Alumno createAlumno(@RequestBody Alumno alumno) {

        Alumno alumnoStored = alumnoRepository.save(alumno);

        return alumnoStored;
    }

    @PutMapping("{id}")
    public Alumno updateAlumno(@RequestBody Alumno alumno, @PathVariable long id) throws AlumnoNotFound {

        Optional<Alumno> currentAlumno = alumnoRepository.findById(id);

        if (!currentAlumno.isPresent()) {
            throw new AlumnoNotFound(id);
        }

        alumno.setId(id);

        alumnoRepository.save(alumno);

        return alumno;
    }

    @DeleteMapping("{id}")
    public void deleteAlumno(@PathVariable long id) {
        alumnoRepository.deleteById(id);
    }

    @GetMapping("/all")
    public List<Alumno> getAll() {
        List<Alumno> all = new ArrayList<>();

        alumnoRepository
            .findAll()
            .forEach(alumno -> all.add(alumno));

        return all;
    }

}