package me.samcefalo.desafio.services;

import me.samcefalo.desafio.domain.Entidade;
import me.samcefalo.desafio.repositories.EntidadeRepository;
import me.samcefalo.desafio.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


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

    public Entidade find(int version, String name, int logic) {
        return entidadeRepository.findByVersionAndModelAndLogic(version, name, logic).orElseThrow(
                () -> new ObjectNotFoundException("Objeto não encontrado. Logic: " + logic + ", Tipo: " + Entidade.class.getName()));
    }

}
