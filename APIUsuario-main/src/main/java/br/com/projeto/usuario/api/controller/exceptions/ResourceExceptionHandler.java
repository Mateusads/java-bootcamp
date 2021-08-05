package br.com.projeto.usuario.api.controller.exceptions;

import br.com.projeto.usuario.api.services.exceptions.DataBaseException;
import br.com.projeto.usuario.api.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e,
                                                         HttpServletRequest request) {
        String error = "Resource not Found ";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }


    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<StandardError> invalidResource(ConstraintViolationException e,
                                                         HttpServletRequest request) {
        String error = "Invalid resource ";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, "Email is not well formatted ", request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandardError> invalidResource(DataBaseException e,
                                                         HttpServletRequest request) {
        String error = "email already exists in the database ";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}


