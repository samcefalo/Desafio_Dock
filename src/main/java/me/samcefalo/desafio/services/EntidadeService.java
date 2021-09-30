package me.samcefalo.desafio.services;

import me.samcefalo.desafio.domain.Entidade;
import me.samcefalo.desafio.repositories.EntidadeRepository;
import me.samcefalo.desafio.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/*
 * Service - Classe com fluxo de negocios
 */

@Service
public class EntidadeService {

    @Autowired
    private EntidadeRepository entidadeRepository;

    //TODO fazer regras de negocios

    public Entidade find(int logic) {
        return entidadeRepository.findByLogic(logic).orElseThrow(
                () -> new ObjectNotFoundException("Objeto não encontrado. Logic: " + logic + ", Tipo: " + Entidade.class.getName()));
    }

}
