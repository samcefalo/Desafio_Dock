package me.samcefalo.desafio.controllers;


import me.samcefalo.desafio.entities.Entidade;
import me.samcefalo.desafio.entities.dto.EntidadeDTO;
import me.samcefalo.desafio.resources.utils.ObjectParser;
import me.samcefalo.desafio.resources.utils.Validation;
import me.samcefalo.desafio.services.EntidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 * Controladores - Controla o fluxo da aplicação (Requests)
 */

@RestController
public class EntidadeController {

    // Camada de serviço
    @Autowired
    private EntidadeService entidadeService;
    @Autowired
    private Validation validation;
    @Autowired
    private ObjectParser objectParser;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "text/html")
    public ResponseEntity<Entidade> insert(@RequestBody String string) {
        //formato: 44332211;123;PWWIN;0;F04A2E4088B;4;8.00b3;0;16777216;PWWIN
        Entidade entidade = objectParser.parseFromString(string, Entidade.class, ";");
        validation.validateJson(entidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(entidadeService.insert(entidade));
    }

    @RequestMapping(value = "/{version}/{model}/{logic}", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<Void> update(@RequestBody EntidadeDTO entidadeDTO, @PathVariable String version,
                                       @PathVariable String model,
                                       @PathVariable int logic) {
        validation.validateJson(entidadeDTO);
        Entidade entidade = entidadeService.fromDTO(entidadeDTO);
        entidade.setVersion(version);
        entidade.setModel(model);
        entidade.setLogic(logic);
        entidadeService.update(entidade);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<EntidadeDTO>> findAllPage(@RequestParam(value = "page", defaultValue = "0") int page,
                                                         @RequestParam(value = "linesPerPage", defaultValue = "24") int linesPerPage,
                                                         @RequestParam(value = "orderBy", defaultValue = "logic") String orderBy,
                                                         @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        return ResponseEntity.ok()
                .body(entidadeService.findAllPage(page, linesPerPage, orderBy, direction)
                        .map(entidade -> new EntidadeDTO(entidade)));
    }

    @RequestMapping(value = "/{version}/{name}/{logic}", method = RequestMethod.GET)
    public ResponseEntity<EntidadeDTO> find(@PathVariable String version,
                                            @PathVariable String name,
                                            @PathVariable int logic) {
        Entidade entidade = entidadeService.find(version, name, logic);
        return ResponseEntity.ok().body(new EntidadeDTO(entidade));
    }

}
