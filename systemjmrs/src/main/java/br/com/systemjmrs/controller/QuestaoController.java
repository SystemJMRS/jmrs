package br.com.systemjmrs.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.systemjmrs.entity.Questao;
import br.com.systemjmrs.entity.QuestaoTp;
import br.com.systemjmrs.entity.Usuario;
import br.com.systemjmrs.repository.QuestaoRepository;
import br.com.systemjmrs.repository.QuestaoTPRepository;
import br.com.systemjmrs.repository.UsuarioRepository;

@RequestMapping(value = "/**", produces = {"text/plain", "application/*"})
@Controller
public class QuestaoController {

	@Autowired
	private QuestaoRepository qr;

	@Autowired
	private UsuarioRepository ur;
	
	@Autowired
	private QuestaoTPRepository qtpr;

	@RequestMapping(value = "/cadastrar-questao", method = RequestMethod.GET)
	public ModelAndView cadastrarQuestao() {
		ModelAndView modelAndView = new ModelAndView("/professor/cadastrar-questao");
		modelAndView.addObject("questaoTipos", qtpr.findAll());
		return modelAndView;
	}

	@RequestMapping(value = "/cadastrar-questao", method = RequestMethod.POST)
	public ModelAndView cadastrarQuestao(@RequestParam("questao") String questao,
			@RequestParam("questaoTpId") Long questaoTpForm, @RequestParam("resposta") String resposta,
			@RequestParam("usuario") Long usuarioForm) {

		Usuario usuario = ur.findOne(usuarioForm);
		QuestaoTp questaoTp = qtpr.findOne(questaoTpForm);
		Date dataCriacao = new Date();

		Questao novaQuestao = new Questao(dataCriacao, questao, questaoTp, resposta, usuario);

		qr.save(novaQuestao);

		return cadastrarQuestao();
	}
	
	

	@RequestMapping(value = "/aprovar-reprovar-questao", method = RequestMethod.GET)
	public ModelAndView aprovarReprovarQuestao() {
		ModelAndView modelAndView = new ModelAndView("coordenador/aprovar-reprovar-questao");
		
		modelAndView.addObject("questoes", qr.findAll());
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView aprovarReprovarQuestaoId(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("coordenador/aprovar-reprovar-questao-detalhes");
		
		modelAndView.addObject("questao", qr.findOne((Long)id));
		
		return modelAndView;
	}
}
