package me.samcefalo.desafio.resources;


import me.samcefalo.desafio.domain.Entidade;
import me.samcefalo.desafio.domain.dto.EntidadeDTO;
import me.samcefalo.desafio.services.EntidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "text/html")
    public Entidade insert(@RequestBody String s) {
        //TODO lidar com formato: 44332211;123;PWWIN;0;F04A2E4088B;4;8.00b3;0;16777216;PWWIN
        Entidade entidade = new Entidade(44332211, "123", "PWWIN", 0, "F04A2E4088B", 4, "8.00b3", 0, 16777216, "PWWIN");
        return entidadeService.insert(entidade);
    }

    @RequestMapping(value = "/{version}/{model}/{logic}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody EntidadeDTO entidadeDTO, @PathVariable String version,
                                       @PathVariable String model,
                                       @PathVariable int logic) {
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

    /*
     * TODO update Entidade
     * Camada de Validação
     */

}
