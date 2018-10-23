package cl.hakusach.hakusach.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.hakusach.hakusach.models.Enunciado;

@Repository
public interface EnunciadoRepository extends CrudRepository<Enunciado, Long> {

}