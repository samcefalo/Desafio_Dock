package me.samcefalo.desafio.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import me.samcefalo.desafio.services.exceptions.JsonValidationFailedException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Set;

@Service
public class ValidationService {

    @Value("classpath:/schemas/entidade-schema.json")
    private Resource resource;

    public void validadeJson(Object objClass) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V201909);

        try {
            JsonNode json = objectMapper.convertValue(objClass, JsonNode.class);
            JsonSchema schema = schemaFactory.getSchema(resource.getInputStream());
            Set<ValidationMessage> validationResult = schema.validate(json);

            if (!validationResult.isEmpty()) {
                validationResult.forEach(vm -> System.out.println(vm.getMessage()));
                throw new JsonValidationFailedException("Erro de validação.", validationResult);
            }

        } catch (IOException e) {

        }

    }
}
