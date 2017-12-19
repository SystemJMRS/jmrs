package br.com.systemjmrs.controller;

import java.util.Date;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.systemjmrs.entity.Disciplina;
import br.com.systemjmrs.entity.Imagem;
import br.com.systemjmrs.entity.Questao;
import br.com.systemjmrs.entity.QuestaoTp;
import br.com.systemjmrs.entity.QuestaoStatus;
import br.com.systemjmrs.entity.Usuario;
import br.com.systemjmrs.repository.DisciplinaRepository;
import br.com.systemjmrs.repository.ImagemRepository;
import br.com.systemjmrs.repository.QuestaoRepository;
import br.com.systemjmrs.repository.QuestaoTPRepository;
import br.com.systemjmrs.repository.StorageService;
import br.com.systemjmrs.repository.UsuarioRepository;

@Controller
public class QuestaoController {

	@Autowired
	private QuestaoRepository qr;

	@Autowired
	private UsuarioRepository ur;

	@Autowired
	private QuestaoTPRepository qtpr;

	@Autowired
	private ImagemRepository imgRepository;
	
	@Autowired
	private DisciplinaRepository DisciplinaRepository;
	

	@Autowired
	StorageService storageService;

	@RequestMapping(value = "cadastrar-questao", method = RequestMethod.GET)
	public ModelAndView cadastrarQuestao() {
		ModelAndView modelAndView = new ModelAndView("/professor/cadastrar-questao");
		modelAndView.addObject("questaoTipos", qtpr.findAll());
		modelAndView.addObject("disciplinas", DisciplinaRepository.findAll());
		return modelAndView;
	}

	@RequestMapping(value = "cadastrar-questao", method = RequestMethod.POST)
	public ModelAndView cadastrarQuestao(@RequestParam("textoBase") String textoBase,
			@RequestParam("enunciado") String enunciado, @RequestParam("alternativa") String alternativa,
			@RequestParam("questaoTpId") Long questaoTpForm, @RequestParam("imagem") MultipartFile file,
			@RequestParam("usuario") Long usuarioForm, @RequestParam("disciplina") Long disciplinaForm) {

		Usuario usuario = ur.findOne(usuarioForm);
		Disciplina disciplina = DisciplinaRepository.findOne(usuarioForm);
		QuestaoTp questaoTp = qtpr.findOne(questaoTpForm);
		Date dataCriacao = new Date();
		Imagem imagem = new Imagem();

		Questao novaQuestao = new Questao(dataCriacao, textoBase, enunciado, alternativa, questaoTp, usuario, disciplina);

		qr.save(novaQuestao);

		imagem.setDiretorio("../../imagens/" + novaQuestao.getQuestaoId() + "_" + file.getOriginalFilename());
		storageService.store(file, novaQuestao);

		if (!file.isEmpty()) {
			imagem.setDataCriacao(dataCriacao);
			// imagem.setQuestao(novaQuestao);
			novaQuestao.addImagem(imagem);
			imgRepository.save(imagem);
		}

		return cadastrarQuestao();
	}

	@RequestMapping(value = "aprovar-reprovar-questao", method = RequestMethod.GET)
	public ModelAndView aprovarReprovarQuestao() {
		ModelAndView modelAndView = new ModelAndView("/coordenador/aprovar-reprovar-questao");

		modelAndView.addObject("questoes", qr.findAll());

		return modelAndView;
	}

	@RequestMapping(value = "aprovar-reprovar-questao-detalhes/editar/{id}", method = RequestMethod.GET)
	public ModelAndView aprovarReprovarQuestaoId(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("/coordenador/aprovar-reprovar-questao-detalhes");

		modelAndView.addObject("questao", qr.findOne((Long) id));
		modelAndView.addObject("imagens", imgRepository.findByQuestao(qr.findOne((Long) id)));

		return modelAndView;
	}

	@RequestMapping(value = "aprovar-reprovar-questao-detalhes/editar/{id}", method = RequestMethod.POST)
	public ModelAndView aprovarReprovarQuestaoIdGravar(@PathVariable Long id, @RequestParam("status") int status) {

		Questao novaQuestao = qr.findOne((Long) id);
		QuestaoStatus questaoStatus = QuestaoStatus.Default;
		questaoStatus = questaoStatus.getById(status);
		novaQuestao.setStatus(questaoStatus);

		qr.save(novaQuestao);

		return aprovarReprovarQuestao();
	}
}
