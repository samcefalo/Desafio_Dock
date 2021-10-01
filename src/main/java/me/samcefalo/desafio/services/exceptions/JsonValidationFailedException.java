package me.samcefalo.desafio.services.exceptions;

import com.networknt.schema.ValidationMessage;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

public class JsonValidationFailedException extends RuntimeException {

    @Getter
    Set<ValidationMessage> validationResult = new HashSet<>();

    public JsonValidationFailedException(String message, Set<ValidationMessage> validationResult) {
        super(message);
        this.validationResult.addAll(validationResult);
    }

    public JsonValidationFailedException(String message, Throwable cause) {
        super(message, cause);
    }

}
