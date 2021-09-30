package me.samcefalo.desafio.resources;


import me.samcefalo.desafio.domain.Entidade;
import me.samcefalo.desafio.services.EntidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 * Controladores - Controla o fluxo da aplicação (Requests)
 */

@RestController
public class EntidadeResource {

    // Camada de serviço
    @Autowired
    private EntidadeService entidadeService;

    /*
     * TODO Desmembrar a entrada, armazenar em uma entidade e retornar um json
     */
    @RequestMapping(method = RequestMethod.POST)
    public Entidade insert(@RequestBody String s) {
        //TODO lidar com formato: 44332211;123;PWWIN;0;F04A2E4088B;4;8.00b3;0;16777216;PWWIN
        return null;
    }

    @RequestMapping(value = "/{version}/{name}/{logic}", method = RequestMethod.GET)
    public ResponseEntity<Entidade> find(@PathVariable int id) {
        //TODO Procurar uma entidade pela versão/nome/logic
        return ResponseEntity.ok().build();
    }

}
