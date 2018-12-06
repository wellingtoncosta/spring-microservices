package br.com.wellingtoncosta.clientservice.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Wellington Costa on 05/12/18
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ClientAlreadyExistsException extends RuntimeException {

    public ClientAlreadyExistsException(String email) {
        super("A client already exists in database with the same email: " + email + ".");
    }

}
