package me.samcefalo.desafio.repositories;

import me.samcefalo.desafio.entities.Entidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/*
 * Repositorio - Isolam o acesso dos dados
 */

@Repository
public interface EntidadeRepository extends JpaRepository<Entidade, Integer> {

    @Transactional(readOnly = true)
    Optional<Entidade> findByVersionAndModelAndLogic(String version, String model, int logic);

}
