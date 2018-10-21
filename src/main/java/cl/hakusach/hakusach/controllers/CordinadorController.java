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

import cl.hakusach.hakusach.models.Cordinador;
import cl.hakusach.hakusach.repositories.CordinadorRepository;
import cl.hakusach.hakusach.exceptions.CordinadorNotFound;

@RestController
@RequestMapping("/api/v1/cordinadores/")
public class CordinadorController {

    @Autowired
    private CordinadorRepository cordinadorRepository;

    @GetMapping("{id}")
    public Cordinador getCordinador(@PathVariable long id) throws CordinadorNotFound {

        Optional<Cordinador> cordinador = cordinadorRepository.findById(id);
        
        if (!cordinador.isPresent()) {
            throw new CordinadorNotFound(id);
        }

        return cordinador.get();
    }

    @PostMapping
    public Cordinador createCordinador(@RequestBody Cordinador cordinador) {

        Cordinador cordinadorStored = cordinadorRepository.save(cordinador);

        return cordinadorStored;
    }

    @PutMapping("{id}")
    public Cordinador updateCordinador(@RequestBody Cordinador cordinador, @PathVariable long id) throws CordinadorNotFound {

        Optional<Cordinador> currentCordinador = cordinadorRepository.findById(id);

        if (!currentCordinador.isPresent()) {
            throw new CordinadorNotFound(id);
        }

        cordinador.setId(id);

        cordinadorRepository.save(cordinador);

        return cordinador;
    }

    @DeleteMapping("{id}")
    public void deleteCordinador(@PathVariable long id) {
        cordinadorRepository.deleteById(id);
    }

    @GetMapping("/all")
    public List<Cordinador> getAll() {
        List<Cordinador> all = new ArrayList<>();

        cordinadorRepository
            .findAll()
            .forEach(cordinador -> all.add(cordinador));

        return all;
    }

}