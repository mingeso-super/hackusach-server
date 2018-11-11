package cl.hakusach.hakusach.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.hakusach.hakusach.models.Evaluacion;

@Repository
public interface EvaluacionRepository extends CrudRepository<Evaluacion, Long> {
    
    public List<Evaluacion> findByAlumnoId(Long alumnoId);
    public List<Evaluacion> findByAlumnoIdAndEnunciadoId(Long alumnoId, Long enunciadoId);
    
}