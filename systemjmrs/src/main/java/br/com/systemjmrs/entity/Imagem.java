package br.com.systemjmrs.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the imagem database table.
 * 
 */
@Entity
@NamedQuery(name="Imagem.findAll", query="SELECT i FROM Imagem i")
public class Imagem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="imagem_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long imagemId;

	@Temporal(TemporalType.DATE)
	@Column(name="data_criacao")
	private Date dataCriacao;

	private String diretorio;

	//bi-directional many-to-one association to Questao
	@ManyToOne
	@JoinColumn(name="questao_id")
	private Questao questao;

	public Imagem() {
	}

	public Long getImagemId() {
		return this.imagemId;
	}

	public Date getDataCriacao() {
		return this.dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getDiretorio() {
		return this.diretorio;
	}

	public void setDiretorio(String diretorio) {
		this.diretorio = diretorio;
	}

	public Questao getQuestao() {
		return this.questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

}