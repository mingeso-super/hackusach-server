package cl.hakusach.hakusach.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.hakusach.hakusach.models.Cordinador;

@Repository
public interface CordinadorRepository extends CrudRepository<Cordinador, Long> {

}