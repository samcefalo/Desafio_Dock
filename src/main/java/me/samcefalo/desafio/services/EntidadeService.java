package me.samcefalo.desafio.services;

import me.samcefalo.desafio.repositories.EntidadeRepository;
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

}
