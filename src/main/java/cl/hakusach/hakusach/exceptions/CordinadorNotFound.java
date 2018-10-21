package cl.hakusach.hakusach.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CordinadorNotFound extends Exception {

    private static final long serialVersionUID = 1L;

    public CordinadorNotFound(long id) {
        super("Cordinador id:" + id + " no encontrado");
    }

}