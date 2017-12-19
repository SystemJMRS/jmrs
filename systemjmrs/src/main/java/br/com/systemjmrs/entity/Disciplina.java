package br.com.systemjmrs.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the disciplina database table.
 * 
 */
@Entity
@NamedQuery(name="Disciplina.findAll", query="SELECT d FROM Disciplina d")
public class Disciplina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="disciplina_id")
	private Long disciplinaId;

	private String disciplina;
	
	@OneToMany(mappedBy="disciplina")
	private List<Questao> questoes;
	
	public Disciplina() {
	}

	public Long getDisciplinaId() {
		return this.disciplinaId;
	}

	public void setDisciplinaId(Long disciplinaId) {
		this.disciplinaId = disciplinaId;
	}

	public String getDisciplina() {
		return this.disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

}