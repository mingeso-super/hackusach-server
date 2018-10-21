package cl.hakusach.hakusach.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.hakusach.hakusach.models.Profesor;

@Repository
public interface ProfesorRepository extends CrudRepository<Profesor, Long> {

}