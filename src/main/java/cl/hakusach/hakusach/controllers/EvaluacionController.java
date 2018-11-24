package cl.hakusach.hakusach.controllers;

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

import cl.hakusach.hakusach.exceptions.AlumnoNotFound;
import cl.hakusach.hakusach.exceptions.EnunciadoNotFound;
import cl.hakusach.hakusach.exceptions.EvaluacionNotFound;
import cl.hakusach.hakusach.models.Alumno;
import cl.hakusach.hakusach.models.Enunciado;
import cl.hakusach.hakusach.models.Evaluacion;
import cl.hakusach.hakusach.repositories.AlumnoRepository;
import cl.hakusach.hakusach.repositories.EnunciadoRepository;
import cl.hakusach.hakusach.repositories.EvaluacionRepository;
import cl.hakusach.hakusach.services.GlotService;

@RestController
@RequestMapping("/api/v1/alumno")
public class EvaluacionController {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private EvaluacionRepository evaluacionRepository;

    @Autowired
    private EnunciadoRepository enunciadoRepository;

    @Autowired
    private GlotService service;

    private void ValidatePath(long idAlumno,  long idEnunciado) throws AlumnoNotFound, EnunciadoNotFound {
        Optional<Alumno> alumno =  alumnoRepository.findById(idAlumno);
        
        if(!alumno.isPresent()) {
            throw new AlumnoNotFound(idAlumno);
        }

        Optional<Enunciado> enunciado = enunciadoRepository.findById(idEnunciado);

        if(!enunciado.isPresent()) {
            throw new EnunciadoNotFound(idEnunciado);
        }


    }


    // Obtiene todas las evaluaciones de un alumno, para un enunciado
    @GetMapping("/{idAlumno}/enunciado/{idEnunciado}/evaluacion/all")
    public List<Evaluacion> getEvaluaciones(@PathVariable long idAlumno, @PathVariable long idEnunciado) throws Exception {
        ValidatePath(idAlumno, idEnunciado);

        List<Evaluacion> evaluaciones = evaluacionRepository.findByAlumnoIdAndEnunciadoId(idAlumno, idEnunciado);

        return evaluaciones;
    }

    // Crea una evaluacion para un alumno
    @PostMapping("/{idAlumno}/enunciado/{idEnunciado}/evaluacion/")
    public Evaluacion createEvaluacion(@PathVariable long idAlumno, @PathVariable long idEnunciado, @RequestBody Evaluacion evaluacion) throws Exception {
        ValidatePath(idAlumno, idEnunciado);

        Evaluacion nuevaEvaluacion = Evaluacion.builder()
            .alumnoId(idAlumno)
            .enunciadoId(idEnunciado)
            .code(evaluacion.getCode())
            .lang(evaluacion.getLang())
            .score(0)
            .build();
        
        nuevaEvaluacion =evaluacionRepository.save(nuevaEvaluacion);

        return nuevaEvaluacion;
    }

    @PutMapping("/{idAlumno}/enunciado/{idEnunciado}/evaluacion/{idEvaluacion}")
    public Evaluacion updateEvaluacion(@PathVariable long idAlumno, @PathVariable long idEnunciado, @PathVariable long idEvaluacion, @RequestBody Evaluacion evaluacion) throws Exception {
        ValidatePath(idAlumno, idEnunciado);


        Optional<Evaluacion> result = evaluacionRepository.findById(idEvaluacion);

        if(!result.isPresent()) {
            throw new EvaluacionNotFound(idEvaluacion);
        }

        Evaluacion updateEvaluacion = result.get().toBuilder()
            .code(evaluacion.getCode())
            .build();

        updateEvaluacion = evaluacionRepository.save(updateEvaluacion);


        return updateEvaluacion;
    }

    @DeleteMapping("/{idAlumno}/enunciado/{idEnunciado}/evaluacion/{idEvaluacion}")
    public void delete(@PathVariable long idAlumno, @PathVariable long idEnunciado, @PathVariable long idEvaluacion) throws Exception {
        ValidatePath(idAlumno, idEnunciado);

        Optional<Evaluacion> result = evaluacionRepository.findById(idEvaluacion);

        if(!result.isPresent()) {
            throw new EvaluacionNotFound(idEvaluacion);
        }

        evaluacionRepository.delete(result.get());        
    }


    @PostMapping("/{idAlumno}/enunciado/{idEnunciado}/evaluacion/{idEvaluacion}/evaluate")
    public Evaluacion evaluate(@PathVariable long idAlumno, @PathVariable long idEnunciado, @PathVariable long idEvaluacion, @RequestBody Evaluacion evaluacion) throws Exception {
        ValidatePath(idAlumno, idEnunciado);


        Optional<Evaluacion> result = evaluacionRepository.findById(idEvaluacion);

        if(!result.isPresent()) {
            throw new EvaluacionNotFound(idEvaluacion);
        }

        Evaluacion updateEvaluacion = result.get().toBuilder()
            .code(evaluacion.getCode())
            .build();

        updateEvaluacion = evaluacionRepository.save(updateEvaluacion);
        // Evaluacion
        


        return updateEvaluacion;
    }




}