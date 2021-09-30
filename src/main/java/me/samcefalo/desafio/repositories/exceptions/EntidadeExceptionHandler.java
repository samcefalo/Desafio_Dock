package me.samcefalo.desafio.repositories.exceptions;

import me.samcefalo.desafio.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/*
 * @ControllerAdvice - lida com Exceptions da aplicação
 * Interceptor de exceções lançadas por métodos
 */

@ControllerAdvice
public class EntidadeExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException error, HttpServletRequest request) {
        StandardError standardError = new StandardError(HttpStatus.NOT_FOUND.value(), error.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(standardError);
    }

}
