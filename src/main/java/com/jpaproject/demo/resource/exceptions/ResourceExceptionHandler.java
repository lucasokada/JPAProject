package com.jpaproject.demo.resource.exceptions;

import com.jpaproject.demo.services.exceptions.DatabaseException;
import com.jpaproject.demo.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandartError> resouceNotFound(ResourceNotFoundException exception, HttpServletRequest request) {
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandartError standartError = new StandartError(Instant.now(), status.value(), error, exception.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(standartError);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandartError> database(DatabaseException exception, HttpServletRequest request) {
        String error = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandartError standartError = new StandartError(Instant.now(), status.value(), error, exception.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(standartError);
    }
}
