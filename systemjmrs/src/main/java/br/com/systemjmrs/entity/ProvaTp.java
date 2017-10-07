package br.com.systemjmrs.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the prova_tp database table.
 * 
 */
@Entity
@Table(name="prova_tp")
@NamedQuery(name="ProvaTp.findAll", query="SELECT p FROM ProvaTp p")
public class ProvaTp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="prova_tp_id")
	private int provaTpId;

	private String descricao;

	//bi-directional many-to-one association to Prova
	@OneToMany(mappedBy="provaTp")
	private List<Prova> provas;

	public ProvaTp() {
	}

	public int getProvaTpId() {
		return this.provaTpId;
	}

	public void setProvaTpId(int provaTpId) {
		this.provaTpId = provaTpId;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Prova> getProvas() {
		return this.provas;
	}

	public void setProvas(List<Prova> provas) {
		this.provas = provas;
	}

	public Prova addProva(Prova prova) {
		getProvas().add(prova);
		prova.setProvaTp(this);

		return prova;
	}

	public Prova removeProva(Prova prova) {
		getProvas().remove(prova);
		prova.setProvaTp(null);

		return prova;
	}

}