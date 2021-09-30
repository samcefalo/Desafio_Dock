package me.samcefalo.desafio.repositories;

import me.samcefalo.desafio.domain.Entidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * Repositorio - Isolam o acesso dos dados
 */

@Repository
public interface EntidadeRepository extends JpaRepository<Entidade, Integer> {

}
