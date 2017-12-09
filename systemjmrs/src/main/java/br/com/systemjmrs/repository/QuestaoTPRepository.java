package br.com.systemjmrs.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.systemjmrs.entity.QuestaoTp;

public interface QuestaoTPRepository extends CrudRepository<QuestaoTp, Long>{

	static List<QuestaoTp> lista(){
		
		
		
		return null;
		
	}
	
}
