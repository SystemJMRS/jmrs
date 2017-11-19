package br.com.systemjmrs.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the aluno database table.
 * 
 */
@Entity
@NamedQuery(name="Aluno.findAll", query="SELECT a FROM Aluno a")
public class Aluno implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="aluno_id")
	private int alunoId;

	@Temporal(TemporalType.DATE)
	@Column(name="data_criacao")
	private Date dataCriacao;

	private String nome;

	private int ra;

	public Aluno() {
	}

	public int getAlunoId() {
		return this.alunoId;
	}

	public void setAlunoId(int alunoId) {
		this.alunoId = alunoId;
	}

	public Date getDataCriacao() {
		return this.dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getRa() {
		return this.ra;
	}

	public void setRa(int ra) {
		this.ra = ra;
	}

}