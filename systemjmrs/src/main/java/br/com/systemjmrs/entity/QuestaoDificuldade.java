package br.com.systemjmrs.entity;

public enum QuestaoDificuldade {

	Facil(0, "Fácil"), Aprovada(1, "Aprovada"), Reprovada(2, "Reprovada");

	private int id;
	private String descricao;

	private QuestaoDificuldade(int id, String descricao) {

		this.id = id;
		this.descricao = descricao;

	}

	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	};

	public QuestaoDificuldade getById(int id) {
		for (QuestaoDificuldade e : values()) {
			if (e.id == id)
				return e;
		}
		return QuestaoDificuldade.Default;
	}
}
