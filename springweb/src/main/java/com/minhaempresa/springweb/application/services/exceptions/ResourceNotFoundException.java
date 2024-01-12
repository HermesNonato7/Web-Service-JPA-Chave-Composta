package com.minhaempresa.springweb.application.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id) {
        super("Resource not found for id " + id);
    }
}
