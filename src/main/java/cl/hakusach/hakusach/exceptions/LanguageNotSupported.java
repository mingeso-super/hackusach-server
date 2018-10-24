package cl.hakusach.hakusach.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
public class LanguageNotSupported extends Exception {

    private static final long serialVersionUID = 1L;

    public LanguageNotSupported() {
        super("Language Not supported");
    }

}