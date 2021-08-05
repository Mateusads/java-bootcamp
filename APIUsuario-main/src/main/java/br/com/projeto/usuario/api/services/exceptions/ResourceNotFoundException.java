package br.com.projeto.usuario.api.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;


    public ResourceNotFoundException(Object email) {
        super("Email =  " + email + " is not registered");
    }

}
