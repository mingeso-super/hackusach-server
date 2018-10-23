package cl.hakusach.hakusach.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EnunciadoNotFound extends Exception {

    private static final long serialVersionUID = 1L;

    public EnunciadoNotFound(long id) {
        super("Enunciado " + id + " no encontrado");
    }

}