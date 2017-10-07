package br.com.systemjmrs.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario_tp database table.
 * 
 */
@Entity
@Table(name="usuario_tp")
@NamedQuery(name="UsuarioTp.findAll", query="SELECT u FROM UsuarioTp u")
public class UsuarioTp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="usuario_tp_id")
	private int usuarioTpId;

	private String descricao;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="usuarioTp")
	private List<Usuario> usuarios;

	public UsuarioTp() {
	}

	public int getUsuarioTpId() {
		return this.usuarioTpId;
	}

	public void setUsuarioTpId(int usuarioTpId) {
		this.usuarioTpId = usuarioTpId;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setUsuarioTp(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setUsuarioTp(null);

		return usuario;
	}

}