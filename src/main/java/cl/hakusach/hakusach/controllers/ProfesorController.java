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

import cl.hakusach.hakusach.models.Profesor;
import cl.hakusach.hakusach.repositories.ProfesorRepository;
import cl.hakusach.hakusach.exceptions.ProfesorNotFound;

@RestController
@RequestMapping("/api/v1/profesores/")
public class ProfesorController {

    @Autowired
    private ProfesorRepository profesorRepository;

    @GetMapping("{id}")
    public Profesor getProfesor(@PathVariable long id) throws ProfesorNotFound {

        Optional<Profesor> Profesor = profesorRepository.findById(id);
        
        if (!Profesor.isPresent()) {
            throw new ProfesorNotFound(id);
        }

        return Profesor.get();
    }

    @PostMapping
    public Profesor createProfesor(@RequestBody Profesor Profesor) {

        Profesor ProfesorStored = profesorRepository.save(Profesor);

        return ProfesorStored;
    }

    @PutMapping("{id}")
    public Profesor updateProfesor(@RequestBody Profesor Profesor, @PathVariable long id) throws ProfesorNotFound {

        Optional<Profesor> currentProfesor = profesorRepository.findById(id);

        if (!currentProfesor.isPresent()) {
            throw new ProfesorNotFound(id);
        }

        Profesor.setId(id);

        profesorRepository.save(Profesor);

        return Profesor;
    }

    @DeleteMapping("{id}")
    public void deleteProfesor(@PathVariable long id) {
        profesorRepository.deleteById(id);
    }

    @GetMapping("/all")
    public List<Profesor> getAll() {
        List<Profesor> all = new ArrayList<>();

        profesorRepository
            .findAll()
            .forEach(Profesor -> all.add(Profesor));

        return all;
    }

}