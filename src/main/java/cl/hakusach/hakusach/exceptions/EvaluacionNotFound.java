package cl.hakusach.hakusach.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EvaluacionNotFound extends Exception {

    private static final long serialVersionUID = 1L;

    public EvaluacionNotFound(long id) {
        super("Evaluacion " + id + " no encontrada");
    }

}