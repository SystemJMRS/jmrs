package br.com.systemjmrs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.systemjmrs.entity.Questao;

@Repository
public interface QuestaoRepository extends CrudRepository<Questao, String> {

}
