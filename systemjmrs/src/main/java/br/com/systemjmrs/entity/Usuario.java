package br.com.systemjmrs.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="usuario_id")
	private long usuarioId;

	@Temporal(TemporalType.DATE)
	@Column(name="data_criacao")
	private Date dataCriacao;

	private String email;

	private String login;

	private String senha;

	//bi-directional many-to-one association to Questao
	@OneToMany(mappedBy="usuario")
	private List<Questao> questoes;

	//bi-directional many-to-one association to UsuarioTp
	@ManyToOne
	@JoinColumn(name="usuario_tp_id")
	private UsuarioTp usuarioTp;

	public Usuario() {
	}

	public long getUsuarioId() {
		return this.usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Date getDataCriacao() {
		return this.dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Questao> getQuestaos() {
		return this.getQuestaos();
	}

	public void setQuestaos(List<Questao> questaos) {
		this.questoes = questaos;
	}

	public Questao addQuestao(Questao questao) {
		getQuestaos().add(questao);
		questao.setUsuario(this);

		return questao;
	}

	public Questao removeQuestao(Questao questao) {
		getQuestaos().remove(questao);
		questao.setUsuario(null);

		return questao;
	}

	public UsuarioTp getUsuarioTp() {
		return this.usuarioTp;
	}

	public void setUsuarioTp(UsuarioTp usuarioTp) {
		this.usuarioTp = usuarioTp;
	}

}