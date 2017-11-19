package br.com.systemjmrs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.systemjmrs.entity.Questao;
import br.com.systemjmrs.repository.QuestaoRepository;

@Controller
public class QuestaoController {

	@Autowired
	private QuestaoRepository qr;

	@RequestMapping(value = "/cadastrar-questao", method = RequestMethod.GET)
	public String cadastrarQuestao() {
		return "professor/cadastrar-questao";
	}

	@RequestMapping(value = "/cadastrar-questao", method = RequestMethod.POST)
	public String cadastrarQuestao(Questao questao) {

		qr.save(questao);
		
		return "redirect:/professor/cadastrar-questao";
	}
}
