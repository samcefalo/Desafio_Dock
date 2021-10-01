package me.samcefalo.desafio.resources.exceptions;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.networknt.schema.ValidationMessage;
import me.samcefalo.desafio.services.exceptions.JsonValidationFailedException;
import me.samcefalo.desafio.services.exceptions.ObjectNotFoundException;
import me.samcefalo.desafio.services.exceptions.ObjectOutOfBoundsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
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

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<StandardError> typeNotSupported(HttpMediaTypeNotSupportedException error, HttpServletRequest request) {
        StandardError standardError = new StandardError(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), error.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value()).body(standardError);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<StandardError> typeNotSupported(HttpRequestMethodNotSupportedException error, HttpServletRequest request) {
        StandardError standardError = new StandardError(HttpStatus.METHOD_NOT_ALLOWED.value(), error.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED.value()).body(standardError);
    }

    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<StandardError> typeNotSupported(InvalidFormatException error, HttpServletRequest request) {
        StandardError standardError = new StandardError(HttpStatus.BAD_REQUEST.value(), error.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(standardError);
    }

    @ExceptionHandler(JsonValidationFailedException.class)
    public ResponseEntity<StandardError> jsonValidade(JsonValidationFailedException error, HttpServletRequest request) {
        ValidationError validationError = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Erro de Validação", System.currentTimeMillis());
        for (ValidationMessage validationMessage : error.getValidationResult()) {
            validationError.addError(validationMessage.getPath(), validationMessage.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(validationError);
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<StandardError> numberFormat(NumberFormatException error, HttpServletRequest request) {
        StandardError standardError = new StandardError(HttpStatus.BAD_REQUEST.value(), error.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(standardError);
    }

    @ExceptionHandler(ObjectOutOfBoundsException.class)
    public ResponseEntity<StandardError> ObjectOutOfBounds(ObjectOutOfBoundsException error, HttpServletRequest request) {
        StandardError standardError = new StandardError(HttpStatus.BAD_REQUEST.value(), error.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(standardError);
    }

}
