package cl.hakusach.hakusach.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.hakusach.hakusach.models.Alumno;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Long> {

}