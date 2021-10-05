package me.samcefalo.desafio.resources.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.samcefalo.desafio.entities.Entidade;
import me.samcefalo.desafio.services.exceptions.JsonValidationFailedException;
import me.samcefalo.desafio.services.exceptions.ObjectOutOfBoundsException;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ObjectParser {

    public Entidade parseFromString(String string, Class<?> tClass, String separator) {
        try {
            return deserialize(toJson(string, tClass, separator));
        } catch (JsonProcessingException e) {
            throw new JsonValidationFailedException("Erro de validação.", e);
        }
    }

    private Entidade deserialize(String string) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(string, Entidade.class);
    }

    private String toJson(String string, Class<?> tClass, String separator) {
        String[] vetor = string.split(separator);
        Map<String, String> jsonElements = new HashMap<>();
        try {
            for (int i = 0; i < tClass.getDeclaredFields().length; i++) {
                Field field = tClass.getDeclaredFields()[i];
                field.setAccessible(true);
                jsonElements.put(field.getName(), vetor[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ObjectOutOfBoundsException("Erro de inserção: Variáveis insuficientes ou vazia.");
        }
        return toJsonString(jsonElements);
    }

    private String toJsonString(Map<String, String> jsonMap) {
        String elementsString = jsonMap.entrySet()
                .stream()
                .map(entry -> "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\"")
                .collect(Collectors.joining(","));
        return "{" + elementsString + "}";
    }

}
