package me.samcefalo.desafio.services;

import me.samcefalo.desafio.domain.Entidade;
import me.samcefalo.desafio.domain.dto.EntidadeDTO;
import me.samcefalo.desafio.repositories.EntidadeRepository;
import me.samcefalo.desafio.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/*
 * Service - Classe com fluxo de negocios
 */

@Service
public class EntidadeService {

    @Autowired
    private EntidadeRepository entidadeRepository;

    //TODO fazer regras de negocios

    public Page<Entidade> findAllPage(int page, int linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage,
                Sort.Direction.valueOf(direction.toUpperCase()), orderBy);
        return entidadeRepository.findAll(pageRequest);
    }

    public List<Entidade> findAll() {
        return entidadeRepository.findAll();
    }

    public Entidade find(String version, String model, int logic) {
        return entidadeRepository.findByVersionAndModelAndLogic(version, model, logic).orElseThrow(
                () -> new ObjectNotFoundException("Objeto não encontrado. version: " + version + ", " +
                        "model: " + model + ", " +
                        "logic: " + logic + ", " +
                        "Tipo: " + Entidade.class.getName()));
    }

    @Transactional
    public Entidade insert(Entidade entidade) {
        entidade = entidadeRepository.save(entidade);
        return entidade;
    }

    public Entidade update(Entidade entidade) {
        find(entidade.getVersion(), entidade.getModel(), entidade.getLogic());
        return insert(entidade);
    }

    public Entidade fromDTO(EntidadeDTO entidadeDTO) {
        return new Entidade(entidadeDTO.getLogic(),
                entidadeDTO.getSerial(),
                entidadeDTO.getModel(),
                entidadeDTO.getSam(),
                entidadeDTO.getPtid(),
                entidadeDTO.getPlat(),
                entidadeDTO.getVersion(),
                entidadeDTO.getMxr(),
                entidadeDTO.getMxf(),
                entidadeDTO.getVerfm());
    }

}
