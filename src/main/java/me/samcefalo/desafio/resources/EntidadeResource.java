package me.samcefalo.desafio.resources;


import me.samcefalo.desafio.services.EntidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Controladores - Controla o fluxo da aplicação (Requests)
 */

@RestController
@RequestMapping
public class EntidadeResource {

    // Camada de serviço
    @Autowired
    private EntidadeService entidadeService;

    /*
     * TODO Desmembrar a entrada, armazenar em uma entidade e retornar um json
     *
     */

}
