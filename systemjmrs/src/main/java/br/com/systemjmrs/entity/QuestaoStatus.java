package br.com.systemjmrs.entity;

public enum QuestaoStatus {

	Default(0, "-"), Aprovada(1, "Aprovada"), Reprovada(2, "Reprovada");

	private int id;
	private String descricao;

	private QuestaoStatus(int id, String descricao) {

		this.id = id;
		this.descricao = descricao;

	}

	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	};

	public QuestaoStatus getById(int id) {
		for (QuestaoStatus e : values()) {
			if (e.id == id)
				return e;
		}
		return QuestaoStatus.Default;
	}
}
