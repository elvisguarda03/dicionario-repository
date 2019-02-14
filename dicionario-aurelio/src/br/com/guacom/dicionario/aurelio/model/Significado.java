package br.com.guacom.dicionario.aurelio.model;

public class Significado {
	private Integer id;
	private String signi;
	private Palavra word;

	public Significado(Integer id, String signi, Palavra word) {
		if (id == null || signi == null || word == null)
			throw new IllegalArgumentException("Dados não foram cadastrados!");
		this.id = id;
		this.signi = signi;
		this.word = word;
	}

	public Significado(String signi, Palavra word) {
		if (signi == null || word == null)
			throw new IllegalArgumentException("Dados não foram cadastrados!");
		this.signi = signi;
		this.word = word;
	}

	public Significado(String signi) {
		if (signi == null)
			throw new IllegalArgumentException("Dados não foram cadastrados!");
		this.signi = signi;
	}

	public void setWord(Palavra word) {
		if(word == null)
			throw new IllegalArgumentException("Dados não foram cadastrados!");
		this.word = word;
	}

	public Integer getId() {
		return id;
	}

	public String getSigni() {
		return signi;
	}

	public Palavra getWord() {
		return word;
	}
	
	@Override
	public String toString() {
		return String.format("Palavra: %s - Significados: %s", word.getWord(), signi);
	}

	public void setId(Integer id) {
		if(id == null)
			throw new IllegalArgumentException();
		this.id = id;
	}
}