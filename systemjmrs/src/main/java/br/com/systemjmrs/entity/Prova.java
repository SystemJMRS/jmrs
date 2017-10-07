package br.com.systemjmrs.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the prova database table.
 * 
 */
@Entity
@NamedQuery(name="Prova.findAll", query="SELECT p FROM Prova p")
public class Prova implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="prova_id")
	private int provaId;

	@Temporal(TemporalType.DATE)
	@Column(name="data_criacao")
	private Date dataCriacao;

	private String descricao;

	//bi-directional many-to-one association to ProvaTp
	@ManyToOne
	@JoinColumn(name="prova_tp_id")
	private ProvaTp provaTp;

	public Prova() {
	}

	public int getProvaId() {
		return this.provaId;
	}

	public void setProvaId(int provaId) {
		this.provaId = provaId;
	}

	public Date getDataCriacao() {
		return this.dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ProvaTp getProvaTp() {
		return this.provaTp;
	}

	public void setProvaTp(ProvaTp provaTp) {
		this.provaTp = provaTp;
	}

}