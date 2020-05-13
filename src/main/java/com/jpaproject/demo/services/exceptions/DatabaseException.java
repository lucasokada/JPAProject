package com.jpaproject.demo.services.exceptions;

public class DatabaseException extends RuntimeException {
    public DatabaseException(String mensagem) {
        super(mensagem);
    }
}
