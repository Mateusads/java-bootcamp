package br.com.projeto.usuario.api.services.exceptions;

public class ConstraintViolationException extends RuntimeException {

    private static final long serialVersionUID = 1L;


    public ConstraintViolationException(Object email) {
        super("Invalid resources " + email);
    }

}
