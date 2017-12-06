package br.com.systemjmrs.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the questao database table.
 * 
 */
@Entity
@NamedQuery(name="Questao.findAll", query="SELECT q FROM Questao q")
public class Questao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="questao_id")
	private int questaoId;

	@Temporal(TemporalType.DATE)
	@Column(name="data_criacao")
	private Date dataCriacao;

	@Lob
	private byte[] questao;

	@Column(name="questao_tp_id")
	private int questaoTpId;

	private String resposta;

	//bi-directional many-to-one association to Imagem
	@OneToMany(mappedBy="questao")
	private List<Imagem> imagems;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	public Questao() {
	}
	

	public int getQuestaoId() {
		return this.questaoId;
	}

	public Questao(int questaoId, Date dataCriacao, byte[] questao, int questaoTpId, String resposta, Usuario usuario) {
		super();
		this.questaoId = questaoId;
		this.dataCriacao = dataCriacao;
		this.questao = questao;
		this.questaoTpId = questaoTpId;
		this.resposta = resposta;
		this.usuario = usuario;
	}


	public void setQuestaoId(int questaoId) {
		this.questaoId = questaoId;
	}

	public Date getDataCriacao() {
		return this.dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public byte[] getQuestao() {
		return this.questao;
	}

	public void setQuestao(byte[] questao) {
		this.questao = questao;
	}

	public int getQuestaoTpId() {
		return this.questaoTpId;
	}

	public void setQuestaoTpId(int questaoTpId) {
		this.questaoTpId = questaoTpId;
	}

	public String getResposta() {
		return this.resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public List<Imagem> getImagems() {
		return this.imagems;
	}

	public void setImagems(List<Imagem> imagems) {
		this.imagems = imagems;
	}

	public Imagem addImagem(Imagem imagem) {
		getImagems().add(imagem);
		imagem.setQuestao(this);

		return imagem;
	}

	public Imagem removeImagem(Imagem imagem) {
		getImagems().remove(imagem);
		imagem.setQuestao(null);

		return imagem;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}