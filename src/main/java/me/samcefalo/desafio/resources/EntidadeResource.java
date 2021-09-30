package me.samcefalo.desafio.resources;


import me.samcefalo.desafio.services.EntidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class EntidadeResource {

    @Autowired
    private EntidadeService entidadeService;
    
    /*
     * TODO Desmembrar a entrada, armazenar em uma entidade e retornar um json
     *
     */

}
