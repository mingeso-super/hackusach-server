package cl.hakusach.hakusach.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.hakusach.hakusach.models.Enunciado;
import cl.hakusach.hakusach.repositories.EnunciadoRepository;
import cl.hakusach.hakusach.exceptions.EnunciadoNotFound;

@RestController
@RequestMapping("/api/v1/enunciados/")
public class EnunciadoController {

    @Autowired
    private EnunciadoRepository enunciadoRepository;

    @GetMapping("{id}")
    public Enunciado getEnunciado(@PathVariable long id) throws EnunciadoNotFound {

        Optional<Enunciado> enunciado = enunciadoRepository.findById(id);
        
        if (!enunciado.isPresent()) {
            throw new EnunciadoNotFound(id);
        }

        return enunciado.get();
    }

    @PostMapping
    public Enunciado createEnunciado(@RequestBody Enunciado enunciado) {

        Enunciado enunciadoStored = enunciadoRepository.save(enunciado);

        return enunciadoStored;
    }

    @CrossOrigin
    @PutMapping("{id}")
    public Enunciado updateEnunciado(@RequestBody Enunciado enunciado, @PathVariable long id) throws EnunciadoNotFound {

        Optional<Enunciado> currentEnunciado = enunciadoRepository.findById(id);

        if (!currentEnunciado.isPresent()) {
            throw new EnunciadoNotFound(id);
        }

        enunciado.setId(id);

        enunciadoRepository.save(enunciado);

        return enunciado;
    }

    @CrossOrigin
    @DeleteMapping("{id}")
    public void deleteEnunciado(@PathVariable long id) {
        enunciadoRepository.deleteById(id);
    }

    @GetMapping("/all")
    public List<Enunciado> getAll() {
        List<Enunciado> all = new ArrayList<>();

        enunciadoRepository
            .findAll()
            .forEach(enunciado -> all.add(enunciado));

        return all;
    }

}