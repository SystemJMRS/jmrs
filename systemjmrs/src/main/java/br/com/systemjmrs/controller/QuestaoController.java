package br.com.systemjmrs.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.systemjmrs.entity.Questao;
import br.com.systemjmrs.entity.Usuario;
import br.com.systemjmrs.repository.QuestaoRepository;

@Controller
public class QuestaoController {

	@Autowired
	private QuestaoRepository qr;

	@RequestMapping(value = "/cadastrar-questao", method = RequestMethod.GET)
	public String cadastrarQuestao() {
		return "professor/cadastrar-questao";
	}

	//questaoId
	//dataCriacao
	//questao
	//questaoTpId
	//resposta
	//usuario
	
	@RequestMapping(value = "/cadastrar-questao", method = RequestMethod.POST)
	public String cadastrarQuestao(@RequestParam("questaoId") int questaoId, @RequestParam("dataCriacao") String dataCriacao, @RequestParam("questao") String questao, @RequestParam("questaoTpId") int questaoTpId, @RequestParam("resposta") String resposta, @RequestParam("usuario") int usuario) {

		Questao novaQuestao = new Questao();		
		
		qr.save(novaQuestao);
		
		return "professor/cadastrar-questao";
	}
	
	@RequestMapping(value = "/aprovar-reprovar-questao", method = RequestMethod.GET)
	public String aprovarReprovarQuestao() {
		return "coordenador/aprovar-reprovar-questao";
	}
}
