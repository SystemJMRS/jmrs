package br.com.systemjmrs.entity;

import java.io.Serializable;
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
	private int disciplinaId;

	private String disciplina;

	public Disciplina() {
	}

	public int getDisciplinaId() {
		return this.disciplinaId;
	}

	public void setDisciplinaId(int disciplinaId) {
		this.disciplinaId = disciplinaId;
	}

	public String getDisciplina() {
		return this.disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

}