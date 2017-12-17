package br.com.systemjmrs.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * The persistent class for the questao database table.
 * 
 */
@Entity
@NamedQuery(name = "Questao.findAll", query = "SELECT q FROM Questao q")
public class Questao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "questao_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long questaoId;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "data_criacao")
	private Date dataCriacao;

	@Lob
	private String textoBase;

	@Lob
	private String enunciado;

	@Lob
	private String alternativa;

	@ManyToOne
	@JoinColumn(name = "questao_tp_id")
	private QuestaoTp questaoTp;

	// bi-directional many-to-one association to Imagem
	@OneToMany(mappedBy = "questao")
	private List<Imagem> imagens;

	// bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@Column(name = "status", columnDefinition = "INT(1) default 0", insertable = false, updatable = true)
	private QuestaoStatus status;

	public Questao() {
	}

	public long getQuestaoId() {
		return this.questaoId;
	}

	public Questao(Date dataCriacao, String textoBase, String enunciado, String alternativa, QuestaoTp questaoTp,
			Usuario usuario) {
		this.dataCriacao = dataCriacao;
		this.textoBase = textoBase;
		this.enunciado = enunciado;
		this.alternativa = alternativa;
		this.questaoTp = questaoTp;
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

	public String getTextoBase() {
		return textoBase;
	}

	public void setTextoBase(String textoBase) {
		this.textoBase = textoBase;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public String getAlternativa() {
		return alternativa;
	}

	public void setAlternativa(String alternativa) {
		this.alternativa = alternativa;
	}

	public QuestaoTp getQuestaoTp() {
		return this.questaoTp;
	}

	public void setQuestaoTp(QuestaoTp questaoTp) {
		this.questaoTp = questaoTp;
	}

	public List<Imagem> getImagens() {
		return this.imagens;
	}

	public void setImagems(List<Imagem> imagens) {
		this.imagens = imagens;
	}

	public Imagem addImagem(Imagem imagem) {
		//	getImagens().add(imagem);
		imagem.setQuestao(this);

		return imagem;
	}

	public Imagem removeImagem(Imagem imagem) {
		getImagens().remove(imagem);
		imagem.setQuestao(null);

		return imagem;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public QuestaoStatus getStatus() {
		return status;
	}

	public void setStatus(QuestaoStatus status) {
		this.status = status.getById(status.getId());
	}

}