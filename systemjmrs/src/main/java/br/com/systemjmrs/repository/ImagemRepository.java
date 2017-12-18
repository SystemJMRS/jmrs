package br.com.systemjmrs.repository;


import org.springframework.data.repository.CrudRepository;

import br.com.systemjmrs.entity.Imagem;
import br.com.systemjmrs.entity.Questao;
import java.util.List;

public interface ImagemRepository extends CrudRepository<Imagem, Long>{

	List<Imagem> findByQuestao(Questao questao);
}
